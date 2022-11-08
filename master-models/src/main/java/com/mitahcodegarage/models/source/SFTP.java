package com.mitahcodegarage.models.source;

public class SFTP extends Source {
    private String host;
    private String username;
    private String password;
    private FileConfig fileConfig;

    public SFTP(SFTPBuilder sftpBuilder) {
        super(sftpBuilder);
        this.host = sftpBuilder.host; this.username = sftpBuilder.username; this.password = sftpBuilder.password;
        this.fileConfig = sftpBuilder.fileConfig;
    }

    public static class SFTPBuilder extends Source.Builder {
        private String host;
        private String username;
        private String password;
        private FileConfig fileConfig;

        private SFTPBuilder(){ super();}
        public SFTPBuilder newInstance(){ return new SFTPBuilder();}
        public SFTP build(){ return new SFTP(this);}

        public Builder setHost(String host){ this.host = host; return this;}
        public Builder setUsername(String username){ this.username = username; return this;}
        public Builder setPassword(String password){ this.password = password; return this;}
        public Builder setFileConfig(FileConfig fileConfig){ this.fileConfig = fileConfig; return this;}

    }
}
