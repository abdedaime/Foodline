package net.te6.foodline.dao;

import net.te6.foodline.models.User;

public interface IuserDao {
	User authenticate(String email, String password);

	User getUserByUsermail(String userName);

	User getUserById(long id);
	


}
