package com.mitahcodegarage.models.source;

import com.mitahcodegarage.models.InterfaceType;
import org.springframework.data.annotation.Transient;

public class Source {
    private String id;
    private boolean active;
    private InterfaceType type;
    private String hostIp;
    private boolean useCredentials;
    private FileConfig file;

    @Transient private String username;
    @Transient private String password;

    public Source(){}

    public Source(Builder builder){
        this.id = builder.id; this.active = builder.active; this.type = builder.type;
    }

    public static class Builder{
        private String id;
        private boolean active;
        private InterfaceType type;

        public Builder(){}
        public Builder newInstance(){ return new Builder();}
        public Source build(){ return new Source(this);}

        public Builder setId(String id) { this.id = id; return this;}
        public Builder setActive(boolean active) { this.active = active; return this;}
        public Builder setType(InterfaceType type) { this.type = type; return this;}
    }

    public String getId() {
        return id;
    }

    public boolean isActive() {
        return active;
    }

    public InterfaceType getType() {
        return type;
    }

    public String getHostIp() {
        return hostIp;
    }

    public boolean isUseCredentials() {
        return useCredentials;
    }

    public void setUseCredentials(boolean useCredentials) {
        this.useCredentials = useCredentials;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public FileConfig getFile() {
        return file;
    }
}
