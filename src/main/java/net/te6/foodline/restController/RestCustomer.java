package net.te6.foodline.restController;

import net.te6.foodline.models.Client;
import net.te6.foodline.models.User;
import net.te6.foodline.services.IuserService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//http://stackoverflow.com/questions/32441919/how-return-error-message-in-spring-mvc-controller
@RestController
@RequestMapping("customer")
public class RestCustomer {
	private Logger log = Logger.getLogger(RestCustomer.class);

	@Autowired
	private IuserService userseService;

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public ResponseEntity<?> login(@RequestBody Client cl) {
		User user = userseService.authenticate(cl.getLogin(), cl.getPassword());
		log.info(cl.toString());
		if (user == null) {
			return new ResponseEntity<String>("Utilisateur  n'existe pas",
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(user, HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "signin", method = RequestMethod.POST)
	public ResponseEntity<?> signin(@RequestBody Client client) {
		Client cl = (Client) userseService.getUserByUsermail(client.getLogin());
		if (cl != null) {

			if (client.getTypeAuth().equals("social") && cl.getPassword().equals(client.getPassword())) {
				client = cl;
			} else if (client.getTypeAuth().equals("from")) {
				return new ResponseEntity<String>("Utilisateur existe deja ",
						HttpStatus.NOT_FOUND);
			} 

		} else {
			userseService.save(client);
		}

		log.info(client.toString());
		return new ResponseEntity<Client>(client, HttpStatus.ACCEPTED);
	}

}
