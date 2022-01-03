package nse.skbh.springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.session.HttpSessionEventPublisher;

import nse.skbh.springboot.boot.backend.mongo.service.LoginUserDetailsService;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	private static final String[] permitted_url = {
			"/actuator/**",
			"/proxy/**",
			"/hystrix/**",
			"/v2/api-docs",
			"/configuration/ui",
			"/swagger-resources/**",
			"/configuration/**",
			"/swagger-ui.html",
			"/webjars/**",
			"/api/**",
			"/static/**",
			"/css/**",
			"/js/**",
			"/kapi/**",
			"/rest/**",
			"/images/**"
    };

	private static final String LOGIN_INVALID_SESSION_URL="/login";
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	@Autowired
    private LoggingAccessDeniedHandler accessDeniedHandler;
	
	@Autowired
	private LoginUserDetailsService loginUserDetailsService;
    
    @Autowired
	private UserAuthenticationSuccessHandler successHandler;
    
    @Bean
    public HttpSessionEventPublisher httpSessionEventPublisher() {
        return new HttpSessionEventPublisher();
    }
    
     
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(permitted_url);
	}
	
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		/*.antMatchers("/").permitAll()*/
		.antMatchers(permitted_url).permitAll()
		.antMatchers("/").hasAnyRole("USER", "ADMIN")
		.anyRequest().authenticated().and().formLogin().successHandler(successHandler)
		.loginPage(LOGIN_INVALID_SESSION_URL).permitAll().and().logout().permitAll()
		.and()
        .exceptionHandling().accessDeniedHandler(accessDeniedHandler);
  		http.sessionManagement()
		.maximumSessions(1)
		.expiredUrl(LOGIN_INVALID_SESSION_URL)
		.maxSessionsPreventsLogin(false);
		/*http.csrf().disable();*/
		
	}

	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	    UserDetailsService userDetailsService = mongoUserDetails();
	    auth
	        .userDetailsService(userDetailsService)
	        .passwordEncoder(bCryptPasswordEncoder);

	}

	
/*	 @Autowired
	 public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception {
	 authenticationMgr
	 .inMemoryAuthentication()
	 .withUser("root").password("{noop}" + 
	 Utils.decoder(new EncryptionCodec().excuteCodec().getDataMap().get(Users.root).getBytes())).authorities("ROLE_USER").and()  //{noop}
	 .withUser("jsr").password("{noop}" + 
	 Utils.decoder(new EncryptionCodec().excuteCodec().getDataMap().get(Users.jsr).getBytes())).authorities("ROLE_USER", "ROLE_ADMIN").and()
	 .withUser("sandeep").password("{noop}" +
	 Utils.decoder(new EncryptionCodec().excuteCodec().getDataMap().get(Users.sandeep).getBytes())).authorities("ROLE_USER").and()
	 .withUser("dinesh").password("{noop}" +
	 Utils.decoder(new EncryptionCodec().excuteCodec().getDataMap().get(Users.dinesh).getBytes())).authorities("ROLE_USER").and()
	 .withUser("ranjeet").password("{noop}" +
	 Utils.decoder(new EncryptionCodec().excuteCodec().getDataMap().get(Users.ranjeet).getBytes())).authorities("ROLE_USER").and()
	 .withUser("bimlesh").password("{noop}" +
	 Utils.decoder(new EncryptionCodec().excuteCodec().getDataMap().get(Users.bimlesh).getBytes())).authorities("ROLE_USER");
	}*/
	 
	 
	
	@Bean
	public UserDetailsService mongoUserDetails() {
	    return new LoginUserDetailsService();
	}
	

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
	    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	    return bCryptPasswordEncoder;
	}


	public BCryptPasswordEncoder getbCryptPasswordEncoder() {
		return bCryptPasswordEncoder;
	}


	public void setbCryptPasswordEncoder(BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}


	public LoggingAccessDeniedHandler getAccessDeniedHandler() {
		return accessDeniedHandler;
	}


	public void setAccessDeniedHandler(LoggingAccessDeniedHandler accessDeniedHandler) {
		this.accessDeniedHandler = accessDeniedHandler;
	}


	public LoginUserDetailsService getLoginUserDetailsService() {
		return loginUserDetailsService;
	}


	public void setLoginUserDetailsService(LoginUserDetailsService loginUserDetailsService) {
		this.loginUserDetailsService = loginUserDetailsService;
	}


	public UserAuthenticationSuccessHandler getSuccessHandler() {
		return successHandler;
	}


	public void setSuccessHandler(UserAuthenticationSuccessHandler successHandler) {
		this.successHandler = successHandler;
	}


}
