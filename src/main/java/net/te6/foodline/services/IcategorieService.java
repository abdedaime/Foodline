package net.te6.foodline.services;

import java.util.List;

import net.te6.foodline.models.Categorie;

public interface IcategorieService {
    public  void save(final Categorie o);
    public void delete(Categorie o);
    public Categorie get(final Long id);
    public  void saveOrUpdate(final  Categorie o);
    public  List<Categorie> getAll() ;

}
