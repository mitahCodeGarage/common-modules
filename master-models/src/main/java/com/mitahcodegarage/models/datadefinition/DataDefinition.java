package com.mitahcodegarage.models.datadefinition;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class DataDefinition {
    @Id
    private String id;
    private String tenantId;
    private String sourceId;
    private String pipelineId;
    private boolean deleted;
    private List<DataField> datafields;

    public String getId() {
        return id;
    }

    public void setId(String id) {this.id = id;}

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public List<DataField> getDatafields() {
        return datafields;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public String getTenantId() {return tenantId;}

    public String getPipelineId() {
        return pipelineId;
    }

    public void setPipelineId(String pipelineId) {
        this.pipelineId = pipelineId;
    }

    public void setDatafields(List<DataField> datafields) {
        this.datafields = datafields;
    }
}
