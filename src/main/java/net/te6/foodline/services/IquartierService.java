package net.te6.foodline.services;

import java.util.List;

import net.te6.foodline.models.Quartier;

public interface IquartierService {
    public  void save(final Quartier o);
    public void delete(Quartier o);
    public Quartier get(final Long id);
    public  void saveOrUpdate(final  Quartier	 o);
    public  List<Quartier> getAll() ;
    public List<Quartier> getQuartierByVille(long idVille);


}
