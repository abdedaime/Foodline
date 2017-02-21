package net.te6.foodline.config;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

/**
 * 
 * @author hicham-Abdedaime
 *
 */
@Component
public class RedirectClass implements AuthenticationSuccessHandler {
	
	public static final String ROLE_CUSTOMER = "Role_client";
	public static final String ROLE_ADMIN = "Role_admin";
	public static final String ROLE_SNACK = "Role_snack";
	public static final String HOME_SNACK = "admin/snacks";
	
  public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		Set<String> roles = AuthorityUtils.authorityListToSet(authentication
				.getAuthorities());
        if (roles.contains(ROLE_ADMIN)) {
          response.sendRedirect(HOME_SNACK);
		  return;
		}

	}

}
