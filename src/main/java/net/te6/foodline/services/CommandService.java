package net.te6.foodline.services;

import net.te6.foodline.dao.IGenericDao;
import net.te6.foodline.models.Command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommandService implements IserviceCommand {
	
	private IGenericDao<Command> dao;
	
	
	@Autowired
	public void setDao(IGenericDao<Command> daoToSet) {
		dao = daoToSet;
		dao.setClazz(Command.class);
	}


	@Override
	public void save(Command command) {
      dao.save(command);
	}

}
