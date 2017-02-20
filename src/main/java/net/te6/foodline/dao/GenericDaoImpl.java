package net.te6.foodline.dao;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository
@Scope( BeanDefinition.SCOPE_PROTOTYPE )
public class GenericDaoImpl< T >
extends AbstractDao< T > implements IGenericDao< T > {


	private static final long serialVersionUID = 1L;
	

}
