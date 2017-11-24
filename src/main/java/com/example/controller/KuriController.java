package com.example.controller;

import javax.servlet.http.HttpServletRequest;

//import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.StudentModel;
import com.example.service.KuriService;


@Controller
public class KuriController
{
	@Autowired
	KuriService KuriDAO;
	
	@RequestMapping("/assignTerm")
	public String index(Model model, HttpServletRequest request) {
		return "index";
	}
	
	@RequestMapping("/assignTerm/update")
	public String dashboard() {
		return "dashboard";
	}
	
}
