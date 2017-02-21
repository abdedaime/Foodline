package net.te6.foodline.dao;

import java.util.List;


import net.te6.foodline.models.Client;
import net.te6.foodline.models.Snack;
import net.te6.foodline.models.User;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@SuppressWarnings("unchecked")
@Transactional
@Repository
public class UserDao implements IuserDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User authenticate(String login, String password) {
		final Session session = sessionFactory.getCurrentSession();
		final Criteria crit = session.createCriteria(User.class);
		crit.add(Restrictions.eq("login", login));
		crit.add(Restrictions.eq("password", password));
		return (User) crit.uniqueResult();
	}

	@Override
	public User getUserByUsermail(String userName) {
		User u = (User) sessionFactory.getCurrentSession()
				.createQuery("from User u where u.login='" + userName + "'")
				.uniqueResult();
		return u;

	}

	@Override
	public User getUserById(long id) {
		org.hibernate.Query query = sessionFactory.getCurrentSession()
				.createQuery("from User u where u.id=:id");
		query.setParameter("id", id);
		return (User) query.uniqueResult();

	}

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		 sessionFactory.getCurrentSession().save(user);
	}

	@Override
	public void delete(User user) {
		sessionFactory.getCurrentSession().delete(user);
		
	}

	@Override
	public void saveOrUpdate(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		
	}


	@Override
	public List<User> getAll() {
		return sessionFactory.getCurrentSession().createCriteria(User.class).list();
	}

	@Override
	public List<Client> getAllCustomers() {
		return sessionFactory.getCurrentSession().createCriteria(Client.class).list();
	}

	@Override
	public List<Snack> getAllSnack() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createCriteria(Snack.class).list();
	}





}
