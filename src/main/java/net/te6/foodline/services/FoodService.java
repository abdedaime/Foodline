package net.te6.foodline.services;

import java.util.List;

import net.te6.foodline.dao.IfoodDao;
import net.te6.foodline.models.Food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class FoodService implements IfoodService {
	
	
	@Autowired
	private IfoodDao dao;
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
		
		return  dao.get( id);
	}

	@Override
	public void saveOrUpdate(Food o) {
		 dao.saveOrUpdate(o);

	}

	@Override
	public List<Food> getAll() {
		
		return dao.getAll();
	}

	@Override
	public List<Food> getFoodsBySnack(long idSnack) {
		
		return dao.getFoodsBySnack(idSnack);
	}

}
