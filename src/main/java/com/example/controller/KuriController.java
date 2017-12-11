package com.example.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

//import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.KurikulumModel;
import com.example.model.LinkStudentKuriModel;
import com.example.model.MahasiswaModel;
import com.example.service.KuriService;


@Controller
public class KuriController
{
	@Autowired
	KuriService KuriDAO;
	
	@RequestMapping("/assignKurikulum")
	public String index(Model model, HttpServletRequest request) {
		if(request.getMethod().equals("GET")){
			List<String> angkatan = KuriDAO.allAngkatan();
			System.out.println(angkatan);
			List<KurikulumModel> kurikulum = KuriDAO.allKurikulum();
			System.out.println(kurikulum);
			List<LinkStudentKuriModel> angkatankuri = KuriDAO.AllAngkatanKuri();
			System.out.println(angkatankuri);
			model.addAttribute("kurikulum", kurikulum);
			model.addAttribute("angkatan", angkatan);
			model.addAttribute("angkatankuri", angkatankuri);
			return "kurikulum";
			}
		else if(request.getMethod().equals("POST")){
			System.out.println("ini post lul");
			KuriDAO.assignKurikulum(request.getParameter("angkatan"), request.getParameter("kurikulum"));
			System.out.println(request.getParameter("angkatan")+ " "+ request.getParameter("kurikulum"));
			return "redirect:/assignKurikulum";
		}else {
			return "redirect:/assignKurikulum";
		}
		
	}
	
}
