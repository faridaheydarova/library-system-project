package az.developia.librarysystemfarida.config;
import javax.sql.DataSource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
		.antMatchers(HttpMethod.GET, "/users/**").permitAll()
		.antMatchers(HttpMethod.POST, "/students/**").permitAll()
	
		.antMatchers(HttpMethod.GET, "/students/**").permitAll()
		 
		.antMatchers(HttpMethod.GET, "/books/**").permitAll()
		.antMatchers(HttpMethod.POST, "/books/**").permitAll()
		
		
		
		
		.anyRequest().authenticated().and().httpBasic(); 
		http.headers().frameOptions().disable();
	}

	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource);
	
		

}  
}

	
	
