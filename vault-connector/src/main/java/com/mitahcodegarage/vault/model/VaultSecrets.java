package com.mitahcodegarage.vault.model;

import java.util.HashMap;
import java.util.Map;

public class VaultSecrets {
    private Map<String, String> data;

    public VaultSecrets() {
        this.data = new HashMap<>();
    }

    public Map<String, String> getData() {
        return data;
    }

    public void setData(Map<String, String> data) {
        this.data = data;
    }

    public void setData(String key, String data) {
        this.data.put(key, data);
    }
}
