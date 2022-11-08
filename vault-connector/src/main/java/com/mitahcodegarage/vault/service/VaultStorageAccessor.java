package com.mitahcodegarage.vault.service;

import org.springframework.vault.core.VaultTemplate;

import java.util.List;


public class VaultStorageAccessor {

    VaultTemplate vaultTemplate;
    String path;

    public VaultStorageAccessor(VaultTemplate vaultTemplate, String path) {
        this.vaultTemplate = vaultTemplate;
        this.path = path;
    }

    public String get(String key) {
        return vaultTemplate.read(path, String.class).getData();
    }

    public List<String> list(String key) {
        return vaultTemplate.list(path);
    }

    public void write(String key, String value) { vaultTemplate.write(key, value); }
}
