package net.te6.foodline.restController;

import java.util.List;

import net.te6.foodline.models.Quartier;
import net.te6.foodline.models.Ville;
import net.te6.foodline.services.IquartierService;
import net.te6.foodline.services.IvilleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("ville")
public class VilleController {
	@Autowired
	private IvilleService villeService;
	@Autowired
	private IquartierService quartService;

	@RequestMapping(value = "/villes")
	public ResponseEntity<?> listVilles() {
		return new ResponseEntity<List<Ville>>(villeService.getAll(),
				HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "quartier-by-ville/{idVille}", method = RequestMethod.GET)
	public ResponseEntity<?> quartierByVille(@PathVariable long idVille) {

		return new ResponseEntity<List<Quartier>>(
				quartService.getQuartierByVille(idVille), HttpStatus.ACCEPTED);
	}

}
