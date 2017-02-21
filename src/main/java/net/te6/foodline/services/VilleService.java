package net.te6.foodline.services;

import java.util.List;

import net.te6.foodline.dao.IVilleDao;
import net.te6.foodline.models.Ville;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service

public class VilleService implements
  IvilleService{
	@Autowired
	private IVilleDao dao;

	

	@Override
	public void save(Ville o) {
		 dao.save(o);
	}

	@Override
	public void delete(Ville o) {
	  dao.delete(o);

	}

	@Override
	public Ville get(Long id) {
		
		return  dao.get(id);
	}

	@Override
	public void saveOrUpdate(Ville o) {
		 dao.saveOrUpdate(o);

	}

	@Override
	public List<Ville> getAll() {
		
		return dao.getAll();
	}

}
