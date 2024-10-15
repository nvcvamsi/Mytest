package com.example.vaultapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VaultController {

    @Autowired
    private VaultService vaultService;

    // API to write a secret to Vault
    @PostMapping("/write-secret")
    public String writeSecret(@RequestParam String secretPath,
                              @RequestParam String key,
                              @RequestParam String value) {
        return vaultService.writeSecret(secretPath, key, value);
    }

    // API to read a secret from Vault
    @GetMapping("/read-secret")
    public String readSecret(@RequestParam String secretPath,
                             @RequestParam String key) {
        return vaultService.readSecret(secretPath, key);
    }
}
