package net.te6.foodline.services;

import java.util.List;


import net.te6.foodline.models.Ville;

public interface IvilleService {
    public  void save( Ville o);
    public void delete(Ville o);
    public Ville get( Long id);
    public  void saveOrUpdate(  Ville	 o);
    public  List<Ville> getAll() ;

}
