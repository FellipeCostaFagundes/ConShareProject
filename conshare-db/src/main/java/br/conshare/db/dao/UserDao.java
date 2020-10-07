package br.conshare.db.dao;

import java.util.List;

import br.conshare.model.entities.Usuario;


public interface UserDao {
	
	List<Usuario> readAll();
	
	boolean create(Usuario entity);
	
	Usuario readById (Long id);
	
	boolean update (Usuario entity);
	
	boolean deleteById (Long Id);

}
