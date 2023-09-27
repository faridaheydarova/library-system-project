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
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;

import az.developia.librarysystemfarida.service.UserService;
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Autowired
	private DataSource dataSource;



	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
	    .authorizeRequests()

	       
	    .antMatchers("/save").hasAnyRole("LIBRARIAN", "STUDENT")
	        .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
	        .antMatchers(HttpMethod.POST, "/users/**").permitAll()
	        .antMatchers(HttpMethod.GET, "/users/**").permitAll()
	        .antMatchers(HttpMethod.POST, "/students/**").permitAll()
	        .antMatchers(HttpMethod.GET, "/students/**").permitAll()
	        .antMatchers(HttpMethod.DELETE, "/students/**").permitAll()
	        .antMatchers(HttpMethod.PUT, "/students/**").permitAll()
	        .antMatchers(HttpMethod.GET, "/books/**").permitAll()
	        .antMatchers(HttpMethod.POST, "/books/**").permitAll()
	        .antMatchers(HttpMethod.DELETE, "/books/**").permitAll()
	        .antMatchers(HttpMethod.PUT, "/books/**").permitAll()
	        .antMatchers(HttpMethod.GET, "/borrowed-books/**").permitAll()
	        .antMatchers("/h2-console/**").permitAll()
	        .anyRequest().authenticated().and().httpBasic();
	        http.headers().frameOptions().disable()
	        .and()
	    .formLogin()
	      
	        .permitAll() 
	        .and()
	    .logout()
	      
	        .permitAll() 
	        .and()
	    .csrf().disable();

	}
		private ExpressionUrlAuthorizationConfigurer<HttpSecurity>.AuthorizedUrl anyRequest() {

		return null;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		    auth.jdbcAuthentication().dataSource(dataSource)
		        .usersByUsernameQuery("SELECT username, password, email FROM users WHERE username=?")
		        .authoritiesByUsernameQuery("SELECT username, authority FROM authorities WHERE username=?")
		        .passwordEncoder(passwordEncoder());
		}

		

}  

	
	
