package com.example.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.KelasModel;
import com.example.service.AppService;

@RestController
@RequestMapping("/api")
public class KelasRestController {
	
	@Autowired
	AppService appService;
	
	
	@RequestMapping("/getAllKelas")
	public List<KelasModel> getAll (Model model) {
		
		List<KelasModel> classes = appService.getAllKelas();
        model.addAttribute ("classes", classes);

        return classes;
	}
	
	
	@RequestMapping("/getKelas/{id}")
	public KelasModel getKelasByID (@PathVariable(value="id") String id)  {	
		KelasModel kelas = appService.getKelasById(id);
        return kelas; 
	}
	
}
