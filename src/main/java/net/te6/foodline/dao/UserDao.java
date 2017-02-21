package net.te6.foodline.dao;

import net.te6.foodline.models.User;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
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





}
