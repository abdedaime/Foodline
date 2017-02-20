package net.te6.foodline.test;

import java.util.List;

import net.te6.foodline.config.HibernateConfiguration;
import net.te6.foodline.config.MailConfig;
import net.te6.foodline.config.RedirectClass;
import net.te6.foodline.models.Admin;
import net.te6.foodline.models.Client;
import net.te6.foodline.models.Quartier;
import net.te6.foodline.models.Role;
import net.te6.foodline.models.Snack;
import net.te6.foodline.models.User;
import net.te6.foodline.models.Ville;
import net.te6.foodline.services.IquartierService;
import net.te6.foodline.services.IuserService;
import net.te6.foodline.services.IvilleService;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

//websystique.com/springmvc/spring-mvc-4-and-spring-security-4-integration-example/
@ContextConfiguration(classes = { HibernateConfiguration.class,MailConfig.class })
@RunWith(SpringJUnit4ClassRunner.class)
public class TestService {
	private static final String fooResourceUrl = "http://localhost:8081/FoodLineBackEnd/user";
	@Autowired
	private IvilleService villeService;
	@Autowired
	private IuserService userService;
	@Autowired
	private IquartierService quaService;

	public void testAdd() {
		Ville ville = new Ville();
		ville.setVille("rabat1");
		villeService.save(ville);
		Assert.assertEquals(villeService.getAll().size(), 2);

	}

	public void testUpdate() {

		Ville ville = villeService.get(Long.parseLong("1"));
		ville.setVille("mohamedia");
		villeService.saveOrUpdate(ville);
		System.out.println(ville.toString());
		Ville ville1 = villeService.get(Long.parseLong("1"));
		Assert.assertEquals(ville1.getVille(), "mohamedia");

	}

	public void testUser() {

		User u = new Client();
		u.setLogin("habdedaime@gmail.com");
		u.setPassword("789a456z123e");
		userService.save(u);
		/*
		 * User user = userService.authenticate("habdedaime@gmail.com",
		 * "789a456z123e");
		 */
		Assert.assertNotNull(u);

	}

	public void testRest() {
		User u = new User();
		u.setLogin("habdedaime@gmail.com");
		u.setPassword("789a456z123e");
		Role role = new Role();
		role.setName("Role_user");
		u.setRole(role);

		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<User> request = new HttpEntity<>(u);
		ResponseEntity<User> response = restTemplate.exchange(fooResourceUrl
				+ "/login", HttpMethod.POST, request, User.class);
		System.out.println(response.getBody().getLogin());
		Assert.assertEquals(response.getStatusCode(), HttpStatus.ACCEPTED);

	}

	public void testQuartier() {
		List<Quartier> quartiers = quaService.getQuartierByVille(22l);

		Assert.assertEquals(quartiers.size(), 3);
	}

	public void testUserByLogin() {
		User user = userService.getUserByUsermail("hicham.suptech@gmail.com");
		if (user == null)
			System.out.println("user nulll");
		else {
			System.out.println(user.toString());
			Assert.assertNotNull(user);
		}

	}
	@Test
	public void testSnack() {

		Admin admin = new Admin();
		admin.setLogin("hicham.s@gmail.com");
		admin.setPassword("12346");
		admin.setFirstName("hicham");
		admin.setLastName("abdedaime");
		admin.setRole(new Role(RedirectClass.ROLE_ADMIN));

		userService.save(admin);

	}

	@Test
	public void getSnack() {
		List<Snack> snak = userService.getAll();
		System.out.println(snak.size());

		
	}
	
	@Test
	public void testCustomers() {

		Client client = new Client();
		client.setLogin("hicham.suptech@gmail.com");
		client.setPassword("12346");
		client.setFirstName("hicham");
		client.setLastName("abdedaime");
		client.setRole(new Role(RedirectClass.ROLE_SNACK));

		userService.save(client);

	}

}
