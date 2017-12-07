package com.example.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.KelasModel;
import com.example.model.ResponseErrorModel;
import com.example.model.ResponseModel;
import com.example.service.KelasService;

@RestController
@RequestMapping("/api")
public class KelasRestController {
	
	@Autowired
	KelasService kelasService;
	
	
	@RequestMapping("/getAllKelas")
	public Object getAll (Model model) {
		List<KelasModel> classes = kelasService.getAllKelas();
        if(classes==null || classes.size()==0) {
        	return new ResponseErrorModel("404","Kelas Data Unavailable");
        }else {
        	return new ResponseModel("200","success",classes);
        }
	}
	
	
	@RequestMapping("/getKelas/{id}")
	public Object getKelasByID (@PathVariable(value="id") String id)  {
		KelasModel kelas = kelasService.getKelasById(id);
        if(kelas==null) {
        	return new ResponseErrorModel("404", "Kelas Data Not Found");
        }else {
        	return new ResponseModel("200","success",kelas);
        } 
	}
}
