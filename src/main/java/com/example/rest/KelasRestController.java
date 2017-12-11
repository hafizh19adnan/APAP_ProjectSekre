package com.example.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.KelasModel;
import com.example.service.KelasService;

@RestController
@RequestMapping("/api")
public class KelasRestController {
	
	@Autowired
	KelasService kelasService;
	
	
	@RequestMapping("/getAllKelas")
	public List<KelasModel> getAll (Model model) {
		
		List<KelasModel> classes = kelasService.getAllKelas();
        model.addAttribute ("classes", classes);

        return classes;
	}
	
	
	@RequestMapping("/getKelas/{id}")
	public KelasModel getKelasByID (@PathVariable(value="id") String id)  {
		
		KelasModel kelas = kelasService.getKelasById(id);
        return kelas; 
	}
	/*
	@RequestMapping("/getKelas/")
	public KelasModel getKelasByID (@PathVariable(value="id") String id)  {
		
		KelasModel kelas = kelasService.getKelasById(id);
        return kelas; 
	}
	
	@RequestMapping("/getKelas")
	public Object getKelas (Model model, @RequestParam(value = "kodeKurikulum", required = false) String kodeKurikulum, @RequestParam(value = "nama_term", required = false) String nama_term) {
	
		KelasModel kelas = kelasService.getKelasByKuriTerm(kodeKurikulum, nama_term);
		if(kelas != null) {
			return new ResponseModel("200","success", kelas);
		}else {
			return new ResponseErrorModel("404", "Kelas Not Found")
		}
	}
	*/
}
