package com.hae.global.jwt.enums;

import lombok.Getter;
import com.hae.global.conf.ConfigProperties;
@Getter
public enum Token {
    ACCESS_TOKEN("accessToken", ConfigProperties.accessTokenExpiration),
    REFRESH_TOKEN("refreshToken", ConfigProperties.refreshTokenExpiration),;

    private final String category;
    private final long expiration;

    Token(String tokenCategory, int expiration){

        this.category = tokenCategory;
        this.expiration = expiration;
    }
}
