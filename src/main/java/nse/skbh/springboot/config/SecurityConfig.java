package nse.skbh.springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import nse.skbh.springboot.Users;
import nse.skbh.springboot.logic.Utils;



@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private LoggingAccessDeniedHandler accessDeniedHandler;
    
    @Autowired
	private UserAuthenticationSuccessHandler successHandler;
    

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		//.antMatchers("/").permitAll()
		.antMatchers("/").hasAnyRole("USER", "ADMIN")
		//.antMatchers("/getEmployees").hasAnyRole("USER", "ADMIN")
		//.antMatchers("/addNewEmployee").hasAnyRole("ADMIN")
		.anyRequest().authenticated().and().formLogin().successHandler(successHandler)
		.loginPage("/login").permitAll().and().logout().permitAll()
		.and()
        .exceptionHandling().accessDeniedHandler(accessDeniedHandler);

		http.csrf().disable();
	}

	 @Autowired
	 public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception {
		 
		 
		 
	 authenticationMgr
	 .inMemoryAuthentication()
	 .withUser("root").password("{noop}" + Utils.decoder(Users.root.getBytes())).authorities("ROLE_USER").and()  //{noop}
	 .withUser("jsr").password("{noop}"+Utils.decoder(Users.jsr.getBytes())).authorities("ROLE_USER", "ROLE_ADMIN").and()
	 .withUser("sandeep").password("{noop}" + Utils.decoder(Users.sandeep.getBytes())).authorities("ROLE_USER").and()
	 .withUser("dinesh").password("{noop}" + Utils.decoder(Users.dinesh.getBytes())).authorities("ROLE_USER").and()
	 .withUser("ranjeet").password("{noop}" + Utils.decoder(Users.ranjeet.getBytes())).authorities("ROLE_USER").and()
	 .withUser("bimlesh").password("{noop}" + Utils.decoder(Users.bimlesh.getBytes())).authorities("ROLE_USER");
	}
	 
	 
	/* @Bean
	 public PasswordEncoder passwordEncoder() {
	     return new BCryptPasswordEncoder();
	 }*/
}