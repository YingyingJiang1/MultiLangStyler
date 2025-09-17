    @Override
    public void process(final CommandProcess process) {
        try {
            Instrumentation inst = process.session().getInstrumentation();

            if (VmToolAction.getInstances.equals(action)) {
                if (className == null) {
                    process.end(-1, "The className option cannot be empty!");
                    return;
                }
                ClassLoader classLoader = null;
                if (hashCode != null) {
                    classLoader = ClassLoaderUtils.getClassLoader(inst, hashCode);
                    if (classLoader == null) {
                        process.end(-1, "Can not find classloader with hashCode: " + hashCode + ".");
                        return;
                    }
                }else if ( classLoaderClass != null) {
                    List<ClassLoader> matchedClassLoaders = ClassLoaderUtils.getClassLoaderByClassName(inst,
                            classLoaderClass);
                    if (matchedClassLoaders.size() == 1) {
                        classLoader = matchedClassLoaders.get(0);
                        hashCode = Integer.toHexString(matchedClassLoaders.get(0).hashCode());
                    } else if (matchedClassLoaders.size() > 1) {
                        Collection<ClassLoaderVO> classLoaderVOList = ClassUtils
                                .createClassLoaderVOList(matchedClassLoaders);

                        VmToolModel vmToolModel = new VmToolModel().setClassLoaderClass(classLoaderClass)
                                .setMatchedClassLoaders(classLoaderVOList);
                        process.appendResult(vmToolModel);
                        process.end(-1,
                                "Found more than one classloader by class name, please specify classloader with '-c <classloader hash>'");
                        return;
                    } else {
                        process.end(-1, "Can not find classloader by class name: " + classLoaderClass + ".");
                        return;
                    }
                }else {
                    classLoader = ClassLoader.getSystemClassLoader();
                }

                List<Class<?>> matchedClasses = new ArrayList<Class<?>>(
                        SearchUtils.searchClassOnly(inst, className, false, hashCode));
                int matchedClassSize = matchedClasses.size();
                if (matchedClassSize == 0) {
                    process.end(-1, "Can not find class by class name: " + className + ".");
                    return;
                } else if (matchedClassSize > 1) {
                    process.end(-1, "Found more than one class: " + matchedClasses + ", please specify classloader with '-c <classloader hash>'");
                    return;
                } else {
                    Object[] instances = vmToolInstance().getInstances(matchedClasses.get(0), limit);
                    Object value = instances;
                    if (express != null) {
                        Express unpooledExpress = ExpressFactory.unpooledExpress(classLoader);
                        try {
                            value = unpooledExpress.bind(new InstancesWrapper(instances)).get(express);
                        } catch (ExpressException e) {
                            logger.warn("ognl: failed execute express: " + express, e);
                            process.end(-1, "Failed to execute ognl, exception message: " + e.getMessage()
                                    + ", please check $HOME/logs/arthas/arthas.log for more details. ");
                        }
                    }

                    VmToolModel vmToolModel = new VmToolModel().setValue(new ObjectVO(value, expand));
                    process.appendResult(vmToolModel);
                    process.end();
                }
            } else if (VmToolAction.forceGc.equals(action)) {
                vmToolInstance().forceGc();
                process.write("\n");
                process.end();
                return;
            } else if (VmToolAction.interruptThread.equals(action)) {
                vmToolInstance().interruptSpecialThread(threadId);
                process.write("\n");
                process.end();

                return;
            }

            process.end();
        } catch (Throwable e) {
            logger.error("vmtool error", e);
            process.end(1, "vmtool error: " + e.getMessage());
        }
    }
