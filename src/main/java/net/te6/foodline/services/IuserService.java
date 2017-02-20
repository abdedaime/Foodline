package net.te6.foodline.services;

import java.util.List;

import net.te6.foodline.models.Client;
import net.te6.foodline.models.Snack;
import net.te6.foodline.models.User;

public interface IuserService {
	public User authenticate(String email, String password);

	public void save(User u);

	public void saveOrUpdate(User u);

	public List<Snack> getAll();

	User getUserByUsermail(String userName);

	User getUserById(long id);
	
	void deleteUser(long id);
	public List<Client> getAllCustomers();


}
