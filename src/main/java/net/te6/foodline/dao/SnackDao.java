package net.te6.foodline.dao;

import java.util.List;

import net.te6.foodline.models.Command;
import net.te6.foodline.models.Food;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Transactional
@Repository
public class SnackDao  implements IsnackDao {
	@Autowired
   private SessionFactory sessionFactory;
	@Override
	public List<Command> getCommandsBySnack(long idSnack) {
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Food> getFoodsBySnack(long idSnack) {
		org.hibernate.Query query = sessionFactory.getCurrentSession()
				.createQuery("from Food f where f.snack.id=:idSnack");
		query.setParameter("idSnack", idSnack);
		return query.list();
	}

}
