package com.pocencryptor.encryptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.security.crypto.encrypt.Encryptors;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class EncryptorApplication {

    private static Logger log =
            LoggerFactory.getLogger(EncryptorApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(EncryptorApplication.class, args);

        String password = "7110eda4d09e062aa5e4a390b0a572ac0d2c0220";
        String salt = "d5f12e53a182c062b6bf30c1445153faff12269a";

        String encrypt = Encryptors.text(password, salt).encrypt("abcd");
        log.info("ENCRYPT: {}", encrypt);

        String descrypt = Encryptors.text(password, salt).decrypt(encrypt);
        log.info("DECRYPT: {}", descrypt);
    }

}
