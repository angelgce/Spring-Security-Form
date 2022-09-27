package com.example.login.app.models.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

@Configuration
@EnableAuthorizationServer
// #7 extend Auhorization ServConf
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    // #8 inject BCrypted (we already created on SpringSecConf class)
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    // #9 inject the AuMan, we have to create a bean of this on SpringSecConfig
    private AuthenticationManager authenticationManager;

    // #10 -> go to Spring SecConfig class
    // #11 overide all the configure methods

    // #12 validate the token
    // this method get the credentials of the user and validate if everyting well
    // and returns the token
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        // authenticationManager -> we injected before
        // accessTokenConverter -> save the credentials of the user tranlsate the info
        // from the token to the jpa info

        endpoints.authenticationManager(authenticationManager)
                .accessTokenConverter((accessTokenConverter()));
    }

    // #13 creating the method JwtAccessTokenConverter
    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
        // #16 go to openssl and get the private and public key and create JwtConfig
        // class
        jwtAccessTokenConverter.setSigningKey(JwtConfig.RSA_PRIVATE);
        jwtAccessTokenConverter.setVerifierKey(JwtConfig.RSA_PUBLIC);
        return jwtAccessTokenConverter;
    }

    // #14 Client configuration
    // password of the app (angular,react,android)
    // and users credentials
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory().withClient("angularapp")
                .secret(passwordEncoder.encode("password"))
                .scopes("read", "write")
                .authorizedGrantTypes("password", "refresh_token")
                .accessTokenValiditySeconds(3600)
                .refreshTokenValiditySeconds(3600);
    }

    // #15 configuation of our endpoints
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()");
    }

}
