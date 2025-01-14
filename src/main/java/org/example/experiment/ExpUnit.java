package org.example.experiment;

public class ExpUnit {
    public Solution src;
    public Solution target;
    public Solution result;

    public static class Solution {
        public String problem_id;
        public String file_name;
        public String author_type;
        public String author_name;
        public boolean correct;
    }
}
