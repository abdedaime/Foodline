package net.te6.foodline.services;

import java.util.List;

import net.te6.foodline.dao.IGenericDao;
import net.te6.foodline.models.Ville;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class VilleService implements
  IvilleService{
	private IGenericDao<Ville> dao;

	@Autowired
	public void setDao(IGenericDao<Ville> daoToSet) {
		dao = daoToSet;
		dao.setClazz(Ville.class);
	}

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
		
		return  dao.get(Ville.class, id);
	}

	@Override
	public void saveOrUpdate(Ville o) {
		 dao.saveOrUpdate(o);

	}

	@Override
	public List<Ville> getAll() {
		
		return dao.getAll(Ville.class);
	}

}
