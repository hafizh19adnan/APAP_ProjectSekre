package com.example.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.ResponseErrorModel;
import com.example.model.ResponseModel;
import com.example.model.TermModel;
import com.example.service.TermService;

@RestController
@RequestMapping("/api")
public class TermRestController {
	@Autowired
	TermService termService;

	@RequestMapping("/getTerm/{id}")
	public Object view(@PathVariable(value = "id") int id) {
		TermModel term = termService.selectTerm(id);
		if(term!=null) {
			return new ResponseModel("200","success",term);
		}else {
			return new ResponseErrorModel("404","Term Not Found");
		}
	}
	
	@RequestMapping("/getAllTerm")
	public Object view() {
		List<TermModel> terms = termService.selectAllTerms();
		if(terms.size()==0 || terms==null) {
			return new ResponseErrorModel("404","Term Data Unavailabe");
		}else {
			return new ResponseModel("200","success", terms);
		}
	}
}