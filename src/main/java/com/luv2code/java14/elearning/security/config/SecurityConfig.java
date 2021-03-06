package com.luv2code.java14.elearning.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.luv2code.java14.elearning.security.jwt.JWTAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private JWTAuthenticationFilter filter;
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.userDetailsService(userDetailsService)
			.passwordEncoder(getPasswordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// cấu hình CORS
		http.cors();
		
		// cấu hình session
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		// disable csrf
		http.csrf().disable();
		
		// add jwt filter
		http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
		
		// cấu hình xác thực cho các api
//		http.antMatcher("/**").authorizeRequests()
//			.antMatchers("/api/login").permitAll()
////			.antMatchers("/api/sign-up").permitAll()
////			.antMatchers("/api/**").permitAll()
//			.antMatchers("/api/**").authenticated()
//			.anyRequest().authenticated();
		
		http.authorizeRequests()
			.antMatchers("/").permitAll()
			.antMatchers("/api/payment/**").hasRole("USER")
			.antMatchers("/").anonymous()
			.and()
			.formLogin()
				.loginProcessingUrl("/api/login").permitAll()
				.defaultSuccessUrl("/success.html", true)
			.and()
			.logout().permitAll();

	}	
}
