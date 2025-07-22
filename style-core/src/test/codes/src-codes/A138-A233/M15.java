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
