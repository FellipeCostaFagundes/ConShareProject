package br.conshare.client.service;

import java.util.List;

import br.conshare.model.entities.Duvida;

public interface QuestionService {
	List<Duvida> readAll();
	
	Long create(Duvida entity);
	
	Duvida readById (Long id);
	
	boolean update (Duvida entity);
	
	boolean deleteById (Long Id);

}
