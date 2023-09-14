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
import org.springframework.web.bind.annotation.GetMapping;
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
	        .antMatchers("/save").hasRole("LIBRARIAN")
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
	        .anyRequest().authenticated()
	        .and()
	    .formLogin()
	        .loginPage("/login") // Kullanıcı giriş yapmak istediğinde yönlendirileceği sayfa
	        .permitAll() // Herkesin bu sayfaya erişim izni
	        .and()
	    .logout()
	        .logoutSuccessUrl("/login?logout") // Çıkış başarılı olduğunda yönlendirileceği sayfa
	        .permitAll() // Herkesin çıkış yapmasına izin ver
	        .and()
	    .csrf().disable();

	}
		/*http.csrf().disable().authorizeRequests()
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
		
		.anyRequest().authenticated().and().httpBasic(); 
		/*and()
        .formLogin()
            .loginPage("/login") // Kullanıcı giriş yapmak istediğinde yönlendirileceği sayfa
            .permitAll() // Herkesin bu sayfaya erişim izni
            .and()
        .logout()
            .logoutSuccessUrl("/login?logout") // Çıkış başarılı olduğunda yönlendirileceği sayfa
            .permitAll() // Herkesin çıkış yapmasına izin ver
            .and()
        .csrf().disable();
	http
	    .authorizeRequests()
	        .antMatchers("/save").hasRole("LIBRARIAN")
	        // Diğer izinler ve ayarlar
	        .and()
	    .formLogin()
	    .loginPage("/login") // Kullanıcı giriş yapmak istediğinde yönlendirileceği sayfa
        .permitAll() // Herkesin bu sayfaya erişim izni
	        .and()
	    .logout()
	    .logoutSuccessUrl("/login?logout") // Çıkış başarılı olduğunda yönlendirileceği sayfa
        .permitAll() // Herkesin çıkış yapmasına izin ver
	        .and()

	        .csrf().disable();
    
		http.headers().frameOptions().disable();
	}


	private HttpSecurity and() {
		// TODO Auto-generated method stub
		return null;
	}

*/
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		    auth.jdbcAuthentication().dataSource(dataSource)
		        .usersByUsernameQuery("SELECT username, password, email FROM users WHERE username=?")
		        .authoritiesByUsernameQuery("SELECT username, authority FROM authorities WHERE username=?")
		        .passwordEncoder(passwordEncoder());
		}

		

}  

	
	
