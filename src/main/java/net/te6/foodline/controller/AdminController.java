package net.te6.foodline.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.te6.foodline.mailing.IapplicationMailer;
import net.te6.foodline.models.Client;
import net.te6.foodline.models.Quartier;
import net.te6.foodline.models.Snack;
import net.te6.foodline.models.User;
import net.te6.foodline.models.Ville;
import net.te6.foodline.services.IquartierService;
import net.te6.foodline.services.IuserService;
import net.te6.foodline.services.IvilleService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/admin")
public class AdminController extends AbstractController {
	private Logger log = Logger.getLogger(AdminController.class);

	@Autowired
	private IvilleService villeService;
	@Autowired
	private IapplicationMailer applicationMailer;

	@Autowired
	private IuserService userService;

	@Autowired
	private IquartierService quartService;

	@ModelAttribute("currentUser")
	public User currentUser(HttpServletRequest request,Authentication auth) {
		User user=  userService.getUserByUsermail(auth.getName());
		log.info("----current user--------"+user.toString());
		return user;
	}

	@ModelAttribute("snack")
	public Snack modelSnack() {
		return new Snack();
	}

	@ModelAttribute("clients")
	public List<Client> list() {
		return userService.getAllCustomers();
	}

	@ModelAttribute("snacks")
	public List<Snack> listSnack() {
		return userService.getAll();
	}

	@ModelAttribute("quartiers")
	public List<Quartier> listQuartier() {
		return quartService.getAll();
	}

	@ModelAttribute("quartier")
	public Quartier modelQuartier() {
		return new Quartier();
	}

	@ModelAttribute("villes")
	public List<Ville> listVille() {
		return villeService.getAll();
	}

	@ModelAttribute("ville")
	public Ville modelVille() {
		return new Ville();
	}

	@RequestMapping(value = "/quartiers", method = RequestMethod.GET)
	public String indexQuartiers(Model model) {
		return " formquartier";
	}

	@RequestMapping(value = "/clients", method = RequestMethod.GET)
	public String indexCustomers(Model model) {
		return "customers";
	}

	@RequestMapping(value = "/addQuartier", method = RequestMethod.POST)
	public String addQuartier(@ModelAttribute("quartier") Quartier quartier) {
		quartService.save(quartier);
		return "redirect:/admin/quartiers?success=1";
	}

	@RequestMapping(value = "/snacks", method = RequestMethod.GET)
	public String indexSnack(Model model) {
		return "formsnack";
	}

	@RequestMapping(value = "/add-snack", method = RequestMethod.POST)
	public String addSnack(@ModelAttribute("snack") Snack snack,
			@RequestParam("file") MultipartFile multipartFile) throws Exception {
		if (snack.getId() == 0) {
			userService.saveOrUpdate(snack);
			// applicationMailer.sendMailNewAccount(snack);
			createFile(LOGO_NAME, multipartFile, snack.getId());
			return "redirect:/admin/snacks?success=1";
		}
		if (!multipartFile.isEmpty()) {
			deleteFile(LOGO_NAME, snack.getId());
			createFile(LOGO_NAME, multipartFile, snack.getId());

		}
		userService.saveOrUpdate(snack);
		return "redirect:/admin/snacks?success=0";

	}

	@RequestMapping(value = "/villes", method = RequestMethod.GET)
	public String indexVille(Model model) {
		return "formville";
	}

	@RequestMapping(value = "/addVille", method = RequestMethod.POST)
	public String addVille(@ModelAttribute("ville") Ville ville) {
		villeService.save(ville);
		return "redirect:/admin/villes?success=1";
	}

	@RequestMapping(value = "/delete-ville/{idVille}", method = RequestMethod.GET)
	public String deleteVille(@PathVariable("idVille") long idVille) {
		villeService.delete(villeService.get(idVille));
		return "redirect:/admin/villes";
	}

	@RequestMapping(value = "/delete-quartier/{idQaurtier}", method = RequestMethod.GET)
	public String deleteQuartier(@PathVariable("idQaurtier") long idQaurtier) {
		quartService.delete(quartService.get(idQaurtier));
		return "redirect:/admin/quartiers";
	}

	@RequestMapping(value = "editSnack/{idSnack}", method = RequestMethod.POST)
	public ResponseEntity<?> getSnackByid(@PathVariable long idSnack) {

		return new ResponseEntity<User>(userService.getUserById(idSnack),
				HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "quartierByVille/{idVille}", method = RequestMethod.GET)
	public ResponseEntity<?> quartierByVille(@PathVariable long idVille) {

		return new ResponseEntity<List<Quartier>>(
				quartService.getQuartierByVille(idVille), HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "delete-snack/{idSnack}", method = RequestMethod.GET)
	public String deleteSnack(@PathVariable("idSnack") long id) {

		userService.deleteUser(id);
		return "redirect:/admin/snacks?successdelete=1";
	}

	@RequestMapping(value = "chnage-status/{idCustomer}/{status}", method = RequestMethod.POST)
	public ResponseEntity<?> ChangeStatusCustomer(
			@PathVariable("idCustomer") long id, boolean status) {
		User us = userService.getUserById(id);
		us.setEnabled(status);
		userService.saveOrUpdate(us);
		return new ResponseEntity<User>(us, HttpStatus.ACCEPTED);
	}

}
