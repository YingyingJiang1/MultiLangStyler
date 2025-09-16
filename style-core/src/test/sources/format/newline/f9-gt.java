  private AsyncProfiler profilerInstance() {
    if (profiler != null) {
      return profiler;
    }

    // try to load from special path
    if (ProfilerAction.load.toString().equals(action)) {
      profiler = AsyncProfiler.getInstance(this.actionArg);
    }

    if (libPath != null) {
      // load from arthas directory
      // 尝试把lib文件复制到临时文件里，避免多次attach时出现 Native Library already loaded in another classloader
      FileOutputStream tmpLibOutputStream = null;
      FileInputStream libInputStream = null;
      try {
        File tmpLibFile = File.createTempFile(VmTool.JNI_LIBRARY_NAME, null);
        tmpLibOutputStream = new FileOutputStream(tmpLibFile);

        libInputStream = new FileInputStream(libPath);
        IOUtils.copy(libInputStream, tmpLibOutputStream);
        libPath = tmpLibFile.getAbsolutePath();
        logger.debug("copy {} to {}", libPath, tmpLibFile);
      } catch (Throwable e) {
        logger.error("try to copy lib error! libPath: {}", libPath, e);
      } finally {
        IOUtils.close(libInputStream);
        IOUtils.close(tmpLibOutputStream);
      }
      profiler = AsyncProfiler.getInstance(libPath);
    } else {

      if (OSUtils.isLinux() || OSUtils.isMac()) {
        throw new IllegalStateException("Can not find libasyncProfiler so, please check the arthas directory.");
      } else {
        throw new IllegalStateException("Current OS do not support AsyncProfiler, Only support Linux/Mac.");
      }
    }

    return profiler;
  }
