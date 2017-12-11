package com.example.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.LinkStudentKuriModel;
import com.example.model.ResponseErrorModel;
import com.example.model.ResponseModel;
import com.example.model.TermModel;
import com.example.service.KuriService;
import com.example.service.TermService;

@RestController
@RequestMapping("/api")
public class KuriRestController {

	@Autowired
	KuriService kuriDAO;
	
	@RequestMapping("/getAngkatanKurikulumList")
	public Object getAngkatanKurikulumList(){
		
			List<LinkStudentKuriModel> StudentKuri = kuriDAO.AllAngkatanKuri();
			if(StudentKuri!=null) {
				return new ResponseModel("200","success",StudentKuri);
			}else {
				return new ResponseErrorModel("404","Term Not Found");
			}
		
	}	
}
