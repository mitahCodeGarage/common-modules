package com.mitahcodegarage.vault.service;

import com.mitahcodegarage.vault.exception.SecureStorageException;
import org.apache.commons.lang3.StringUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * Access the vault secure storage.
 *
 * @author Hatim Motorwala
 *
 */
public class SecureVaultStorage {

    //private static final Logger logger = LoggerFactory.getLogger(SecureVaultStorage.class);
    private final Map<String, String> itemCache;
    private final VaultStorageAccessor vaultStorageAccessor;

    public SecureVaultStorage(final VaultStorageAccessor vaultStorageAccessor) {
        this.vaultStorageAccessor = vaultStorageAccessor;
        itemCache = new HashMap<String, String>();
    }

    /**
     * fetches value from the Vault
     *
     * @throws SecureStorageException if value not found or if value is blank
     */
    public String getValue(String key) throws SecureStorageException {
        Assert.isNull(key, "key is null");
        key = key.toLowerCase();
        String value;

        if (!itemCache.containsKey(key)) {
            try {
                value = vaultStorageAccessor.get(key);
            } catch (SecureStorageException sseException) {
                //logger.info("Vault value not found for key [{}]", key);
                throw sseException;
            }
            if (StringUtils.isBlank(value)) {
                throw new SecureStorageException("Value of key [" + key + "] not found!");
            }
            itemCache.put(key, value);
        }
        return itemCache.get(key);
    }
}
