package br.conshare.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.conshare.api.service.UserService;
import br.conshare.model.entities.Usuario;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin(origins = "*")
public class UserRestController {
	
	
	@Autowired
	private UserService userService;
	
	

	
	@GetMapping ("/read-all")
	public ResponseEntity<List<Usuario>> readAll(){
		
		List<Usuario> users  = userService.readAll();
		
		if(users == null || users.size() == 0) {
			return ResponseEntity.ok(null);
		}
		else {
			return ResponseEntity.ok(users);
		}
		
		
	}
	
	@GetMapping ("/read-by-id/{id}")
	public ResponseEntity<Usuario> readById(@PathVariable("id") Long id){
		
		Usuario user = userService.readById(id);
		
		if(user == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(user);
		}
			
		
	}
	
	
	@PutMapping("/update")
	public ResponseEntity <Boolean> update(@RequestBody Usuario entity) {
		boolean response = userService.update(entity);
		return ResponseEntity.ok(response);
		
	}
	
	@PostMapping("/create")
	public ResponseEntity <Boolean> create(@RequestBody Usuario entity){
		boolean response = userService.create(entity);
		return ResponseEntity.ok(response);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity <Boolean> delete (@PathVariable("id") Long id){
		boolean response = userService.deleteById(id);
		
		return ResponseEntity.ok(response);
	}
	
	
	

}
