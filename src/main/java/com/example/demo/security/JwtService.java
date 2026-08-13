package com.example.demo.security;

import com.example.demo.exception.InvalidTokenException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Slf4j
@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String secretKey;

    //TODO: refine and improve JWT secret security
    private SecretKey getSignKey() {
        return Keys.hmacShaKeyFor(secretKey.getBytes());
    }

    public String tokenGenerator (String username) {
        return Jwts.builder()
                .subject(username)
                .issuedAt(new Date())
                .expiration(new Date (System.currentTimeMillis() + 1000 * 60 * 20))
                .signWith(getSignKey())
                .compact();
    }

    public String extractTheUsername (String token) {
        return Jwts.parser()
                .verifyWith(getSignKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

    public boolean isTokenValid(String token) {
        try {
            Jwts.parser()
                    .verifyWith(getSignKey())
                    .build()
                    .parseSignedClaims(token);
            return true;
        } catch (Exception ex){
            return false;
        }
    }

}
