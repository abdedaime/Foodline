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

	public User getUserByUsermail(String userName);

	public User getUserById(long id);
	public  void deleteUser(long id);
	public  List<Client> getAllCustomers();


}
