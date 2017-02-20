package net.te6.foodline.dao;

import java.util.List;

import net.te6.foodline.models.Command;
import net.te6.foodline.models.Food;

public interface IsnackDao {
     public  List<Command> getCommandsBySnack(long idSnack);
     public List<Food>  getFoodsBySnack(long idSnack);
	
	
}
