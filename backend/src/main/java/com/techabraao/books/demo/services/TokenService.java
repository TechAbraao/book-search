package com.techabraao.books.demo.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.techabraao.books.demo.models.UsersModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.UUID;

@Service
public class TokenService {
    private final String secret;
    private final String issuer;

    public TokenService(
            @Value("${spring.security.token.secret}") String secret,
            @Value("${spring.security.token.issuer}") String issuer
    ) {
        this.secret = secret;
        this.issuer = issuer;
    }

    public String generateToken(UsersModel user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            String token = JWT.create()
                    .withIssuer(issuer)
                    .withSubject(user.getEmail())
                    .withClaim("role", String.valueOf(user.getRole()))
                    .withExpiresAt(generateExpirationDate())
                    .withIssuedAt(generateIssuedAtDate())
                    .withJWTId(UUID.randomUUID().toString())
                    .sign(algorithm);
            return token;
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Erro while generating token: " + exception.getMessage());
        }
    };

    public String validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer(issuer)
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException exception) {
            throw new JWTVerificationException("Invalid token: " + exception.getMessage());
        }
    }

    private Instant generateExpirationDate() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
    private Instant generateIssuedAtDate() {
        return LocalDateTime.now().toInstant(ZoneOffset.of("-03:00"));
    }
}
