package org.example.styler;

import java.io.File;
import java.io.FilenameFilter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

/*
 * @description
 * @author       Yingying Jiang
 * @create       2024/4/2 15:08
 */
public class FileCollector {
  public static final int MAX_FILE_COUNT = 1000;

  public static FileCollection getJavaFileCollection(List<String> paths) {
    List<FileSet> fileSets = new ArrayList<>();
    for(String path : paths) {
      List<FileSet> tmpFileSets = new ArrayList<>();
      getFileRecursivelyIf(path, tmpFileSets, new Predicate<File>() {
        @Override
        public boolean test(File file) {
          return file.getName().endsWith(".java");
        }
      });

      // Merge two file sets.
      tmpFileSets.forEach(ele -> {
        boolean addFlag = true;
        for(FileSet fileSet : fileSets) {
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

  private static void getFileRecursivelyIf(String path, List<FileSet> fileSets, Predicate<File> cond) {
    File file = new File(path);
    List<String> fileNames = new ArrayList<>();
    if (file.isFile()) {
      fileNames.add(file.getName());
      fileSets.add(new FileSet(file.getParent(), fileNames));
      return;
    }

    if (file.listFiles() == null) {
      System.out.println(path);
      return;
    }
    for(File subFile : file.listFiles()) {
      if(subFile.isFile() && cond.test(subFile)) {
        fileNames.add(subFile.getName());
      }
    }
    if (!fileNames.isEmpty()) {
      fileSets.add(new FileSet(path, fileNames));
    }

    for(File subFile : file.listFiles()) {
      if(subFile.isDirectory()) {
        getFileRecursivelyIf(subFile.getAbsolutePath(), fileSets, cond);
      }
    }
  }


  public static FileCollection getJavaFileCollection(String dir, List<String> filenames) {

    List<FileSet> fileSets = new ArrayList<>();
    fileSets.add(new FileSet(dir, filenames));
    return new FileCollection(fileSets);
  }

  public static List<String> getJavaFileCollection(String path) {
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

  public static class FileSet {
    String dir;
    List<String> fileNames;

    public FileSet(String dir, List<String> fileNames) {
      this.dir = dir;
      this.fileNames = fileNames;
    }

    public int size() {
      return fileNames.size();
    }

    public String getFilePath(int i) {
      if(i < fileNames.size()) {
        return dir + File.separator +  fileNames.get(i);
      }
      return "";
    }
  }

  public static class FileCollection {


    List<FileSet> fileSets = new ArrayList<>();
    int size = 0;

    public FileCollection() {

    }

    public FileCollection(List<FileSet> fileSets) {
      this.fileSets = fileSets;
      if (fileSets != null) {
        for(FileSet fileSet : fileSets) {
          size += fileSet.size();
        }
      }
    }

    public boolean contains(String path) {
      String dir = Paths.get(path).getParent().toString();
      String fileName = Paths.get(path).getFileName().toString();
      return getFileSet(dir).fileNames.contains(fileName);
    }

    public int size() {
      return size;
    }

    public String getFilePath(int i) {
      for(FileSet fileSet : fileSets) {
        if( i < fileSet.size()) {
          return fileSet.getFilePath(i);
        } else {
          i -= fileSet.size();
        }
      }
      return "";
    }

    public void difference(FileCollection collection) {
      for(FileSet fileSet : fileSets) {
        FileSet fileSet1 = collection.getFileSet(fileSet.dir);
        if (fileSet1 != null) {
          Iterator<String> iterator = fileSet.fileNames.iterator();
          while (iterator.hasNext()) {
            if(fileSet1.fileNames.contains(iterator.next())) {
              iterator.remove();
            }
          }
        }
      }
    }

    public String toString() {
      StringBuilder sb = new StringBuilder();
      for(FileSet fileSet : fileSets) {
        sb.append(fileSet.dir).append(":").append(fileSet.fileNames.toString()).append("\n");
      }
      return sb.toString();
    }

    public boolean isEmpty() {
      for(FileSet fileSet : fileSets) {
        if(fileSet.size() > 0) {
          return false;
        }
      }
      return true;
    }

    private FileSet getFileSet(String dir) {
      for(FileSet fileSet : fileSets) {
        if(fileSet.dir.equals(dir)) {
          return fileSet;
        }
      }
      return null;
    }
  }
}
