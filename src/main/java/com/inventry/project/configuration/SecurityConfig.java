package com.inventry.project.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.inventry.project.filters.JwtRequestFilter;
import com.inventry.project.service.MyUserDetailsService;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private MyUserDetailsService myUserDeatilsService ;
	
	@Autowired
	private JwtRequestFilter jwtRequestFilter;
	
	private final String[] PUBLIC_ENDPOINTS = { 
			
			"/microservice1/authenticate",
			//"/utilisateurs/AddUtilisateur",
			//"/article/testExceptions",
			//"/microservice1/FileSupport/9000053"
			//"/microservice1/uploadfile/support/"
		}; 
	
	private final String[] AGENT_INVENTAIRE_ENDPOINTS = {
			"/microservice1/FileSupport",
			
	};
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(myUserDeatilsService).passwordEncoder(Encoder());
	}
	
	@Bean
	public BCryptPasswordEncoder Encoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.headers()
		.httpStrictTransportSecurity()
		.includeSubDomains(true)
		.maxAgeInSeconds(31536000);
		
		http.csrf().disable()
					.authorizeRequests()
					.antMatchers(PUBLIC_ENDPOINTS).permitAll()
				//	.antMatchers(AGENT_INVENTAIRE_ENDPOINTS).hasRole("SERVICE_ACHAT")
					.anyRequest().authenticated()
					.and().sessionManagement()
					.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
			http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
					;
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	
}
