package net.te6.foodline.services;

import java.util.List;

import net.te6.foodline.dao.IGenericDao;
import net.te6.foodline.dao.IuserDao;
import net.te6.foodline.models.Client;
import net.te6.foodline.models.Snack;
import net.te6.foodline.models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IuserService {

	@Autowired
	private IuserDao userDao;
	@Autowired
	private IGenericDao<User> dao;
	
	@Autowired
	private IGenericDao<Snack> daoSnack;
	
	@Autowired
	private IGenericDao<Client> daoCustomer;



	@Autowired
	public void setDao(IGenericDao<User> daoToSet) {
		dao = daoToSet;
		dao.setClazz(User.class);
	}

	@Override
	public User authenticate(String email, String password) {
		// TODO Auto-generated method stub
		return userDao.authenticate(email, password);
	}

	@Override
	public void save(User u) {
		dao.save(u);

	}

	@Override
	public void saveOrUpdate(User u) {
		dao.saveOrUpdate(u);
		
	}

	@Override
	public List<Snack> getAll() {
		
		return daoSnack.getAll(Snack.class);
	}

	@Override
	public User getUserByUsermail(String userName) {
		// TODO Auto-generated method stub
		return userDao.getUserByUsermail(userName);
	}

	@Override
	public User getUserById(long id) {
		return userDao.getUserById(id);
	}

	@Override
	public void deleteUser(long id) {
     dao.delete(getUserById(id));		
	}

	@Override
	public List<Client> getAllCustomers() {
		return daoCustomer.getAll(Client.class);
	}

}
