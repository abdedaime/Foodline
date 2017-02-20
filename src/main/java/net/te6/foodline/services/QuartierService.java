package net.te6.foodline.services;

import java.util.List;

import net.te6.foodline.dao.IGenericDao;
import net.te6.foodline.dao.IquartierDao;
import net.te6.foodline.models.Quartier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class QuartierService implements  IquartierService {
	private IGenericDao<Quartier> dao;
	@Autowired
	private IquartierDao iquartierDao;

	@Autowired
	public void setDao(IGenericDao<Quartier> daoToSet) {
		dao = daoToSet;
		dao.setClazz(Quartier.class);
	}

	@Override
	public void save(Quartier o) {
		
		 dao.save(o);
	}

	@Override
	public void delete(Quartier object) {
		
		dao.delete(object);
	}

	@Override
	public Quartier get(Long id) {
		return dao.get(Quartier.class, id);
	}

	@Override
	public void saveOrUpdate(Quartier o) {
		dao.saveOrUpdate(o);
		
	}

	@Override
	public List<Quartier> getAll() {
		// TODO Auto-generated method stub
		return  dao.getAll(Quartier.class);
	}

	@Override
	public List<Quartier> getQuartierByVille(long idVille) {
		return iquartierDao.getQuartierByVille(idVille);
	}
   

}
