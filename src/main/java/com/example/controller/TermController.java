package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.model.*;
import com.example.service.*;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class TermController
{
    @Autowired
    TermService termDAO;

    @RequestMapping("/term/detail")
    public String view (Model model,
            @RequestParam(value = "id", required = false) int id)
    {
        TermModel term = termDAO.selectTerm (id);

        if (term != null) {
            model.addAttribute ("term", term);
            return "term-detail";
        } else {
            model.addAttribute ("id", id);
            return "term-not-found";
        }
    }


    @RequestMapping("/term/detail/{id}")
    public String viewPath (Model model,
            @PathVariable(value = "id") int id)
    {
        TermModel term = termDAO.selectTerm(id);

        if (term != null) {
            model.addAttribute ("term", term);
            return "term-detail";
        } else {
            model.addAttribute ("id", id);
            return "term-not-found";
        }
    }


    @RequestMapping("/term")
    public String view (Model model)
    {
        List<TermModel> terms = termDAO.selectAllTerms();
        model.addAttribute ("terms", terms);

        return "term";
    }

    
    @RequestMapping("/term/update/{id}")
    public String updatePath (Model model,
                            @PathVariable(value = "id") int id)
    {
        TermModel term = termDAO.selectTerm(id);

        if (term != null) {
            model.addAttribute ("term", term);
            return "term-update";
        } else {
            model.addAttribute ("id", id);
            return "term-not-found";
        }
    }

    @RequestMapping("/term/update/submit")
    public String updateSubmit (
            @ModelAttribute TermModel term)
    {
        term.updateTermType(term.getTS(), term.getTermType());
    	termDAO.updateTerm(term);
        return "term-success-update";
    }

    
    @RequestMapping("/term/add/submit")
    public String addSubmit (
            @RequestParam(value = "nomor", required = false) String nomor,
            @RequestParam(value = "tglIrsStart", required = false) String tglIrsStart,
            @RequestParam(value = "tglIrsEnd", required = false) String tglIrsEnd,
            @RequestParam(value = "isiIrsStart", required = false) String isiIrsStart,
            @RequestParam(value = "isiIrsEnd", required = false) String isiIrsEnd,
            @RequestParam(value = "termString", required = false) String termString)
    {
        int termType= 0;
        if(termString.equals("Ganjil")) {
        	termType = 1;
        }
        else if(termString.equals("Genap")) {
        	termType = 2;
        }
        else {
        	termType= 3;
        }
        	
        TermModel term = new TermModel (null, nomor, tglIrsStart, tglIrsEnd, isiIrsStart, isiIrsEnd, termType, termString);
        log.info(""+term);
    	termDAO.addTerm(term);

        return "term-success-add";
    }

    
    @RequestMapping("/term/delete/{id}")
    public String delete (Model model, @PathVariable(value = "id") int id)
    {
    	TermModel term = termDAO.selectTerm (id);

        if (term != null) {
            termDAO.deleteTerm(id);
            return "term-delete";
        } else {
            model.addAttribute ("id", id);
            return "term-not-found";
        }
        
    }
    
}
