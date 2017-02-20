package net.te6.foodline.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
@SuppressWarnings("unchecked")
public abstract class AbstractDao<T> {
	private Class<T> clazz;

	public final void setClazz(Class<T> clazzToSet) {
		this.clazz = clazzToSet;
	}

	@Autowired
	protected SessionFactory sessionFactory;

	public T save(T o) {
		return (T) sessionFactory.openSession().save(o);
	}

	public void delete(T object) {
		Session session = sessionFactory.openSession();
		session.delete(object);
		session.flush();

	}

	public T get(Class<T> type, Long id) {
		return (T) sessionFactory.openSession().get(type, id);
	}

	public void saveOrUpdate(T o) {
		Session session = sessionFactory.openSession();
		session.saveOrUpdate(o);
		session.flush();

	}

	public List<T> getAll(Class<T> type) {
		final Session session = sessionFactory.openSession();
		final Criteria crit = session.createCriteria(type);
		return crit.list();
	}

}
