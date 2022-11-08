package com.mitahcodegarage.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Document
public class Batch<D> implements Serializable {

    @Id
    private String batchId;
    private String tenantId;
    private String pipelineId;
    private String sourceId;
    private String requestId;
    private List<D> data;

    public Batch(String tenantId, String pipelineId, String sourceId, String requestId, String batchId) {
        this.tenantId = tenantId; this.pipelineId = pipelineId; this.sourceId = sourceId;
        this.requestId= requestId; this.batchId = batchId;
        this.data = new ArrayList<>();
    }

    public void addData(D data) {
        this.data.add(data);
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

    public String getRequestId() {
        return requestId;
    }

    public String getBatchId() {
        return batchId;
    }

    public List<D> getData() {
        return data;
    }
}
