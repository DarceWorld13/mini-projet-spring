package fr.topcollegues;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	JWTAuthorizationFilter jwtAuthorizationFilter;

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http

				.csrf().disable()

				.cors().and()

				.authorizeRequests()

				.antMatchers(HttpMethod.POST, "/test").permitAll()

				.antMatchers("/h2-console/**").permitAll()

				.anyRequest().authenticated()

				.and().headers().frameOptions().disable().and()
				.addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class);

	}

}
