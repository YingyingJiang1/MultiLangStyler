package org.example.styler;

public class ModelAdapter {

    private static ModelAdapter instance = new ModelAdapter();

    public static ModelAdapter getInstance() {
        return instance;
    }

    private ModelAdapter() {}

    public String callModel(String prompt) {
        return null;
    }


}
