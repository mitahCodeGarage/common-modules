package com.mitahcodegarage.models.source;

public class FileConfig {
    private String path;
    private String namePattern;
    private String delimiter;
    private boolean zipped;

    public FileConfig(){}

    public FileConfig(Builder builder) {
        this.path = builder.path; this.namePattern = builder.namePattern; this.delimiter = builder.delimiter;
    }

    public static class Builder {
        private String path;
        private String namePattern;
        private String delimiter;

        private Builder(){}
        public Builder newInstance(){ return new Builder();}
        public FileConfig build() { return new FileConfig(this);}

        public Builder setPath(String path){ this.path = path; return this;}
        public Builder setNamePattern(String namePattern){ this.namePattern = namePattern; return this;}
        public Builder setDelimiter(String delimiter){ this.delimiter = delimiter; return this;}
    }

    public String getPath() {
        return path;
    }

    public String getNamePattern() {
        return namePattern;
    }

    public String getDelimiter() {
        return delimiter;
    }

    public boolean isZipped() {
        return zipped;
    }
}
