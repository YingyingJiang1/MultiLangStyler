package org.example.utils;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FileCollection {


    List<FileSet> fileSets = new ArrayList<>();
    int size = 0; // number of files

    public FileCollection() {

    }

    public FileCollection(List<FileSet> fileSets) {
        this.fileSets = fileSets;
        if (fileSets != null) {
            for (FileSet fileSet : fileSets) {
                size += fileSet.size();
            }
        }
    }

    public void add(Path file) {
        String dir = file.getParent().toString();
        String fileName = file.getFileName().toString();
        for (FileSet fileSet : fileSets) {
            if (fileSet.dir.equals(dir)) {
                fileSet.fileNames.add(fileName);
                size++;
                return;
            }
        }
        FileSet fileSet = new FileSet(dir, new ArrayList<>());
        fileSet.fileNames.add(fileName);
        fileSets.add(fileSet);
        size++;
    }

    public boolean contains(String path) {
        String dir = Paths.get(path).getParent().toString();
        String fileName = Paths.get(path).getFileName().toString();
        return getFileSet(dir).fileNames.contains(fileName);
    }

    public void clear() {
        fileSets.clear();
        size = 0;
    }

    public int size() {
        return size;
    }

    public String getFilePath(int i) {
        for (FileSet fileSet : fileSets) {
            if (i < fileSet.size()) {
                return fileSet.getFilePath(i);
            } else {
                i -= fileSet.size();
            }
        }
        return "";
    }

    public void difference(FileCollection collection) {
        for (FileSet fileSet : fileSets) {
            FileSet fileSet1 = collection.getFileSet(fileSet.dir);
            if (fileSet1 != null) {
                Iterator<String> iterator = fileSet.fileNames.iterator();
                while (iterator.hasNext()) {
                    if (fileSet1.fileNames.contains(iterator.next())) {
                        iterator.remove();
                    }
                }
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (FileSet fileSet : fileSets) {
            sb.append(fileSet.dir).append(":").append(fileSet.fileNames.toString()).append("\n");
        }
        return sb.toString();
    }

    public boolean isEmpty() {
        for (FileSet fileSet : fileSets) {
            if (fileSet.size() > 0) {
                return false;
            }
        }
        return true;
    }

    private FileSet getFileSet(String dir) {
        for (FileSet fileSet : fileSets) {
            if (fileSet.dir.equals(dir)) {
                return fileSet;
            }
        }
        return null;
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
            if (i < fileNames.size()) {
                return dir + File.separator + fileNames.get(i);
            }
            return "";
        }
    }
}
