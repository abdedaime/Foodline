package net.te6.foodline.restController;

import net.te6.foodline.models.Snack;
import net.te6.foodline.models.User;
import net.te6.foodline.services.IuserService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("snack")
public class RestSnack {
	private Logger log = Logger.getLogger(RestCustomer.class);

	@Autowired
	private IuserService userseService;

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public ResponseEntity<?> login(@RequestBody Snack sn) {
		User user = userseService.authenticate(sn.getLogin(), sn.getPassword());
		log.info(sn.toString());
		if (user == null) {
			return new ResponseEntity<String>("Snack  n'existe pas",
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(user, HttpStatus.ACCEPTED);
	}
	
	
	@RequestMapping(value = "editSnack/{idSnack}", method = RequestMethod.POST)
	public ResponseEntity<?> getSnackByid(@PathVariable long idSnack) {
		
		return new ResponseEntity<User>(userseService.getUserById(idSnack), HttpStatus.ACCEPTED);
	}

}
