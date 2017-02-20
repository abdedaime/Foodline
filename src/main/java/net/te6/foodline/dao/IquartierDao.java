package net.te6.foodline.dao;

import java.util.List;

import net.te6.foodline.models.Quartier;

public interface IquartierDao {
   public List<Quartier> getQuartierByVille(long idVille);
}
