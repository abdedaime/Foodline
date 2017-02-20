package net.te6.foodline.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import net.te6.foodline.dao.IuserDao;
import net.te6.foodline.models.User;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author hicham-abdedaime
 *
 */
@Service("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

	private Logger log = Logger.getLogger(CustomUserDetailsService.class);

	@Autowired
	private IuserDao userDao;

	@Transactional
	@Override
	public UserDetails loadUserByUsername(String login)
			throws UsernameNotFoundException {
		User user = userDao.getUserByUsermail(login);

		if (user == null) {

			log.debug("user n'existe pas");

			throw new UsernameNotFoundException("User Not found" + login);

		}
		if (user.getRole() == null) {
			log.error("role n'existe pas");
			throw new UsernameNotFoundException("role not exists for" + login);

		}
		
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		org.springframework.security.core.userdetails.User us = new org.springframework.security.core.userdetails.User(
				user.getLogin(), user.getPassword(), user.isEnabled(),
				accountNonExpired, credentialsNonExpired, accountNonLocked,
				getAuthorities(user.getRole()));
		log.info(us.toString());

		return us;
	}

	public List<String> getRolesAsList(net.te6.foodline.models.Role role) {
		List<String> rolesAsList = new ArrayList<String>();
		rolesAsList.add(role.getName());
		return rolesAsList;
	}

	public static List<GrantedAuthority> getGrantedAuthorities(
			List<String> roles) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (String role : roles) {
			authorities.add(new SimpleGrantedAuthority(role));
		}
		return authorities;
	}

	public Collection<? extends GrantedAuthority> getAuthorities(
			net.te6.foodline.models.Role role) {
		List<GrantedAuthority> authList = getGrantedAuthorities(getRolesAsList(role));
		return authList;
	}

}
