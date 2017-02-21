package net.te6.foodline.services;

import java.util.List;

import net.te6.foodline.dao.IquartierDao;
import net.te6.foodline.models.Quartier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class QuartierService implements  IquartierService {

	@Autowired
	private IquartierDao quartierDao;



	@Override
	public void save(Quartier o) {
		
		quartierDao.save(o);
	}

	@Override
	public void delete(Quartier object) {
		
		quartierDao.delete(object);
	}

	@Override
	public Quartier get(Long id) {
		return quartierDao.get(id);
	}

	@Override
	public void saveOrUpdate(Quartier o) {
		quartierDao.saveOrUpdate(o);
		
	}

	@Override
	public List<Quartier> getAll() {
		// TODO Auto-generated method stub
		return  quartierDao.getAll();
	}

	@Override
	public List<Quartier> getQuartierByVille(long idVille) {
		return quartierDao.getQuartierByVille(idVille);
	}
   

}
