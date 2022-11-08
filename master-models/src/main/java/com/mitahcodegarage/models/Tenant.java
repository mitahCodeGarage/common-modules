package com.mitahcodegarage.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.util.Assert;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Document
public class Tenant {
    @Id
    private String id;

    @NotBlank(message = "Tenant name is mandatory")
    private String name;

    private boolean active = true;
    private boolean deleted = false;
    private List<Pipeline> pipelines;

    public Tenant(){}

    public Tenant(Builder builder) {
        this.name = builder.name;
        this.active = builder.active;
        this.deleted = builder.deleted;
        this.pipelines = builder.pipelines;
    }

    public static class Builder {
        private String name;
        private boolean active;
        private boolean deleted;
        private List<Pipeline> pipelines;

        private Builder(){
            pipelines = new ArrayList<>();
        }
        public static Builder newInstance() { return new Builder();}
        public Tenant build() { return new Tenant(this);}

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setActive(boolean active) {
            this.active = active;
            return this;
        }

        public Builder setDeleted(boolean deleted) {
            this.deleted = deleted;
            return this;
        }

        public Builder addToPipeline(Pipeline pipeline) {
            this.pipelines.add(pipeline);
            return this;
        }
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setDeleted(boolean deleted) {this.deleted = deleted;}

    public String getId() {
        return id;
    }

    public void setId(String id) {this.id = id;}

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return active;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public List<Pipeline> getPipelines() {
        return pipelines;
    }

    public void addPipeline(Pipeline pipeline) {
        if(null == this.pipelines) {
            this.pipelines = new ArrayList<>();
        }
        this.pipelines.add(pipeline);
    }
}
