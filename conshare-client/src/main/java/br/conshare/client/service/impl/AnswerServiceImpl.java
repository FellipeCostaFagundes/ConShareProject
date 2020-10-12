package br.conshare.client.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.conshare.client.service.AnswerService;
import br.conshare.model.entities.Duvida;
import br.conshare.model.entities.Respostas;

@Service
public class AnswerServiceImpl implements AnswerService {

	@Override
	public List<Respostas> readAll() {

		List<Respostas> response = null;

		String endpoint = "http://localhost:8085/api/v1/answer/read-all";

		RestTemplate restTemplate = new RestTemplate();

		try {
			HttpEntity<String> requestEntity = new HttpEntity<String>("");
			ResponseEntity<Respostas[]> requestResponse = restTemplate.exchange(endpoint, HttpMethod.GET, requestEntity,
					Respostas[].class);

			Respostas[] questions = requestResponse.getBody();
			response = Arrays.asList(questions);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return response;

	}

	@Override
	public Long create(Respostas entity) {
		
		Long id = Long.valueOf(0);
		String endpoint = "http://localhost:8085/api/v1/answer/create";

		
		RestTemplate restTemplate = new RestTemplate();
		
		try {
			HttpEntity<Respostas> httpEntity = new HttpEntity<Respostas>(entity);
			ResponseEntity<String> requestResponse = restTemplate.exchange(endpoint, HttpMethod.POST, httpEntity,String.class );
			
			String response = requestResponse.getBody();
			id = Long.parseLong(response);
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
			
		}
		return id;
	}

	@Override
	public Respostas readById(Long id) {

		Respostas response = null;
		
		String endpoint = "http://localhost:8085/api/v1/answer/read-by-id/" + id;
		
		RestTemplate restTemplate =new RestTemplate();
		
		try {
			
			
			HttpEntity<String> requestEntity = new HttpEntity<>("");
			ResponseEntity<Respostas> requestResponse = restTemplate.exchange(endpoint, HttpMethod.GET, requestEntity, Respostas.class);
			
			response = requestResponse.getBody();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	
		return null;
	}

	@Override
	public boolean update(Respostas entity) {

		return false;
	}

	@Override
	public boolean deleteById(Long Id) {

		return false;
	}

}
