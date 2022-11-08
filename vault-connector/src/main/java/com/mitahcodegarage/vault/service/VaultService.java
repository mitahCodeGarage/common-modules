package com.mitahcodegarage.vault.service;

import com.mitahcodegarage.vault.model.VaultSecrets;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.support.Policy;

import java.util.List;

public class VaultService {

    private VaultTemplate vaultTemplate;
    private final String basePath = "adaptive-secret/data/";

    public VaultService(VaultTemplate vaultTemplate) {
        this.vaultTemplate = vaultTemplate;
    }

    public void addPolicy(String tenantName) {
        tenantName = tenantName.toLowerCase();
        Policy.Rule rule = Policy.Rule.builder()
                .path(basePath + tenantName)
                .capabilities(Policy.BuiltinCapabilities.CREATE, Policy.BuiltinCapabilities.READ, Policy.BuiltinCapabilities.LIST)
                .build();
        Policy policy = Policy.of(rule);
        vaultTemplate.opsForSys().createOrUpdatePolicy(tenantName + "-policy", policy);
    }

    // TODO : Add role with above policy

    public List<String> getAllPolicies() {
        return vaultTemplate.opsForSys().getPolicyNames();
    }

    public void addSecret(String templateName, String path, Object secret) {
        String completePath = basePath + templateName.toLowerCase() + path;
        vaultTemplate.write(completePath, secret);
    }

    public String getSecret(String templateName, String path, String key) {
        String completePath = basePath + templateName.toLowerCase() + path;
        VaultSecrets secrets = vaultTemplate.read(completePath, VaultSecrets.class).getData();
        return secrets.getData().get(key);
    }

    public VaultSecrets getSecret(String templateName, String path) {
        String completePath = basePath + templateName.toLowerCase() + path;
        VaultSecrets secrets = vaultTemplate.read(completePath, VaultSecrets.class).getData();
        return secrets;
    }
}
