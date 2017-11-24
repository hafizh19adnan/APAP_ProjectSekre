package com.example.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.model.TermModel;
import com.example.service.TermService;

@RestController
@RequestMapping("/api")
public class TermRestController {
	@Autowired
	TermService termService;

	@RequestMapping("/getTerm/{id}")
	public TermModel view(@PathVariable(value = "id") int id) {
		TermModel term = termService.selectTerm(id);
		return term;
	}
	
	@RequestMapping("/getAllTerm")
	public List<TermModel> view() {
		List<TermModel> terms = termService.selectAllTerms();
		return terms;
	}
}