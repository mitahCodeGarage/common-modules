package com.mitahcodegarage.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mitahcodegarage.models.status.enumeration.BatchStatus;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document
public class BatchStatusRecord implements Serializable {

    private String batchId;
    private String requestId;
    private int recordsReceived;
    private long createdOn;
    private long lastModifiedOn;
    private BatchStatus batchStatus;


    public static final class Builder {
        private String batchId;
        private String requestId;
        private int recordsReceived;
        private long createdOn;
        private long lastModifiedOn;
        private BatchStatus batchStatus;

        private Builder() {
        }

        public static Builder aBatchStatusRecord() {
            return new Builder();
        }

        public Builder withBatchId(String batchId) {
            this.batchId = batchId;
            return this;
        }

        public Builder withRequestId(String requestId) {
            this.requestId = requestId;
            return this;
        }

        public Builder withRecordsReceived(int recordsReceived) {
            this.recordsReceived = recordsReceived;
            return this;
        }

        public Builder withCreatedOn(long createdOn) {
            this.createdOn = createdOn;
            return this;
        }

        public Builder withLastModifiedOn(long lastModifiedOn) {
            this.lastModifiedOn = lastModifiedOn;
            return this;
        }

        public Builder withBatchStatus(BatchStatus batchStatus) {
            this.batchStatus = batchStatus;
            return this;
        }

        public BatchStatusRecord build() {
            BatchStatusRecord batchStatusRecord = new BatchStatusRecord();
            batchStatusRecord.requestId = this.requestId;
            batchStatusRecord.lastModifiedOn = this.lastModifiedOn;
            batchStatusRecord.recordsReceived = this.recordsReceived;
            batchStatusRecord.createdOn = this.createdOn;
            batchStatusRecord.batchId = this.batchId;
            batchStatusRecord.batchStatus = this.batchStatus;
            return batchStatusRecord;
        }
    }

    public String getBatchId() {
        return batchId;
    }

    public String getRequestId() {
        return requestId;
    }

    public int getRecordsReceived() {
        return recordsReceived;
    }

    public long getCreatedOn() {
        return createdOn;
    }

    public long getLastModifiedOn() {
        return lastModifiedOn;
    }

    public BatchStatus getBatchStatus() {
        return batchStatus;
    }

    public String asJson() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(this);
    }

    public void setBatchStatus(BatchStatus batchStatus) {
        this.batchStatus = batchStatus;
    }

    public void setLastModifiedOn(long lastModifiedOn) {
        this.lastModifiedOn = lastModifiedOn;
    }
}