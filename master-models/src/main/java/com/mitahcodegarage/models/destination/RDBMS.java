package com.mitahcodegarage.models.destination;

public class RDBMS extends Destination {
    private DatabaseType dataBaseType;
    private String host;
    private String port;
    private String databaseName;
    private String username;
    private String password;

    public RDBMS(RDBMSBuilder rdbmsBuilder){
        super(rdbmsBuilder);
        this.dataBaseType = rdbmsBuilder.dataBaseType; this.host = rdbmsBuilder.host;
        this.port = rdbmsBuilder.port; this.databaseName = rdbmsBuilder.databaseName;
        this.username = rdbmsBuilder.username; this.password = rdbmsBuilder.password;
    }

    public static class RDBMSBuilder extends Destination.Builder{
        private DatabaseType dataBaseType;
        private String host;
        private String port;
        private String databaseName;
        private String username;
        private String password;

        private RDBMSBuilder(){}
        public RDBMSBuilder newInstance() { return new RDBMSBuilder();}
        public RDBMS build() { return new RDBMS(this);}

        public Builder setDatabaseType(DatabaseType dataBaseType) { this.dataBaseType = dataBaseType; return this;}
        public Builder setHost(String host) { this.host = host; return this;}
        public Builder setPort(String port) { this.port = port; return this;}
        public Builder setDatabaseName(String databaseName) { this.databaseName = databaseName; return this;}
        public Builder setUsername(String username) { this.username = username; return this;}
        public Builder setPassword(String password) { this.password = password; return this;}
    }

}
