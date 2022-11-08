package com.mitahcodegarage.vault.configuration;

import com.mitahcodegarage.vault.service.VaultConnectionService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;


@Configuration
@Import(value = com.mitahcodegarage.api.HttpClientConfig.class)
@PropertySource("file:properties/vault.properties")
public class VaultConfiguration {

    //@Autowired
    //private HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory;

    @Bean
    public VaultConnectionService vaultConnectionService(HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory) {
        return new VaultConnectionService(httpComponentsClientHttpRequestFactory);
    }
}
