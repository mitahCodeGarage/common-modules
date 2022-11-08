package com.mitahcodegarage.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class RequestStatusRecord {
    @Id
    private String requestId;
    private String tenantId;
    private String pipelineId;
    private String sourceId;
    private long receivedDate;
    private String filename;
    private String status;

    public static final class Builder {
        private String requestId;
        private String tenantId;
        private String pipelineId;
        private String sourceId;
        private long receivedDate;
        private String filename;
        private String status;

        private Builder() {
        }

        public static Builder aRequestStatusRecord() {
            return new Builder();
        }

        public Builder withRequestId(String requestId) {
            this.requestId = requestId;
            return this;
        }

        public Builder withTenantId(String tenantId) {
            this.tenantId = tenantId;
            return this;
        }

        public Builder withPipelineId(String pipelineId) {
            this.pipelineId = pipelineId;
            return this;
        }

        public Builder withSourceId(String sourceId) {
            this.sourceId = sourceId;
            return this;
        }

        public Builder withReceivedDate(long receivedDate) {
            this.receivedDate = receivedDate;
            return this;
        }

        public Builder withFilename(String filename) {
            this.filename = filename;
            return this;
        }

        public Builder withStatus(String status) {
            this.status = status;
            return this;
        }

        public RequestStatusRecord build() {
            RequestStatusRecord requestStatusRecord = new RequestStatusRecord();
            requestStatusRecord.pipelineId = this.pipelineId;
            requestStatusRecord.receivedDate = this.receivedDate;
            requestStatusRecord.sourceId = this.sourceId;
            requestStatusRecord.status = this.status;
            requestStatusRecord.tenantId = this.tenantId;
           requestStatusRecord.filename = this.filename;
            requestStatusRecord.requestId = this.requestId;
            return requestStatusRecord;
        }
    }

    public String getRequestId() {
        return requestId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public String getPipelineId() {
        return pipelineId;
    }

    public String getSourceId() {
        return sourceId;
    }

    public long getReceivedDate() {
        return receivedDate;
    }

    public String getFilename() {
        return filename;
    }

    public String getStatus() {
        return status;
    }
}

