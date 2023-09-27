package com.munindra.springboot.myfirstwebapp.security;
import static org.springframework.security.config.Customizer.withDefaults;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {
	
	//InMemoryUserDetailsManager
	//InMemoryUserDetailsManager(UserDetails... users)
	
	@Bean
	public InMemoryUserDetailsManager createUserDetailsManager() {
		

		
		
		UserDetails userDetails1= createNewUser("munindra", "123456");
		UserDetails userDetails2 = createNewUser("munindra123", "12345678");
		return new InMemoryUserDetailsManager(userDetails1,userDetails2);
	}

	private UserDetails createNewUser(String username, String password) {
		Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input);
		
		UserDetails userDetails = User.builder()
								.passwordEncoder(passwordEncoder)
								.username(username)
								.password(password)
								.roles("USER","admin")
								.build();
		return userDetails;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
//	All URLs are pprotected

	//	A login frorm is shown for unauthorized requests
//	CSRF disable
//	frames
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http)throws Exception {
		http.authorizeHttpRequests(
				auth -> auth.anyRequest().authenticated());
		http.formLogin(withDefaults());
		//http.csrf().disable();
		http.csrf().disable();
		http.headers().frameOptions().disable();
		return  http.build();
	}

}
