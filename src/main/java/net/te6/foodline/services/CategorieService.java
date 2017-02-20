package net.te6.foodline.services;

import java.util.List;

import net.te6.foodline.dao.IGenericDao;
import net.te6.foodline.models.Categorie;

import org.springframework.beans.factory.annotation.Autowired;

public class CategorieService implements
  IcategorieService{
	private IGenericDao<Categorie> dao;

	@Autowired
	public void setDao(IGenericDao<Categorie> daoToSet) {
		dao = daoToSet;
		dao.setClazz(Categorie.class);
	}

	@Override
	public void save(Categorie o) {
		 dao.save(o);
	}

	@Override
	public void delete(Categorie o) {
	  dao.save(o);

	}

	@Override
	public Categorie get(Long id) {
		
		return  dao.get(Categorie.class, id);
	}

	@Override
	public void saveOrUpdate(Categorie o) {
		 dao.saveOrUpdate(o);

	}

	@Override
	public List<Categorie> getAll() {
		
		return dao.getAll(Categorie.class);
	}

}
