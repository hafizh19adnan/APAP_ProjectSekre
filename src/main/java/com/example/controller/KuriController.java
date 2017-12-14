package com.example.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

//import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.AngkatanModel;
import com.example.model.KurikulumModel;
import com.example.model.LinkStudentKuriModel;
import com.example.model.MahasiswaModel;
import com.example.model.UserModel;
import com.example.service.AppService;
import com.example.service.KuriService;


@Controller
public class KuriController
{
	@Autowired
	KuriService KuriDAO;
	
	@Autowired
	AppService appDAO;
	
	
	public UserModel getUser() {
		UserModel user = appDAO.getLoggedInUser(SecurityContextHolder.getContext().getAuthentication().getName());
		System.out.println(user);
		return user;
	}
	
	@RequestMapping("/assignKurikulum")
	public String index(Model model, HttpServletRequest request) {
		if(request.getMethod().equals("GET")){
			UserModel user = this.getUser();
			List<AngkatanModel> angkatan = KuriDAO.allAngkatan(user.getId_univ(), user.getId_fakultas());
			System.out.println(angkatan);
			List<KurikulumModel> kurikulum = KuriDAO.allKurikulum(user.getId_univ(), user.getId_fakultas());
			System.out.println(kurikulum);
			List<LinkStudentKuriModel> angkatankuri = KuriDAO.AllAngkatanKuri(user.getId_univ(), user.getId_fakultas());
			System.out.println(angkatankuri);
			model.addAttribute("kurikulum", kurikulum);
			model.addAttribute("angkatan", angkatan);
			model.addAttribute("angkatankuri", angkatankuri);
			return "kurikulum";
			}
		else if(request.getMethod().equals("POST")){
			
			
//			System.out.println(request.getParameter("angkatan")+ " "+ request.getParameter("kurikulum"));
			KuriDAO.assignKurikulum(request.getParameter("angkatan"), request.getParameter("kurikulum"));
			return "redirect:/assignKurikulum";
		}else {
			return "redirect:/assignKurikulum";
		}
		
	}
	
}
