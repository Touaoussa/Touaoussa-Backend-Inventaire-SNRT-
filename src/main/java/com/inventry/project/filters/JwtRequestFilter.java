package com.inventry.project.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.inventry.project.Exception.TokenException;
import com.inventry.project.service.MyUserDetailsService;
import com.inventry.project.util.JwtUtil;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

	@Autowired
	private MyUserDetailsService UserDetailsService;
	@Autowired 
	JwtUtil jwtTokenUtil;
	

	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {

		final String authorizationHeader = request.getHeader("Authorization");
		
		String username = null ;
		String jwt = null ;
		
		
		if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
			jwt = authorizationHeader.substring(7);
			username = jwtTokenUtil.getUserNameFromToken(jwt);
			System.out.println("header valid");
		} 
		else System.out.println("pas de header");
		
		if(this.UserDetailsService.FindToken(jwt)) throw new TokenException();
		
		if(username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetails = this.UserDetailsService.loadUserByUsername(username);
			System.out.println(jwtTokenUtil.isTokenValid(jwt, userDetails));
			System.out.println("roles= "+userDetails.getAuthorities());
			if(jwtTokenUtil.isTokenValid(jwt, userDetails)) {
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						userDetails , null , userDetails.getAuthorities()
						);
						
				usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
				System.out.println("valid token");
			}
			
			else System.out.println("invalid token");
		}
		chain.doFilter(request, response);
	}

}
