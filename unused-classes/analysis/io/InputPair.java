package org.example.analysis.io;

public class InputPair {
    private String problemID;
    private String problemNumber;
    private String[] authors;
    private String[] files;

    public InputPair(String problemNumber, String problemID, String[] authors, String[] files) {
        this.problemID = problemID;
        this.problemNumber = problemNumber;
        this.authors = authors;
        this.files = files;
    }

    public String getFile1() {
        return files[0];
    }

    public String getFile2() {
        return files[1];
    }

    public String getAuthor1() {
        return authors[0];
    }

    public String getAuthor2() {
        return authors[1];
    }

    public String getProblemId() {
        return problemID;
    }

    public String[] getAuthors() {
        return authors;
    }
}
