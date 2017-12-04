package com.example.controller;

//import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.model.KelasModel;
import com.example.model.MatkulModel;
import com.example.service.AppService;


@Controller
public class AppController
{
	@Autowired
	AppService appDAO;
	
	@RequestMapping("/")
	public String index() {
		if(SecurityContextHolder.getContext().getAuthentication() != null &&  SecurityContextHolder.getContext().getAuthentication().isAuthenticated() && !(SecurityContextHolder.getContext().getAuthentication() 
          instanceof AnonymousAuthenticationToken) ) {
			return "redirect:dashboard";
		}else {
			return "index";
		}
	}
	
	@RequestMapping("/home")
	public String home() {
		return "index";
	}
	
	@RequestMapping("/dashboard")
	public String dashboard() {
		return "dashboard";
	}
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	@RequestMapping("/kelas")
	public String kelas() {
		return "kelas";
	}
	
    
}
