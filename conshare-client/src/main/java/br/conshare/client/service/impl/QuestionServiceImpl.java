package br.conshare.client.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.conshare.client.service.QuestionService;
import br.conshare.model.entities.Duvida;




@Service
public class QuestionServiceImpl implements QuestionService{

	@Override
	public List<Duvida> readAll() {
		
		List<Duvida> response = null;
		
		String endpoint = "http://localhost:8085/api/v1/question/read-all";
		
		RestTemplate restTemplate  = new RestTemplate();
		
		try {
			HttpEntity<String> requestEntity = new HttpEntity<String>("");
			ResponseEntity<Duvida[]> requestResponse = restTemplate.exchange(endpoint, HttpMethod.GET, requestEntity, Duvida[].class);
			
			Duvida[] questions = requestResponse.getBody();
			response = Arrays.asList(questions);
			
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		return response;
		
		
		
	}

	@Override
	public Long create(Duvida entity) {
		
		Long id = Long.valueOf(0);
		String endpoint = "http://localhost:8085/api/v1/question/create";
		
		RestTemplate restTemplate = new RestTemplate();
		
		try {
			
			HttpEntity<Duvida> httpEntity = new HttpEntity<Duvida>(entity);
			
			ResponseEntity<String> requestResponse = restTemplate.exchange(endpoint, HttpMethod.POST, httpEntity, String.class);
			
			String response = requestResponse.getBody();
			id = Long.parseLong(response);
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
		
		
		return id;
	}

	@Override
	public Duvida readById(Long id) {
		
		Duvida response = null;
		
		String endpoint = "http://localhost:8085/api/v1/question/read-by-id/" + id;
		
		RestTemplate restTemplate =new RestTemplate();
		
		try {
			
			
			HttpEntity<String> requestEntity = new HttpEntity<String>("");
			ResponseEntity<Duvida> requestResponse = restTemplate.exchange(endpoint, HttpMethod.GET, requestEntity, Duvida.class);
			
			response = requestResponse.getBody();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	
		return response;
		
		
	}

	@Override
	public boolean update(Duvida entity) {
		
		boolean response = false;

		String endpoint = "http://localhost:8085/api/v1/question/update";

		RestTemplate restTemplate = new RestTemplate();

		try {

			HttpEntity<Duvida> httpEntity = new HttpEntity<Duvida>(entity);
			
			ResponseEntity<Boolean> responseEntity = restTemplate.exchange(endpoint, HttpMethod.PUT, httpEntity, Boolean.class);
			
			response = responseEntity.getBody();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return response;
		
		

	}

	@Override
	public boolean deleteById(Long Id) {
		
		return false;
	}

}
