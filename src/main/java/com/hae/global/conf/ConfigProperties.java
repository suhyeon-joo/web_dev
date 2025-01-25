package com.hae.global.conf;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConfigProperties {
    @Value("${jwt.secret.key}")
    private String secretKeyValue;
    @Value("${jwt.accessToken.expiration}")
    private Integer accessTokenExpirationValue;

    @Value("${jwt.refreshToken.expiration}")
    private Integer refreshTokenExpirationValue;

    public static String secretKey;

    public static Integer accessTokenExpiration;

    public static Integer refreshTokenExpiration;

    @PostConstruct
    public void init(){
        secretKey = secretKeyValue;
        accessTokenExpiration = accessTokenExpirationValue;
        refreshTokenExpiration= refreshTokenExpirationValue;
    }
}
