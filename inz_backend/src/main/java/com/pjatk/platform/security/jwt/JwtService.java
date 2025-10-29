package com.pjatk.platform.security.jwt;

import com.pjatk.platform.security.services.UserDetailsImpl;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Component
public class JwtService {

    private final static Logger LOGGER = LoggerFactory.getLogger(JwtService.class);

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.expiration}")
    private Duration jwtExpiration;


    public String getUsernameFromToken(String token){
        Claims claims = Jwts.parser()
                .verifyWith(getSignInKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();

        return claims.getSubject();
    }

    public boolean validateJwtToken(String token){
        try {
            Jwts.parser()
                    .verifyWith(getSignInKey())
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();

            return true;
        }catch (ExpiredJwtException e){
            LOGGER.error("token expired", e);
        }catch (UnsupportedJwtException e){
            LOGGER.error("token unsupported", e);
        }catch (MalformedJwtException e){
            LOGGER.error("token malformed", e);
        }catch (SecurityException e){
            LOGGER.error("token security exception", e);
        }catch (Exception e){
            LOGGER.error("invalid exception", e);
        }
        return false;
    }

    public String generateJwtToken(Authentication authentication){
        UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();
        Date issuedDate = Date.from(LocalDateTime.now().plusMinutes(jwtExpiration.toMinutes()).atZone(ZoneId.systemDefault()).toInstant());
        return Jwts.builder()
                .subject(userPrincipal.getUsername())
                .expiration(issuedDate)
                .signWith(getSignInKey())
                .compact();
    }

    private String generateRefreshToken(String username){
        Date issuedDate = Date.from(LocalDateTime.now().plusDays(7).atZone(ZoneId.systemDefault()).toInstant());
        return Jwts.builder()
                .subject(username)
                .expiration(issuedDate)
                .signWith(getSignInKey())
                .compact();
    }

    private SecretKey getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(jwtSecret);
        return Keys.hmacShaKeyFor(keyBytes);
    }


}
