package com.example.controller;

import java.util.List;

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
import com.example.model.KurikulumModel;
import com.example.model.MatkulModel;
import com.example.model.UserModel;
import com.example.service.APIMapperImpl;
import com.example.service.AppService;


@Controller
public class AppController
{
	@Autowired
	AppService appDAO;
	
	@Autowired
	APIMapperImpl api;
	

	public UserModel getUser() {
		UserModel user = appDAO.getLoggedInUser(SecurityContextHolder.getContext().getAuthentication().getName());
		System.out.println(user);
		return user;
	}
	
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
	@RequestMapping("/portal")
	public String portal() {
		return "portal";
	}
	@RequestMapping("/dashboard")
	public String dashboard(Model model) {
		UserModel userData = getUser();
		model.addAttribute("user",userData);
		return "dashboard";
	}
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
}
