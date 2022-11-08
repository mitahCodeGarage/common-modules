package com.mitahcodegarage.vault.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.vault.authentication.AppRoleAuthentication;
import org.springframework.vault.authentication.AppRoleAuthenticationOptions;
import org.springframework.vault.client.VaultClients;
import org.springframework.vault.client.VaultEndpoint;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.web.client.RestOperations;
import com.mitahcodegarage.vault.exception.VaultConnectionNotFoundException;

import java.util.HashMap;
import java.util.Map;

@Service
public class VaultConnectionService {

    @Value("${host}")
    private String host;

    @Value("${port}")
    private int port;

    @Value("${useAppRole:true}")
    private boolean useAppRole;

    @Value("${scheme:https}")
    private String scheme;

    private ClientHttpRequestFactory clientHttpRequestFactory;
    private Map<String, VaultTemplate> vaultConnections = new HashMap<>();

    public VaultConnectionService(ClientHttpRequestFactory clientHttpRequestFactory) {
        this.clientHttpRequestFactory = clientHttpRequestFactory;
    }

    public void createVaultConnection(String tenantName, String roleId, String secretId) {
        createAndGetVaultConnection(tenantName, roleId, secretId);
    }

    public VaultTemplate createAndGetVaultConnection(String tenantName, String roleId, String secretId) {
        return vaultConnections.putIfAbsent(tenantName, vaultTemplate(roleId, secretId));
    }

    public VaultTemplate getVaultConnection(String tenantName) {
        if(vaultConnections.containsKey(tenantName))
            return vaultConnections.get(tenantName);
        else
            throw new VaultConnectionNotFoundException("");
    }

    private VaultTemplate vaultTemplate(String roleId, String secretId) {
        return new VaultTemplate(vaultEndpoint(), appRoleAuthentication(roleId, secretId));
    }

    private VaultEndpoint vaultEndpoint() {
        VaultEndpoint vaultEndpoint =  VaultEndpoint.create(host, port);
        vaultEndpoint.setScheme(scheme);
        return vaultEndpoint;
    }

    protected AppRoleAuthentication appRoleAuthentication(String roleId, String secretId) {
        if (useAppRole && StringUtils.isNotBlank(roleId) && StringUtils.isNotBlank(secretId)) {
            final AppRoleAuthenticationOptions options = AppRoleAuthenticationOptions.builder()
                    .roleId(AppRoleAuthenticationOptions.RoleId.provided(roleId))
                    .secretId(AppRoleAuthenticationOptions.SecretId.provided(secretId))
                    .build();
            return new AppRoleAuthentication(options, this.restOperations());
        }
        return null;
    }

    private RestOperations restOperations() {
        return VaultClients.createRestTemplate(vaultEndpoint(), clientHttpRequestFactory);
    }
}
