package com.mitahcodegarage.models.datadefinition;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class DataField {

    @NotNull
    private int index;

    @NotBlank
    private String name;
    private boolean mandatory = false;
    private int length;

    @NotNull
    private DataType dataType;
    private String description;

    public String getName() {
        return name;
    }

    public boolean isMandatory() {
        return mandatory;
    }

    public int getLength() {
        return length;
    }

    public String getDescription() {
        return description;
    }

    public DataType getDataType() { return dataType; }

    public int getIndex() { return index; }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMandatory(boolean mandatory) {
        this.mandatory = mandatory;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setDataType(DataType dataType) {
        this.dataType = dataType;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
