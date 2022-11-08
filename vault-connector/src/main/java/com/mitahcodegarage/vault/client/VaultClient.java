package com.mitahcodegarage.vault.client;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

import javax.net.ssl.SSLContext;
import java.security.NoSuchAlgorithmException;

public class VaultClient {
    public static CloseableHttpClient getDefaultClient() {
        return HttpClients.createDefault();
    }

    public static CloseableHttpClient getSSLCustomClient() throws NoSuchAlgorithmException {
        HttpClientBuilder builder = HttpClients.custom();
        builder.setSSLContext(SSLContext.getDefault());
        builder.setConnectionManager(new PoolingHttpClientConnectionManager());
        return builder.build();
    }
}
