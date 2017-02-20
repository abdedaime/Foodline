package net.te6.foodline.config;

import net.te6.foodline.social.SimpleSocialUsersDetailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.social.security.SpringSocialConfigurer;

/***
 * 
 * @author hicham-abdedaime
 *
 */
@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private RedirectClass AuthenticationSuccessHandler;
	
	@Autowired
	private SocialUserDetailsService socialUserDetailsService;

	@Autowired
	@Qualifier("userDetailsService")
	private UserDetailsService userDetailsService;

	@Override
	public void configure(WebSecurity web) throws Exception {
		String[] unsecuredResources = {"/index", "/resources/**","/account","/create-account","/activate-account/**","/customer/**","/food/**","/ville/**","/snack/**" };
		web.ignoring().antMatchers(unsecuredResources);
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.userDetailsService(userDetailsService);

	}

	/*
	 * @Autowired public void
	 * configureGlobalSecurity(AuthenticationManagerBuilder auth) throws
	 * Exception {
	 * auth.inMemoryAuthentication().withUser("hicham").password("123")
	 * .roles("USER", "MANGER_RH");
	 * auth.inMemoryAuthentication().withUser("admin").password("123")
	 * .roles("ADMIN");
	 * auth.inMemoryAuthentication().withUser("consultant").password("123")
	 * .roles("ADMIN", "USER"); }
	 */

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().authenticated()
		
		  /*.antMatchers("/", "/home").permitAll()*/
		 .antMatchers("/admin/**").access("hasRole('Role_admin')")
		/* .antMatchers("/con/**"
		 * ).access("hasRole('ADMIN') and hasRole('CONSU')")
		 */
		.and().formLogin().loginPage("/login").permitAll()
				.usernameParameter("useranme").passwordParameter("password")
				.failureUrl("/login?error=1")
				.successHandler(AuthenticationSuccessHandler).and().csrf()
				.disable().logout().logoutUrl("/logout")
				.logoutSuccessUrl("/login").and().apply(new SpringSocialConfigurer()
                .postLoginUrl("/")
                .defaultFailureUrl("/#/login")
                .alwaysUsePostLoginUrl(true));
	        //.and().exceptionHandling().accessDeniedPage("/Access_Denied");
	}
	   @Bean
	    public SocialUserDetailsService socialUsersDetailService() {
	        return new SimpleSocialUsersDetailService(userDetailsService);
	    }
}
