package net.te6.foodline.dao;

import java.util.List;

import net.te6.foodline.models.Ville;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@SuppressWarnings("unchecked")
@Transactional
@Repository
public class VilleDao implements IVilleDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(Ville ville) {
		 sessionFactory.getCurrentSession().save(ville);
	}

	@Override
	public void delete(Ville ville) {
		sessionFactory.getCurrentSession().delete(ville);

	}

	@Override
	public Ville get(Long id) {
		// TODO Auto-generated method stub
		return (Ville) sessionFactory.getCurrentSession().get(Ville.class, id);
	}

	@Override
	public void saveOrUpdate(Ville ville) {
		sessionFactory.getCurrentSession().saveOrUpdate(ville);

	}

	@Override
	public List<Ville> getAll() {
		
	return sessionFactory.getCurrentSession().createCriteria(Ville.class).list();
	}

}
