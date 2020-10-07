package br.conshare.client.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.conshare.client.service.QuestionService;
import br.conshare.model.entities.Duvida;






@Controller
@RequestMapping("/question")
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	
	@GetMapping("/list_question")
	public String getListQuestionPage(Model model) {
		
        List<Duvida> questions = questionService.readAll();
		
		if(questions != null && questions.size() != 0) {
			model.addAttribute("questions", questions);
			
			System.out.println("Foram encontrados " + questions.size() + " duvidas.");
			
		} else {
			model.addAttribute("questions", new ArrayList<Duvida>());
			
			System.out.println("Nenhuma duvida foi encontrada");
		}
		
		
		return "question/list_question";
	}
	
	@GetMapping("/add_question")
	public String getAddQuestionPage(Duvida duvida) {
		return "question/add_question";
	}
	
	@GetMapping("/detail-question/{id}")
	public String getDetailQuestionPage(@PathVariable("id") Long id, Model model) {
		
		Duvida questions = questionService.readById(id);
		
		model.addAttribute("questions", questions);
		
		
		return "question/detail_question";
	}
		
	
	
	@GetMapping("/edit_question/{id}")
	public String getEditQuestionPage(@PathVariable("id") Long id, Model model) {
		
		
		Duvida question = questionService.readById(id);
			
			model.addAttribute("questions", question);
			
			
		return "question/edit_question";
	}
	

	
	@PostMapping("/create")
	public String create(Duvida questions, Model model) {
		
		Long id = questionService.create(questions);
		
		if(id == 0) {
			return "redirect:/account/register?serverError";
		}
		
		questions.setId(id);
		model.addAttribute("questions", questions);
		
		return null;
		
	}
	
	
	@PostMapping("/update")
	public String update(Duvida questions, Model model) {
		
		questionService.update(questions);
		
		return getDetailQuestionPage(questions.getId(), model);
	}
	
	
	
	

}
