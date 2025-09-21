class Main {
    // M1125
    private ApiResponse dispatchRequest(ApiAction action, ApiRequest apiRequest, Session session) throws ApiException {
        switch (action) {
            case EXEC:
                return processExecRequest(apiRequest, session);
            case ASYNC_EXEC:
                return processAsyncExecRequest(apiRequest, session);
            case INTERRUPT_JOB:
                return processInterruptJob(apiRequest, session);
            case PULL_RESULTS:
                return processPullResultsRequest(apiRequest, session);
            case SESSION_INFO:
                return processSessionInfoRequest(apiRequest, session);
            case JOIN_SESSION:
                return processJoinSessionRequest(apiRequest, session);
            case CLOSE_SESSION:
                return processCloseSessionRequest(apiRequest, session);
            case INIT_SESSION:
                break;
        }
        return null;
    }


    // M504
    private void drawMBeanAttributes(CommandProcess process, Map<String, List<MBeanAttributeVO>> mbeanAttributeMap) {
        for (Map.Entry<String, List<MBeanAttributeVO>> entry : mbeanAttributeMap.entrySet()) {
            String objectName = entry.getKey();
            List<MBeanAttributeVO> attributeVOList = entry.getValue();

            TableElement table = new TableElement().leftCellPadding(1).rightCellPadding(1);
            table.row(true, "OBJECT_NAME", objectName);
            table.row(true, label("NAME").style(Decoration.bold.bold()),
                    label("VALUE").style(Decoration.bold.bold()));

            for (MBeanAttributeVO attributeVO : attributeVOList) {
                String attributeName = attributeVO.getName();
                String valueStr;
                if (attributeVO.getError() != null) {
                    valueStr = RenderUtil.render(new LabelElement(attributeVO.getError()).style(Decoration.bold_off.fg(Color.red)));
                } else {
                    //convert array to list
                    // TODO support all array type
                    Object value = attributeVO.getValue();
                    if (value instanceof String[]) {
                        value = Arrays.asList((String[]) value);
                    } else if (value instanceof Integer[]) {
                        value = Arrays.asList((Integer[]) value);
                    } else if (value instanceof Long[]) {
                        value = Arrays.asList((Long[]) value);
                    } else if (value instanceof int[]) {
                        value = convertArrayToList((int[]) value);
                    } else if (value instanceof long[]) {
                        value = convertArrayToList((long[]) value);
                    }
                    //to string
                    valueStr = String.valueOf(value);
                }
                table.row(attributeName, valueStr);
            }
            process.write(RenderUtil.render(table, process.width()));
            process.write("\n");
        }
    }


    // M15
    public static int startArthasClient(String arthasHomeDir, List<String> telnetArgs, OutputStream out) throws Throwable {
        // start java telnet client
        // find arthas-client.jar
        URLClassLoader classLoader = new URLClassLoader(
                new URL[]{new File(arthasHomeDir, "arthas-client.jar").toURI().toURL()});
        Class<?> telnetConsoleClass = classLoader.loadClass("com.taobao.arthas.client.TelnetConsole");
        Method processMethod = telnetConsoleClass.getMethod("process", String[].class);

        //redirect System.out/System.err
        PrintStream originSysOut = System.out;
        PrintStream originSysErr = System.err;
        PrintStream newOut = new PrintStream(out);
        PrintStream newErr = new PrintStream(out);

        // call TelnetConsole.process()
        // fix https://github.com/alibaba/arthas/issues/833
        ClassLoader tccl = Thread.currentThread().getContextClassLoader();
        try {
            System.setOut(newOut);
            System.setErr(newErr);
            Thread.currentThread().setContextClassLoader(classLoader);
            return (Integer) processMethod.invoke(null, new Object[]{telnetArgs.toArray(new String[0])});
        } catch (Throwable e) {
            //java.lang.reflect.InvocationTargetException : java.net.ConnectException
            e = e.getCause();
            if (e instanceof IOException || e instanceof InterruptedException) {
                // ignore connection error and interrupted error
                return STATUS_ERROR;
            } else {
                // process error
                AnsiLog.error("process error: {}", e.toString());
                AnsiLog.error(e);
                return STATUS_EXEC_ERROR;
            }
        } finally {
            Thread.currentThread().setContextClassLoader(tccl);

            //reset System.out/System.err
            System.setOut(originSysOut);
            System.setErr(originSysErr);
            //flush output
            newOut.flush();
            newErr.flush();
        }
    }


    // M493
    private void renderNode(StringBuilder sb, TraceNode node, Ansi highlighted) {
        //render cost: [0.366865ms]
        if (isPrintCost && node instanceof MethodNode) {
            MethodNode methodNode = (MethodNode) node;

            String costStr = renderCost(methodNode);
            if (node == maxCostNode) {
                // the node with max cost will be highlighted
                sb.append(highlighted.a(costStr).reset().toString());
            } else {
                sb.append(costStr);
            }
        }

        //render method name
        if (node instanceof MethodNode) {
            MethodNode methodNode = (MethodNode) node;
            //clazz.getName() + ":" + method.getName() + "()"
            sb.append(methodNode.getClassName()).append(":").append(methodNode.getMethodName()).append("()");
            // #lineNumber
            if (methodNode.getLineNumber() != -1) {
                sb.append(" #").append(methodNode.getLineNumber());
            }
        } else if (node instanceof ThreadNode) {
            //render thread info
            ThreadNode threadNode = (ThreadNode) node;
            //ts=2020-04-29 10:34:00;thread_name=main;id=1;is_daemon=false;priority=5;TCCL=sun.misc.Launcher$AppClassLoader@18b4aac2
            sb.append(format("ts=%s;thread_name=%s;id=%d;is_daemon=%s;priority=%d;TCCL=%s",
                    DateUtils.formatDateTime(threadNode.getTimestamp()),
                    threadNode.getThreadName(),
                    threadNode.getThreadId(),
                    threadNode.isDaemon(),
                    threadNode.getPriority(),
                    threadNode.getClassloader()));

            //trace_id
            if (threadNode.getTraceId() != null) {
                sb.append(";trace_id=").append(threadNode.getTraceId());
            }
            if (threadNode.getRpcId() != null) {
                sb.append(";rpc_id=").append(threadNode.getRpcId());
            }
        } else if (node instanceof ThrowNode) {
            ThrowNode throwNode = (ThrowNode) node;
            sb.append("throw:").append(throwNode.getException())
                    .append(" #").append(throwNode.getLineNumber())
                    .append(" [").append(throwNode.getMessage()).append("]");

        } else {
            throw new UnsupportedOperationException("unknown trace node: " + node.getClass());
        }
    }


    // M753
    public List<ThreadVO> sample(Collection<ThreadVO> originThreads) {

        List<ThreadVO> threads = new ArrayList<ThreadVO>(originThreads);

        // Sample CPU
        if (lastCpuTimes.isEmpty()) {
            lastSampleTimeNanos = System.nanoTime();
            for (ThreadVO thread : threads) {
                if (thread.getId() > 0) {
                    long cpu = threadMXBean.getThreadCpuTime(thread.getId());
                    lastCpuTimes.put(thread, cpu);
                    thread.setTime(cpu / 1000000);
                }
            }

            // add internal threads
            Map<String, Long> internalThreadCpuTimes = getInternalThreadCpuTimes();
            if (internalThreadCpuTimes != null) {
                for (Map.Entry<String, Long> entry : internalThreadCpuTimes.entrySet()) {
                    String key = entry.getKey();
                    ThreadVO thread = createThreadVO(key);
                    thread.setTime(entry.getValue() / 1000000);
                    threads.add(thread);
                    lastCpuTimes.put(thread, entry.getValue());
                }
            }

            //sort by time
            Collections.sort(threads, new Comparator<ThreadVO>() {
                @Override
                public int compare(ThreadVO o1, ThreadVO o2) {
                    long l1 = o1.getTime();
                    long l2 = o2.getTime();
                    if (l1 < l2) {
                        return 1;
                    } else if (l1 > l2) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
            });
            return threads;
        }

        // Resample
        long newSampleTimeNanos = System.nanoTime();
        Map<ThreadVO, Long> newCpuTimes = new HashMap<ThreadVO, Long>(threads.size());
        for (ThreadVO thread : threads) {
            if (thread.getId() > 0) {
                long cpu = threadMXBean.getThreadCpuTime(thread.getId());
                newCpuTimes.put(thread, cpu);
            }
        }
        // internal threads
        Map<String, Long> newInternalThreadCpuTimes = getInternalThreadCpuTimes();
        if (newInternalThreadCpuTimes != null) {
            for (Map.Entry<String, Long> entry : newInternalThreadCpuTimes.entrySet()) {
                ThreadVO threadVO = createThreadVO(entry.getKey());
                threads.add(threadVO);
                newCpuTimes.put(threadVO, entry.getValue());
            }
        }

        // Compute delta time
        final Map<ThreadVO, Long> deltas = new HashMap<ThreadVO, Long>(threads.size());
        for (ThreadVO thread : newCpuTimes.keySet()) {
            Long t = lastCpuTimes.get(thread);
            if (t == null) {
                t = 0L;
            }
            long time1 = t;
            long time2 = newCpuTimes.get(thread);
            if (time1 == -1) {
                time1 = time2;
            } else if (time2 == -1) {
                time2 = time1;
            }
            long delta = time2 - time1;
            deltas.put(thread, delta);
        }

        long sampleIntervalNanos = newSampleTimeNanos - lastSampleTimeNanos;

        // Compute cpu usage
        final HashMap<ThreadVO, Double> cpuUsages = new HashMap<ThreadVO, Double>(threads.size());
        for (ThreadVO thread : threads) {
            double cpu = sampleIntervalNanos == 0 ? 0 : (Math.rint(deltas.get(thread) * 10000.0 / sampleIntervalNanos) / 100.0);
            cpuUsages.put(thread, cpu);
        }

        // Sort by CPU time : should be a rendering hint...
        Collections.sort(threads, new Comparator<ThreadVO>() {
            @Override
            public int compare(ThreadVO o1, ThreadVO o2) {
                long l1 = deltas.get(o1);
                long l2 = deltas.get(o2);
                if (l1 < l2) {
                    return 1;
                } else if (l1 > l2) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        for (ThreadVO thread : threads) {
            //nanos to mills
            long timeMills = newCpuTimes.get(thread) / 1000000;
            long deltaTime = deltas.get(thread) / 1000000;
            double cpu = cpuUsages.get(thread);

            thread.setCpu(cpu);
            thread.setTime(timeMills);
            thread.setDeltaTime(deltaTime);
        }
        lastCpuTimes = newCpuTimes;
        lastSampleTimeNanos = newSampleTimeNanos;

        return threads;
    }
}

