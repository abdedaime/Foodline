package net.te6.foodline.dao;

import java.util.List;

import net.te6.foodline.models.Client;
import net.te6.foodline.models.Snack;
import net.te6.foodline.models.User;

public interface IuserDao {
	User authenticate(String email, String password);

	User getUserByUsermail(String userName);

	User getUserById(long id);
	
	public void save(User user);

	public void delete(User user);

	public void saveOrUpdate(User user);

	public List<User> getAll();
	
	public  List<Client> getAllCustomers();


	public List<Snack> getAllSnack();

}
