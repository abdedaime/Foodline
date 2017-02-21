package net.te6.foodline.dao;

import java.util.List;

import net.te6.foodline.models.Quartier;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
@SuppressWarnings("unchecked")
public class QuartierDao implements IquartierDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Quartier> getQuartierByVille(long idVille) {

		final Session session = sessionFactory.getCurrentSession();
		org.hibernate.Query query = session
				.createQuery(" from Quartier as q where q.ville.id=:id ");
		query.setParameter("id", idVille);
		return query.list();

	}

}
