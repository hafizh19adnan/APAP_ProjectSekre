package com.example.controller;

//import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
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
		return "home";
	}
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/kelas/delete")
	public void deleteKelas() {
		
	}
	
	
    @RequestMapping("/kelas/delete/{id}")
    public void deleteKelas (Model model, @PathVariable(value = "id") String id)
    {
    	  KelasModel kelas = appDAO.selectKelas(id);

          if (kelas != null) {
        	  appDAO.deleteKelas (id);
          } else {
              model.addAttribute ("message", "not-found");
          }
          
        
    }
    
    @RequestMapping("/kelas/update/{id}")
    public String updateKelas (Model model, @PathVariable(value = "id") String id)
    {
    	  KelasModel kelas = appDAO.selectKelas(id);
    	  
          if (kelas != null) {
        	  appDAO.updateKelas (kelas);
        	  return "form-update";
          } else {
              model.addAttribute ("message", "not-found");
              return "not-found";
          }
    }
    
    @RequestMapping(value = "/kelas/update", method = RequestMethod.POST)
    public void updateSubmit (@ModelAttribute KelasModel kelas) {
         appDAO.updateKelas(kelas);     
    }
    
    
        @RequestMapping("/kelas/add")
    public String add (Model headerTitle)
    {
        return "form-add";
    }


    @RequestMapping(value = "/kelas/add", method = RequestMethod.POST)
    public void addSubmit (@ModelAttribute KelasModel kelas)
    {
    	//sementara pake appDAO krn blm ada dr api nya
    	MatkulModel matkul = appDAO.selectMatkul();
    	
    	
    	String nama_matkul = matkul.getNamaMatkul();
    	kelas.setNama_matkul(nama_matkul);
        appDAO.createKelas(kelas);
    }
    
    

     


     
    
}
