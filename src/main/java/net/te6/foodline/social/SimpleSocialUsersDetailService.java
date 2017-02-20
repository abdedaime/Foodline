package net.te6.foodline.social;

import org.apache.log4j.Logger;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;



public class SimpleSocialUsersDetailService implements SocialUserDetailsService {

	protected Logger LOGGER = Logger.getLogger(SimpleSocialUsersDetailService.class);

	 private UserDetailsService userDetailsService;

	    public SimpleSocialUsersDetailService(UserDetailsService userDetailsService) {
	        this.userDetailsService = userDetailsService;
	    }

	@Override
	public SocialUserDetails loadUserByUserId(String login)
			throws UsernameNotFoundException {

	

		LOGGER.debug("Loading user by user login: " + login);
		UserDetails userDetails = userDetailsService.loadUserByUsername(login);
		
		if (userDetails == null) {
			throw new UsernameNotFoundException("No user found with username: "
					+ login);
		}

		LOGGER.debug("Found user details: " + userDetails.toString());
		return (SocialUserDetails) userDetails;
	}
	
	
 
}
