package br.conshare.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.conshare.api.service.QuestionService;
import br.conshare.db.dao.QuestionDao;
import br.conshare.model.entities.Duvida;

@Service
public class QuestionServiceImpl implements QuestionService {
	
	@Autowired
	private QuestionDao questionDao;

	@Override
	public List<Duvida> readAll() {
		
		return questionDao.readAll();
	}

	@Override
	public Long create(Duvida entity) {
		
		return questionDao.create(entity);
	}

	@Override
	public Duvida readById(Long id) {
		
		return questionDao.readById(id);
	}

	@Override
	public boolean update(Duvida entity) {
		
		return questionDao.update(entity);
	}

	@Override
	public boolean deleteById(Long Id) {
		
		return questionDao.deleteById(Id);
	}

}
