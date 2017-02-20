package net.te6.foodline.config;

import java.util.Properties;

import net.te6.foodline.controller.AbstractController;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
/**
 * 
 * @author hicham-abdedaime
 *
 */
@Configuration
@ComponentScan(basePackages = { "net.te6.foodline.*" })
public class MailConfig {
	protected Logger log = Logger.getLogger(AbstractController.class);

	
	public MailConfig(){
		log.info("------laoded configuration smtp-----");
	}
	@Bean
	public JavaMailSender javaMailService() {
		JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();

		javaMailSender.setHost("smtp.gmail.com");
		javaMailSender.setPort(587);
		javaMailSender.setUsername("hicham.suptech@gmail.com");
		javaMailSender.setPassword("789a456z123e");

		javaMailSender.setJavaMailProperties(getMailProperties());

		return javaMailSender;
	}

	private Properties getMailProperties() {
		Properties properties = new Properties();
		properties.setProperty("mail.transport.protocol", "smtp");
		properties.setProperty("mail.smtp.auth", "true");
		properties.setProperty("mail.smtp.starttls.enable", "true");
		properties.setProperty("mail.debug", "true");
		return properties;

	}
}
