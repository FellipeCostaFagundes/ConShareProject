package br.conshare.db.dao;

import java.util.List;

import br.conshare.model.entities.Respostas;



public interface AnswerDao {
	
	List<Respostas> readAll();
	
	Long create(Respostas entity);
	
	Respostas readById (Long id);
	
	boolean update (Respostas entity);
	
	boolean deleteById (Long Id);

}
