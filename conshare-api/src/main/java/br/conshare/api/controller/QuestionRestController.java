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

import br.conshare.api.service.QuestionService;
import br.conshare.model.entities.Duvida;

@RestController
@RequestMapping("/api/v1/question")
@CrossOrigin(origins = "*")
public class QuestionRestController {

	@Autowired
	private QuestionService questionService;
	
	public static Long USUARIO_ID = Long.valueOf(1);
	
	
	

	@GetMapping("/read-all")
	public ResponseEntity<List<Duvida>> readAll() {

		List<Duvida> questions = questionService.readAll();

		if (questions == null || questions.size() == 0) {
			return ResponseEntity.ok(null);
		} else {
			return ResponseEntity.ok(questions);
		}

	}

	@GetMapping("/read-by-id/{id}")
	public ResponseEntity<Duvida> readById(@PathVariable("id") Long id) {

		Duvida questions = questionService.readById(id);

		if (questions == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(questions);
		}

	}

	@PutMapping("/update")
	public ResponseEntity<Boolean> update(@RequestBody Duvida entity) {
		
		entity.setUsuarioId(USUARIO_ID);
		
		boolean response = questionService.update(entity);
		
		return ResponseEntity.ok(response);

	}
	
	

	@PostMapping("/create")
	public ResponseEntity<Long> create(@RequestBody Duvida entity) {
		
		entity.setUsuarioId(USUARIO_ID);

		Long id = questionService.create(entity);

		if (id == 0) {
			return ResponseEntity.badRequest().build();
		}

		return ResponseEntity.ok(id);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable("id") Long id) {
		boolean response = questionService.deleteById(id);

		return ResponseEntity.ok(response);
	}

}
