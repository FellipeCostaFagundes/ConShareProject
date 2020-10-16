package br.conshare.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.conshare.api.service.UserService;
import br.conshare.db.dao.UserDao;
import br.conshare.model.entities.Usuario;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public List<Usuario> readAll() {
		
		return userDao.readAll();
	}

	@Override
	public Long create(Usuario entity) {
		
		return userDao.create(entity);
	}

	@Override
	public Usuario readById(Long id) {
		
		return userDao.readById(id);
	}

	@Override
	public boolean update(Usuario entity) {
		
		return userDao.update(entity);
	}

	@Override
	public boolean deleteById(Long Id) {
		
		return userDao.deleteById(Id);
	}


	

	

}
