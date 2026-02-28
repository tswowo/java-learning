package org.javaweb.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;

public class JWTUtils {


    static String keyStr = "TheJWTSecretTheJWTSecretTheJWTSecretTheJWTSecretTheJWTSecret";

    /**
     * 生成 JWT令牌
     */
    public static String generateJwt(Map<String, Object> dataMap) {
        SecretKey secretKey = Keys.hmacShaKeyFor((keyStr.substring(0, 32).getBytes(StandardCharsets.UTF_8)));
        return Jwts.builder()
                .signWith(secretKey)
                .claims(dataMap)
                .expiration(new Date(System.currentTimeMillis() + 3600 * 1000))
                .compact();
    }


    /**
     * 解析 JWT令牌
     */
    public static Claims parseToken(String token) throws Exception {
        SecretKey secretKey = Keys.hmacShaKeyFor((keyStr.substring(0, 32).getBytes(StandardCharsets.UTF_8)));

        return Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
}