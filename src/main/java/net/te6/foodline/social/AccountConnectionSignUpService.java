package net.te6.foodline.social;

import net.te6.foodline.config.RedirectClass;
import net.te6.foodline.models.Client;
import net.te6.foodline.models.Role;
import net.te6.foodline.services.UserService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.UserProfile;
import org.springframework.stereotype.Component;

@Component
public class AccountConnectionSignUpService implements ConnectionSignUp {
	private Logger LOG = Logger.getLogger(AccountConnectionSignUpService.class);

	@Autowired
	private UserService userService;

	@Override
	public String execute(Connection<?> connection) {
		UserProfile userProfile = connection.fetchUserProfile();
		LOG.debug("userProfile : " + userProfile.toString());
        userService.save(createCustomer(userProfile));
		return null;
	}

	private Client createCustomer(UserProfile userProfile) {

		Client client = new Client();
		client.setFirstName(userProfile.getFirstName());
		client.setLastName(userProfile.getLastName());
		client.setLogin(userProfile.getEmail());
		client.setRole(new Role(RedirectClass.ROLE_CUSTOMER));
		return client;
	}

}
