package com.example.controller;

//import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.service.AppService;


@Controller
public class AppController
{
	@Autowired
	AppService pendudukDAO;
	
	@RequestMapping("/")
	public String index() {
		return "home";
	}
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
}
