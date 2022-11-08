package com.mitahcodegarage.vault.configuration;

import org.springframework.beans.factory.annotation.Value;

public class HttpClientConfigurationOld {

    @Value("${connector.vault.httpclient.com.mitahcodegarage.rdbms.config.connection.maxConnectionsPerRoute:100}")
    private int httpConnectionMaxConnectionsPerRoute;

    @Value("${connector.vault.httpclient.com.mitahcodegarage.rdbms.config.connection.maxTotalConnections:100}")
    private int httpConnectionMaxTotalConnections;

   /* @Bean
    private ClientHttpRequestFactory clientHttpRequestFactory() {
        if (clientHttpRequestFactory == null) {
            try {
               *//* HttpClientFactoryBean com.mitahcodegarage.kafkapublish.factory = new HttpClientFactoryBean();
                com.mitahcodegarage.kafkapublish.factory.setConnectTimeout(httpConnectionConnectTimeout);
                com.mitahcodegarage.kafkapublish.factory.setSocketTimeout(httpConnectionSocketTimeout);
                com.mitahcodegarage.kafkapublish.factory.setCookieSpec(CookieSpecs.IGNORE_COOKIES);
                com.mitahcodegarage.kafkapublish.factory.setHttpClientConnectionManager(poolingHttpClientConnectionManager());
                com.mitahcodegarage.kafkapublish.factory.setMetricRegistry(metricRegistry);
                com.mitahcodegarage.kafkapublish.factory.setHttpClientName("vaultHttpClient");
                final HttpClient httpClient = com.mitahcodegarage.kafkapublish.factory.getObject();*//*
                clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(null);
            } catch (Exception e) {
                throw new RuntimeException("Could not create HttpClient for vault", e);
            }
        }
        return clientHttpRequestFactory;
    }

    private HttpClientConnectionManager poolingHttpClientConnectionManager() {
        // Secured HttpClient thread pool
        HttpClientConnectionManagerFactoryBean httpClientConnectionManagerFactoryBean = new HttpClientConnectionManagerFactoryBean();
        try {
            httpClientConnectionManagerFactoryBean.setSslContext(SSLContext.getDefault());
            httpClientConnectionManagerFactoryBean.setMaxConnPerRoute(httpConnectionMaxConnectionsPerRoute);
            httpClientConnectionManagerFactoryBean.setMaxConnTotal(httpConnectionMaxTotalConnections);
            //httpClientConnectionManagerFactoryBean.setConnectionManagerName("vaultConnMan");
            return httpClientConnectionManagerFactoryBean.getObject();
        } catch (Exception e) {
            throw new RuntimeException("Could not create PoolingHttpClientConnectionManager for vault", e);
        }
    }*/
}
