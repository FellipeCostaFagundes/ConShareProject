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

import br.conshare.api.service.AnswerService;
import br.conshare.model.entities.Respostas;


@RestController
@RequestMapping("/api/v1/answer")
@CrossOrigin(origins = "*")
public class AnswerRestContoller {
	
	@Autowired
	private AnswerService answerService;
	
	@GetMapping ("/read-all")
	public ResponseEntity<List<Respostas>> readAll(){
		
		Long usuarioId = QuestionRestController.USUARIO_ID;
		
		
		
		List<Respostas> respostas = answerService.readAll();
		
		if(respostas == null || respostas.size() ==0) {
			return ResponseEntity.ok(null);
		}
		else {
			return ResponseEntity.ok(respostas);
		}
		
	}
	
	@GetMapping ("/read-by-id/{id}")
	public ResponseEntity<Respostas> readById(@PathVariable("id") Long id){
		
		Respostas respostas = answerService.readById(id);
		
		if(respostas == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(respostas);
		}
			
		
	}
	
	
	@PutMapping("/update")
	public ResponseEntity <Boolean> update(@RequestBody Respostas entity) {
		boolean response = answerService.update(entity);
		return ResponseEntity.ok(response);
		
	}
	
	@PostMapping("/create")
	public ResponseEntity <Boolean> create(@RequestBody Respostas entity){
		boolean response = answerService.create(entity);
		return ResponseEntity.ok(response);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity <Boolean> delete (@PathVariable("id") Long id){
		boolean response = answerService.deleteById(id);
		
		return ResponseEntity.ok(response);
	}
	
	

}
