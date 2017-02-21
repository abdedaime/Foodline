package net.te6.foodline.controller;

import javax.validation.Valid;

import net.te6.foodline.config.RedirectClass;
import net.te6.foodline.models.Client;
import net.te6.foodline.models.Role;
import net.te6.foodline.models.User;
import net.te6.foodline.services.IuserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * 
 * @author hicham-abdedaime
 *
 */
@Controller
public class LoginContorller extends AbstractController {

	@Autowired
	private IuserService userService;

	@RequestMapping("/index")
	public String index() {
		return "index";
	}

	@ModelAttribute("customer")
	public Client client() {
		return new Client();
	}

	@RequestMapping(value = "/login")
	public String login() {
	

		return "login1";

	}

	@RequestMapping(value = "/account")
	public String accountPage() {

		return "create-accoutn-customer";
	}

	@RequestMapping(value = "/create-account", method = RequestMethod.POST)
	public String addSnack(Model model,
			@ModelAttribute("customer") @Valid Client client,
			BindingResult bindingResult,
			@RequestParam("file") MultipartFile multipartFile) {
		checkForm(client, bindingResult);
		if (bindingResult.hasErrors()) {

			System.out.println("bindinresult error");
			return "create-accoutn-customer";
		}

		client.setRole(new Role(RedirectClass.ROLE_CUSTOMER));
		userService.save(client);
		System.out.println("----------------------" + client.getId());
		if (!multipartFile.isEmpty()) {
			createFile(AVATAR_NAME, multipartFile, client.getId());
		}

		return "redirect:account?success=1";
	}

	@RequestMapping(value = "activate-account/{token}",method=RequestMethod.GET)
	public String activatAccount(@PathVariable String token) {
		for (User user : userService.getAll()) {
			log.info("token-----------------------"+user.toString());

			if (clairToMd5(user.getLogin()+user.getId()).equals(token)) {
               user.setEnabled(true);
               userService.saveOrUpdate(user);
			}
		}
		return "redirect:/login?activate=1";
	}

	private void checkForm(User user, BindingResult bindingResult) {
		if (userService.getUserByUsermail(user.getLogin()) != null) {
			bindingResult.rejectValue("login", "messageCode",
					"User Exist déja ");
		}
		if (!user.getPassword().equals(user.getConfirmPassword())) {
			bindingResult.rejectValue("password", "messageCode",
					"Mot de passe non conforme ");
		}
	}

}
