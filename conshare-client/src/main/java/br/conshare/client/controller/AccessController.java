package br.conshare.client.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.conshare.client.service.UserService;
import br.conshare.model.entities.Usuario;

@Controller
@RequestMapping("/access")
public class AccessController {
	
	@Autowired
	private UserService userService;
	
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
    
    @GetMapping("/register_user")	
	public String getRegisterPage() {
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
