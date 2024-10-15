package com.example.vaultapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.vault.authentication.TokenAuthentication;
import org.springframework.vault.client.VaultEndpoint;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.web.client.RestTemplate;

@Configuration
public class VaultConfig {

    @Bean
    public VaultTemplate vaultTemplate() {
        // You can customize VaultEndpoint if needed
        VaultEndpoint vaultEndpoint = VaultEndpoint.create("localhost", 8200);
        TokenAuthentication tokenAuthentication = new TokenAuthentication("<your-vault-token>");
        
        // Create VaultTemplate with token authentication
        return new VaultTemplate(vaultEndpoint, tokenAuthentication);
    }
}
