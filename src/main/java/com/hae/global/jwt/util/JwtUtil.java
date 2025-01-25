package com.hae.global.jwt.util;

import com.hae.global.conf.ConfigProperties;
import com.hae.has.user.model.EsaUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import com.hae.global.jwt.enums.Token;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtUtil {
    @Value("${jwt.secret.key}")
    private String secretKey;

    private SecretKey key;

    @PostConstruct
    public void init() {this.key= Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey));}

    public String generateToken(EsaUser user, String tokenRole){

        return Jwts.builder()
                .subject(user.getUsrNm())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis()
                + (tokenRole.equals(Token.REFRESH_TOKEN.getCategory())?
                        ConfigProperties.refreshTokenExpiration:ConfigProperties.accessTokenExpiration)))
                .signWith(key)
                .claim("id", user.getSysId())
                .claim("user_id",user.getUsrId())
                .claim("role", user.getJobRole())
                .compact();
    }

    public Claims extractClaims(String token){
        return Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getPayload();
    }

    public String extractUsername(String token){
        return extractClaims(token).getSubject();
    }

    public String extractId(String token){
        return extractClaims(token).get("sys_id", String.class);
    }
    public String extractUserId(String token){
        return extractClaims(token).get("usr_id", String.class);
    }
    public String extractUserRole(String token){
        return extractClaims(token).get("job_role",String.class);
    }
    public boolean isTokenExpired(String token){
        return extractClaims(token).getExpiration().before(new Date());
    }

    public boolean validateToken(String token){
        if(isTokenExpired(token)){
            log.info("JWT token is expired");
            return false;
        }
        else
            return true;
    }
}
