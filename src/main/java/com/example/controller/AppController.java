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
	
//	@RequestMapping("/term")
//	public String term() {
//		return "term";
//	}
	
	@RequestMapping("/kelas")
	public String kelas() {
		return "kelas";
	}
	
	@RequestMapping("/assignKurikulum")
	public String assignKurikulum() {
		return "kurikulum";
	}
}
