package net.te6.foodline.dao;



import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class GenericDaoImpl< T >
extends AbstractDao< T > implements IGenericDao< T > {


	private static final long serialVersionUID = 1L;
	

}
