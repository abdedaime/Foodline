package net.te6.foodline.services;

import java.util.List;

import net.te6.foodline.models.Food;

public interface IfoodService {
    public  void save(final Food o);
    public void delete(Food o);
    public Food get(final Long id);
    public  void saveOrUpdate(final  Food o);
    public  List<Food> getAll() ;
    public List<Food>  getFoodsBySnack(long idSnack);

}
