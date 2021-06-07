package com.perez.ptbackend.core.providers;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;
import com.perez.ptbackend.core.constants.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class TokenProvider {

    private static final Logger logger = LoggerFactory.getLogger(TokenProvider.class);

    @Value("${security.jwtSecret}")
    private String jwtSecret;

    @Value("${security.jwtExpirationInMs}")
    private int jwtExpirationInMs;

    @Value("${security.issuer}")
    private String issuer;

    private TokenProvider() {}

    public String generateToken(Authentication authentication) {
        // Genera el token con roles, issuer, fecha, expiración (8h)
        final String authorities = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority).collect(Collectors.joining(","));
        return Jwts.builder().setSubject(authentication.getName())
                .claim(Constant.AUTHORITIES_KEY, authorities)
                .signWith(SignatureAlgorithm.HS256, jwtSecret)
                .setIssuedAt(new Date(System.currentTimeMillis())).setIssuer(issuer)
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationInMs * 1000))
                .compact();
    }

    public UsernamePasswordAuthenticationToken getAuthentication(final String token,
            final UserDetails userDetails) {

        final JwtParser jwtParser = Jwts.parser().setSigningKey(jwtSecret);

        final Jws<Claims> claimsJws = jwtParser.parseClaimsJws(token);

        final Claims claims = claimsJws.getBody();

        final Collection<SimpleGrantedAuthority> authorities =
                Arrays.stream(claims.get(Constant.AUTHORITIES_KEY).toString().split(","))
                        .map(SimpleGrantedAuthority::new).collect(Collectors.toList());

        return new UsernamePasswordAuthenticationToken(userDetails, "", authorities);
    }

    public String getUserName(final String token) {
        final JwtParser jwtParser = Jwts.parser().setSigningKey(jwtSecret);

        final Jws<Claims> claimsJws = jwtParser.parseClaimsJws(token);

        return claimsJws.getBody().getSubject();
    }

    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException ex) {
            logger.error("Invalid JWT signature");
        } catch (MalformedJwtException ex) {
            logger.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            logger.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            logger.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            logger.error("JWT claims string is empty.");
        }
        return false;
    }
}
