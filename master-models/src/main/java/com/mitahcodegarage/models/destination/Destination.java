package com.mitahcodegarage.models.destination;

import com.mitahcodegarage.models.InterfaceType;
import org.springframework.data.annotation.Transient;

public class Destination {
    private String id;
    private boolean active;
    private InterfaceType type;
    private String hostIp;
    private boolean useCredentials;

    @Transient private String username;
    @Transient private String password;

    public Destination(){}

    public Destination(Builder builder) {
        this.id = builder.id; this.active = builder.active; this.type = builder.type;
    }

    public static class Builder {
        private String id;
        private boolean active;
        private InterfaceType type;

        public Builder(){}
        public Builder newInstance(){ return new Builder();}
        public Destination build(){ return new Destination(this);}

        public Builder setId(String id) { this.id = id; return this;}
        public Builder setActive(boolean active) { this.active = active; return this;}
        public Builder setType(InterfaceType sourceType) { this.type = type; return this;}
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public InterfaceType getType() {
        return type;
    }

    public void setType(String type) {
        this.type = InterfaceType.valueOf(type);
    }

    public String getHostIp() {
        return hostIp;
    }

    public void setHostIp(String hostIp) {
        this.hostIp = hostIp;
    }

    public boolean isUseCredentials() {
        return useCredentials;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
