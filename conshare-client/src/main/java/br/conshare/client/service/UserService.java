package br.conshare.client.service;

import java.util.List;

import br.conshare.model.entities.Usuario;

public interface UserService {
	
	List<Usuario> readAll();
	
	Long create(Usuario entity);
	
	Usuario readById (Long id);
	
	boolean update (Usuario entity);
	
	boolean deleteById (Long Id);

}
