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
			HttpEntity<String> requestEntity = new HttpEntity<>("");
			ResponseEntity<Usuario[]> requestResponse = restTemplate.exchange(endpoint, HttpMethod.GET, requestEntity, Usuario[].class);
			
			Usuario[] users = requestResponse.getBody();
			response = Arrays.asList(users);
			
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		return response;
		

	}

	@Override
	public boolean create(Usuario entity) {
		
		return false;
	}

	@Override
	public Usuario readById(Long id) {
		
		Usuario response = null;
		
		String endpoint = "http://localhost:8085/api/v1/user/read-by-id/" + id;
		
		RestTemplate restTemplate =new RestTemplate();
		
		try {
			
			
			HttpEntity<String> requestEntity = new HttpEntity<>("");
			ResponseEntity<Usuario> requestResponse = restTemplate.exchange(endpoint, HttpMethod.GET, requestEntity, Usuario.class);
			
			response = requestResponse.getBody();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	
		return null;
		
		
		
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
