package br.conshare.client.controller;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.conshare.client.service.QuestionService;
import br.conshare.client.service.UserService;
import br.conshare.model.entities.Duvida;
import br.conshare.model.entities.Usuario;


@Controller
@RequestMapping("/perfil")
public class PerfilController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/perfil")
	public String getListQuestionPage(Model model) {
		
        List<Usuario> perfils = userService.readAll();
		
		if(perfils != null && perfils.size() != 0) {
			model.addAttribute("perfils", perfils);
			
			System.out.println("Foram encontrados " + perfils.size() + " perfils.");
			
		} else {
			model.addAttribute("perfils", new ArrayList<Usuario>());
			
			System.out.println("Nenhuma perfil foi encontrada");
		}
		
		
		return "perfil/perfil";
	}
	
	
	@GetMapping("/perfil/list_perfil/{id}")
	public String getPerfilSobre(@PathVariable("id") Long id, Model model) {
		
		Usuario perfil = userService.readById(id);
		
		model.addAttribute("perfil", perfil);
		
		return "perfil/list_perfil/1";
	}
	

	
	@GetMapping("/edit_perfil")
	public String getPerfilEdit() {
		return "/perfil/edit_perfil";
	}


	
}
