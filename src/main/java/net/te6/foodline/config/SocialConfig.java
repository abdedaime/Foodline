package net.te6.foodline.config;

import javax.sql.DataSource;

import net.te6.foodline.social.AccountConnectionSignUpService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.social.UserIdSource;
import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurer;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.google.connect.GoogleConnectionFactory;
import org.springframework.social.security.AuthenticationNameUserIdSource;

@Configuration
@EnableSocial
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = { "net.te6.foodline.social" })
public class SocialConfig implements SocialConfigurer {

	private Logger LOG = Logger.getLogger(AccountConnectionSignUpService.class);

	  public SocialConfig(){
		

	  }
	
	
	@Autowired
	private DataSource dataSource;

	@Autowired
	private AccountConnectionSignUpService accountConnectionSignUpService;

	@Override
	public void addConnectionFactories(ConnectionFactoryConfigurer connection,
			Environment env) {

		connection.addConnectionFactory(new FacebookConnectionFactory(env
				.getProperty("facebook.appId"),env
				.getProperty("facebook.appSecret")));
		
		
		GoogleConnectionFactory gcf = new GoogleConnectionFactory(
                env.getProperty("google.appId"),
                env.getProperty("google.appSecret"));
		  LOG.info("google appid "+env.getProperty("google.appId"));
		  LOG.info("google appid "+env.getProperty("google.appSecret"));

        gcf.setScope("email");
        connection.addConnectionFactory(gcf);

	}

	@Override
	public UserIdSource getUserIdSource() {

		return new AuthenticationNameUserIdSource();

	}

	@Override
	public UsersConnectionRepository getUsersConnectionRepository(
			ConnectionFactoryLocator connectionFactoryLocator) {
		JdbcUsersConnectionRepository repository = new JdbcUsersConnectionRepository(
				dataSource, connectionFactoryLocator, Encryptors.noOpText());

		repository.setConnectionSignUp(accountConnectionSignUpService);
		return repository;
	}

}
