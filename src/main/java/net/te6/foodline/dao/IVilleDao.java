package net.te6.foodline.dao;

import java.util.List;

import net.te6.foodline.models.Ville;

public interface IVilleDao {
	

	public void save(Ville ville);

	public void delete(Ville ville);

	public Ville get(Long id);

	public void saveOrUpdate(Ville ville);

	public List<Ville> getAll();
}
