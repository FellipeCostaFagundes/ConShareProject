package br.conshare.client.service.impl;

import java.util.Arrays;

import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.conshare.client.service.UserService;
import br.conshare.model.entities.Usuario;


@Service
public class UserServiceImpl implements UserService {
	
	

	@Override
	public List<Usuario> readAll() {
		
		List<Usuario> response = null;
		
		String endpoint = "http://localhost:8085/api/v1/user/read-all";
		
		RestTemplate restTemplate  = new RestTemplate();
		
		try {
			HttpEntity<String> requestEntity = new HttpEntity<String>("");
			ResponseEntity<Usuario[]> requestResponse = restTemplate.exchange(endpoint, HttpMethod.GET, requestEntity, Usuario[].class);
			
			Usuario[] users = requestResponse.getBody();
			response = Arrays.asList(users);
			
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		return response;
		
	}

	@Override
	public Long create(Usuario entity) {
		
		Long id = Long.valueOf(1);
		
		String endpoint = "http://localhost:8085/api/v1/user/create";
		
		RestTemplate restTemplate = new RestTemplate();
		
		try {
			
			HttpEntity<Usuario> httpEntity = new HttpEntity<Usuario>(entity);
			
			ResponseEntity<Long> requestResponse = restTemplate.exchange(endpoint, HttpMethod.POST, httpEntity, Long.class);
			
	
			id = requestResponse.getBody();
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
		
		
		return id;
	}

	@Override
	public Usuario readById(Long id) {
		
		Usuario response = null;
		
		String endpoint = "http://localhost:8085/api/v1/user/read-by-id/" + id;
		
		RestTemplate restTemplate =new RestTemplate();
		
		try {
			
			
			HttpEntity<String> requestEntity = new HttpEntity<String>("");
			ResponseEntity<Usuario> requestResponse = restTemplate.exchange(endpoint, HttpMethod.GET, requestEntity, Usuario.class);
			
			response = requestResponse.getBody();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	
		return response;
		
		
	}

	@Override
	public boolean update(Usuario entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteById(Long Id) {
		// TODO Auto-generated method stub
		return false;
	}

}
