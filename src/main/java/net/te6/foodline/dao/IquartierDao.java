package net.te6.foodline.dao;

import java.util.List;

import net.te6.foodline.models.Quartier;

public interface IquartierDao {
	public List<Quartier> getQuartierByVille(long idVille);

	public void save(Quartier quartier);

	public void delete(Quartier quartier);

	public Quartier get(Long id);

	public void saveOrUpdate(Quartier o);

	public List<Quartier> getAll();
}
