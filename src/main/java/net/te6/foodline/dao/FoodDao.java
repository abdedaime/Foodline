package net.te6.foodline.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.te6.foodline.models.Food;

@SuppressWarnings("unchecked")
@Repository
@Transactional
public class FoodDao implements IfoodDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(Food food) {
		sessionFactory.getCurrentSession().save(food);

	}

	@Override
	public void delete(Food food) {
		sessionFactory.getCurrentSession().delete(food);

	}

	@Override
	public Food get(Long id) {
		
		return (Food) sessionFactory.getCurrentSession().get(Food.class, id);
	}

	@Override
	public void saveOrUpdate(Food o) {
		sessionFactory.getCurrentSession().saveOrUpdate(o);
     }



	@Override
	public List<Food> getAll() {
		
		 return sessionFactory.getCurrentSession().createCriteria(Food.class).list();
	}

	@Override
	public List<Food> getFoodsBySnack(long idSnack) {
		return	sessionFactory.getCurrentSession().createQuery(" From Food f where f.snack.id=:id").setParameter("id", idSnack).list();
		
	}

}
