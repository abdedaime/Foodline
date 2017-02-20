package net.te6.foodline.services;

import java.util.List;

import net.te6.foodline.dao.IGenericDao;
import net.te6.foodline.dao.IsnackDao;
import net.te6.foodline.models.Food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class FoodService implements IfoodService {
	private IGenericDao<Food> dao;
	@Autowired
	private IsnackDao snackDao;

	@Autowired
	public void setDao(IGenericDao<Food> daoToSet) {
		dao = daoToSet;
		dao.setClazz(Food.class);
	}

	@Override
	public void save(Food o) {
		 dao.save(o);
	}

	@Override
	public void delete(Food o) {
	  dao.save(o);

	}

	@Override
	public Food get(Long id) {
		
		return  dao.get(Food.class, id);
	}

	@Override
	public void saveOrUpdate(Food o) {
		 dao.saveOrUpdate(o);

	}

	@Override
	public List<Food> getAll() {
		
		return dao.getAll(Food.class);
	}

	@Override
	public List<Food> getFoodsBySnack(long idSnack) {
		// TODO Auto-generated method stub
		return snackDao.getFoodsBySnack(idSnack);
	}

}
