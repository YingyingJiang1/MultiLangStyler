package org.example.analysis.io;

import java.util.ArrayList;
import java.util.List;

public class InputPair {
    private String problemName;
    private List<String> authors;
    private List<String> files = new ArrayList<String>();

    public InputPair(String problemName, String file1, String file2) {
        this.problemName = problemName;
        files.add(file1);
        files.add(file2);
    }

    public String getFile1() {
        return files.get(0);
    }

    public String getFile2() {
        return files.get(1);
    }
}
