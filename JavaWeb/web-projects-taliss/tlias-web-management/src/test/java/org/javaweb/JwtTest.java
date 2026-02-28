package org.javaweb;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.Test;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class JwtTest {
    String keyStr = "TheJWTSecretTheJWTSecretTheJWTSecretTheJWTSecretTheJWTSecret";

    /**
     * 生成 JWT令牌
     */
    @Test
    public void testGenerateJwt() {
        SecretKey secretKey = Keys.hmacShaKeyFor((keyStr.substring(0, 32).getBytes(StandardCharsets.UTF_8)));
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("id", 114514);
        dataMap.put("username", "admin");
        String jwt = Jwts.builder()
                .signWith(secretKey)
                .claims(dataMap)
                .expiration(new Date(System.currentTimeMillis() + 3600 * 1000))
                .compact();
        System.out.println(jwt);
    }

    /**
     * 解析 JWT令牌
     */
    @Test
    public void testParseJwt() throws Exception {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MTE0NTE0LCJ1c2VybmFtZSI6ImFkbWluIiwiZXhwIjoxNzcwODI2MzA0fQ.1RzO_2AXL9tWlZbmWChDFnCVdLDTAFlkYdkGAldCGJk";
        SecretKey secretKey = Keys.hmacShaKeyFor((keyStr.substring(0, 32).getBytes(StandardCharsets.UTF_8)));

        Claims claims = Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload();
        System.out.println(claims);
    }
}
