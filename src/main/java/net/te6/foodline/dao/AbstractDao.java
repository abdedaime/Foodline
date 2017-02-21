package net.te6.foodline.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
@SuppressWarnings("unchecked")
public abstract class AbstractDao<T> {
	private Class<T> clazz;

	public final void setClazz(Class<T> clazzToSet) {
		this.clazz = clazzToSet;
	}

	@Autowired
	protected SessionFactory sessionFactory;

	public T save(T o) {
		return (T) sessionFactory.getCurrentSession().save(o);
	}

	public void delete(T object) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(object);

	}

	public T get(Class<T> type, Long id) {
		return (T) sessionFactory.getCurrentSession().get(type, id);
	}

	public void saveOrUpdate(T o) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(o);
		session.flush();

	}

	public List<T> getAll(Class<T> type) {
		final Session session = sessionFactory.getCurrentSession();
		final Criteria crit = session.createCriteria(type);
		return crit.list();
	}

}
