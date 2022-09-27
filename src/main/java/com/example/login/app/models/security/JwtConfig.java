package com.example.login.app.models.security;

public class JwtConfig {

        // #1 openssl genrsa -out jwt.pem
        // #2 openssl rsa -in jwt.pem
        public static final String RSA_PRIVATE = "-----BEGIN RSA PRIVATE KEY-----\r\n" +
                        "-----END RSA PRIVATE KEY-----\r\n";

        // #3 openssl rsa -in jwt.pem -pubout
        public static final String RSA_PUBLIC = "-----BEGIN PUBLIC KEY-----\r\n" +
                        "-----END PUBLIC KEY-----";
}
