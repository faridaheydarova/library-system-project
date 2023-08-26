package az.developia.librarysystemfarida.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
			
			@Autowired
			private DataSource dataSource;

			@Override
			protected void configure(HttpSecurity http) throws Exception {
				http.csrf().disable().authorizeRequests()
				.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
				.antMatchers(HttpMethod.POST, "/users/**").permitAll()
				.antMatchers(HttpMethod.GET, "/files/download/**").permitAll()
				.anyRequest().authenticated().and().httpBasic(); 
				http.headers().frameOptions().disable();
			}
			

}
