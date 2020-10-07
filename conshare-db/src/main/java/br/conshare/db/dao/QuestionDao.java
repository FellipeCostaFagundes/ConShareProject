package br.conshare.db.dao;

import java.util.List;

import br.conshare.model.entities.Duvida;

public interface QuestionDao {
	
	List<Duvida> readAll();
	
	Long create(Duvida entity);
	
	Duvida readById (Long id);
	
	boolean update (Duvida entity);
	
	boolean deleteById (Long Id);

}
