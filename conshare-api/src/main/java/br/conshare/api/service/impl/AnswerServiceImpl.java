package br.conshare.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.conshare.api.service.AnswerService;
import br.conshare.db.dao.AnswerDao;
import br.conshare.model.entities.Respostas;

@Service
public class AnswerServiceImpl implements AnswerService{
	
	@Autowired
	private AnswerDao answerDao;

	@Override
	public List<Respostas> readAll() {
		
		return answerDao.readAll();
	}

	@Override
	public Long create(Respostas entity) {
		
		return answerDao.create(entity);
	}

	@Override
	public Respostas readById(Long id) {
		
		return answerDao.readById(id);
	}

	@Override
	public boolean update(Respostas entity) {
		
		return answerDao.update(entity);
	}

	@Override
	public boolean deleteById(Long Id) {
		
		return answerDao.deleteById(Id);
	}

}
