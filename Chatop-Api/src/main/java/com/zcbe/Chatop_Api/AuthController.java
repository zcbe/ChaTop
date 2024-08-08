package com.zcbe.chatop_api;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private final String secretKey = "1234567890"; // Clé secrète pour signer les jetons

    @GetMapping("/generate-token")
    public String generateToken(@RequestParam String username) {
        return Jwts.builder()
                .setSubject(username)
                .claim("role", "USER") // Exemple de rôle ajouté au jeton
                .signWith(SignatureAlgorithm.HS256, secretKey.getBytes())
                .compact();
    }
}
