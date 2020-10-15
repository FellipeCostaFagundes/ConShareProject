package br.conshare.client.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.conshare.client.service.UserService;
import br.conshare.model.entities.Duvida;
import br.conshare.model.entities.Usuario;

@Controller
@RequestMapping("/access")
public class AccessController {
	
	@Autowired
	private UserService userService;
	
	//public static Long ID = Long.valueOf(1);
	
    @GetMapping("/login")	
	public String getLoginPage(Model model) {
    	
		List<Usuario> users = userService.readAll();
		
		if(users != null && users.size() != 0) {
			model.addAttribute("users", users);
			
			System.out.println("Foram encontrados" + users.size()+ "usuarios");
		} else {
			model.addAttribute("users", new ArrayList<Usuario>());
			System.out.println("Os Usuarios não foram encontrados");
		}
		
		return "/access/login";
		
	}
    
    
    @PostMapping("/create")
	public String create(Usuario users, Model model) {
    	
    	
		Long id = userService.create(users);
		//ID = id;
		
		if(id == 0) {
			return "redirect:/account/register?serverError";
		}
		
		users.setId(id);
		model.addAttribute("users", users);
		
		return "/access/login";
		
	}
    
    @GetMapping("/register_user")	
	public String getRegisterPage(Usuario users) {
    	
		return "/access/register_user";
		
	}
    
    @GetMapping("/register_student")
    public String getRegisterStudentPage() {
    	return "/access/register_student";
    }
    
    @GetMapping("/register_teacher")
    public String getRegisterTeacher() {
    	return "/access/register_teacher";
    }
    
    
    @GetMapping("/redefine_password")
    public String getRedefinePassaword() {
    	return "/access/redefine_password";
    }
    

}
