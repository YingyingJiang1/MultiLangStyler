package org.example.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/4/2 15:08
 */
public class FileCollector {
  public static Logger logger = LoggerFactory.getLogger(FileCollector.class);
  public static final int MAX_FILE_COUNT = 1000;

  public static FileCollection getJavaFileCollection(List<String> paths) {
    List<FileCollection.FileSet> fileSets = new ArrayList<>();
    for(String path : paths) {
      List<FileCollection.FileSet> tmpFileSets = new ArrayList<>();
      getFileRecursivelyIf(path, tmpFileSets, new Predicate<File>() {
        @Override
        public boolean test(File file) {
          return file.getName().endsWith(".java");
        }
      });

      // Merge two file sets.
      tmpFileSets.forEach(ele -> {
        boolean addFlag = true;
        for(FileCollection.FileSet fileSet : fileSets) {
          if (fileSet.dir.equals(ele.dir)) {
            fileSet.fileNames.addAll(ele.fileNames);
            addFlag = false;
            break;
          }
        }
        if(addFlag) {
          fileSets.add(ele);
        }
      });
    }
    return new FileCollection(fileSets);
  }

  private static void getFileRecursivelyIf(String path, List<FileCollection.FileSet> fileSets, Predicate<File> cond) {
    File file = new File(path);
    List<String> fileNames = new ArrayList<>();
    if (!file.exists()) {
      logger.warn("File {} doesn't exist.", path);
    }
    if (file.isFile()) {
      fileNames.add(file.getName());
      fileSets.add(new FileCollection.FileSet(file.getParent(), fileNames));
      return;
    }

    if (file.listFiles() == null) {
      return;
    }
    for(File subFile : file.listFiles()) {
      if(subFile.isFile() && cond.test(subFile)) {
        fileNames.add(subFile.getName());
      }
    }
    if (!fileNames.isEmpty()) {
      fileSets.add(new FileCollection.FileSet(path, fileNames));
    }

    for(File subFile : file.listFiles()) {
      if(subFile.isDirectory()) {
        getFileRecursivelyIf(subFile.getAbsolutePath(), fileSets, cond);
      }
    }
  }


  private static FileCollection getJavaFileCollection(String dir, List<String> filenames) {

    List<FileCollection.FileSet> fileSets = new ArrayList<>();
    fileSets.add(new FileCollection.FileSet(dir, filenames));
    return new FileCollection(fileSets);
  }

  private static List<String> getJavaFileCollection(String path) {
    File file = new File(path);
    List<String> ret = new ArrayList<>();
    getAllFiles(file, ".java", ret);
    return ret;
  }

  private static void getAllFiles(File file, String fileSuffix, List<String> resFileNames) {
    if(file.isFile() && file.getName().endsWith(fileSuffix)) {
      resFileNames.add(file.getName());
    } else if(file.isDirectory()) {
      for(File file1 : file.listFiles()) {
        getAllFiles(file1, fileSuffix, resFileNames);
      }
    }
  }

  private void getAllFiles(String path, String fileSuffix, String excludePath, List<String> resFilePaths) {
    String[] files = path.split(";");
    String[] excludes = excludePath.split(";");
    for (int i = 0; i < excludes.length; i++) {
      excludes[i] = excludes[i].replace(".", "\\.").replace("*", ".*");
    }
    for (String filePath : files) {
      if(filePath.endsWith("/")) {
        filePath = filePath.substring(0, filePath.length() - 1);
      }
      int lastSlash = filePath.lastIndexOf("/");
      getAllFiles(filePath.substring(0, lastSlash + 1),
          filePath.substring(lastSlash + 1), excludes, resFilePaths);
    }
  }

  private void getAllFiles(String filePath, String fileName,  String[] excludes, List<String> resFilePaths) {
    final String filterStr = fileName.replace(".", "\\.").replace("*", ".*");;
    boolean useWildCard = fileName.contains("*");
    String absPath = filePath;


    if(!useWildCard) {
      absPath = filePath + fileName;
    }

    File file = new File(absPath);
    if(file.isDirectory()) {
      String[] fileNames = file.list(new FilenameFilter() {
        @Override
        public boolean accept(File dir, String name) {
          return !useWildCard || name.matches(filterStr);
        }
      });
      for(String name : fileNames) {
        getAllFiles(absPath + "/", name, excludes, resFilePaths);
      }
    } else if(fileName.endsWith(".java") && !isExcluded(absPath, excludes)) {
      resFilePaths.add(absPath);
    }
  }

  private boolean isExcluded(String file, String[] excludes) {
    for (int i = 0; i < excludes.length; i++) {
      if(file.matches(excludes[i])) {
        return true;
      }
    }
    return false;
  }

}
