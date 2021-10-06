package com.inventry.project.util;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.*;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtUtil {

	
	private final String CLAIMS_SUBJECT = "sub";
	private final String CLAIMS_CREATED = "created";
	private final String CLAIMS_AUTHORITY = "authorization";

	private Long TOKEN_VALIDITY = 604800L;

	private String TOKEN_SECRET = "phoenix2020";

	public String generateToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<>();
		claims.put(CLAIMS_SUBJECT, userDetails.getUsername());
		claims.put(CLAIMS_CREATED, new Date());
		claims.put(CLAIMS_AUTHORITY, userDetails.getAuthorities());
		return Jwts.builder().
				setClaims(claims).
				setExpiration(generateExpirationDate())
				.signWith(SignatureAlgorithm.HS512, TOKEN_SECRET)
				.compact();
	}

	public String getUserNameFromToken(String token) {
		try {
			Claims claims = getClaims(token);

			return claims.getSubject();
		} catch (Exception ex) {
			return null;
		}
	}

	private Date generateExpirationDate() {
		return new Date(System.currentTimeMillis() + TOKEN_VALIDITY * 1000);
	}

	public boolean isTokenValid(String token, UserDetails userDetails) {
		String username = getUserNameFromToken(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}

	private boolean isTokenExpired(String token) {
		Date expiration = getClaims(token).getExpiration();
		return expiration.before(new Date());
	}

	private Claims getClaims(String token) {
		Claims claims;
		try {
			claims = Jwts.parser().setSigningKey(TOKEN_SECRET).parseClaimsJws(token).getBody();
		} catch (Exception ex) {
			claims = null;
		}

		return claims;
	}
	
	/*private String SECRET_KEY="secret" ;
	
	public String extractUsername(String token) {
		return extractClaim(token,Claims::getSubject);
		}
	
	public Date extractExpiration(String token) {
		return extractClaim(token,Claims::getExpiration);
	}
	
	public <T> T extractClaim(String token , Function <Claims,T>claimsResolver) {
		final Claims claims = this.extractAllClaims(token);
		return claimsResolver.apply(claims);
	}
	
	private Claims extractAllClaims(String token) {
		return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
	}
	public String generateToken(UserDetails userDetails) {
		Map<String , Object > claims = new HashMap<>();
		return this.createToken(claims, userDetails.getUsername());
	}
	
	private Boolean isTokenExpired(String token) {
		return this.extractExpiration(token).before(new Date());
	}
	
	private String createToken(Map<String,Object> claims , String subject) {
		
		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 1000 *60 * 60 * 10))
				.signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
	}
	
	public Boolean validateToken(String token,UserDetails userDetails) {
		final String username = this.extractUsername(token);
		return (username.equals(userDetails.getUsername()) && isTokenExpired(token));
	}
	*/
}
