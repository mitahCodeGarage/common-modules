package com.mitahcodegarage.models;

import com.mitahcodegarage.models.destination.Destination;
import com.mitahcodegarage.models.source.Source;

public class Pipeline {
    private String id;
    private String name;
    private boolean active;
    private Source source;
    private Destination destination;
    private boolean submitted;

    public Pipeline(){}

    public Pipeline(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.active = builder.active;
        this.source = builder.source;
        this.destination = builder.destination;
    }

    public static class Builder{
        private String id;
        private String name;
        private boolean active;
        private Source source;
        private Destination destination;

        public static Builder newInstance() { return new Builder();}

        private Builder(){}

        public Pipeline build() { return new Pipeline(this);}

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setActive(boolean active) {
            this.active = active;
            return this;
        }

        public Builder setSource(Source source) {
            this.source = source;
            return this;
        }

        public Builder setDestination(Destination destination) {
            this.destination = destination;
            return this;
        }
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Source getSource() {
        return source;
    }

    public Destination getDestination() {
        return destination;
    }

    public boolean isSubmitted() {
        return submitted;
    }

    public void setSubmitted(boolean submitted) {
        this.submitted = submitted;
    }

    public void setId(String id) {
        this.id = id;
    }
}
