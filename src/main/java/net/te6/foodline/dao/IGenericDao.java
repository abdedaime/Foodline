package net.te6.foodline.dao;

import java.io.Serializable;
import java.util.List;

public interface IGenericDao <T>  extends Serializable {
	public  void setClazz(Class<T> clazzToSet);
    public  T save( T o);
    public void delete(T obj);
    public T get( Class<T> type,  Long id);
    public  void saveOrUpdate( T o);
    public  List<T> getAll( Class<T> type) ;
}
