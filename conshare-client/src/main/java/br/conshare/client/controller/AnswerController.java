package br.conshare.client.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.conshare.client.service.AnswerService;
import br.conshare.model.entities.Duvida;
import br.conshare.model.entities.Respostas;

@Controller
@RequestMapping("/answer")

public class AnswerController {
	
	@Autowired
	private AnswerService answerService;
	
	
	@GetMapping("/list_answer")
	public String getListQuestionPage(Respostas answers, Model model) {
		
		return "answer/list";
	}
	
	
	
	@PostMapping("/create")
	public String create(Respostas answers, Model model) {
		
	
		
		Long id = answerService.create(answers);
		
		if(id == 0) {
			return "redirect:/account/register?serverError";
		}
		
		answers.setId(id);
		model.addAttribute("answers", answers);
		
		return "answer/list";
		
	}

}
