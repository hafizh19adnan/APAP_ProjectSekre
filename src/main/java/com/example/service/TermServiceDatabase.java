package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.*;
import com.example.model.*;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TermServiceDatabase implements TermService
{
    @Autowired
    private TermMapper termMapper;


    @Override
    public TermModel selectTerm (int id)
    {
        log.info("select term with id {}", id);
        return termMapper.selectTerm (id);
    }


    @Override
    public List<TermModel> selectAllTerms ()
    {
        log.info("select all terms");
        return termMapper.selectAllTerms ();
    }


    @Override
    public void addTerm (TermModel term)
    {
        termMapper.addTerm(term);
    }


    @Override
    public void deleteTerm (int id)
    {
    	log.info("term"+id+" deleted");
        termMapper.deleteTerm(id);
    }
    
    @Override
    public void updateTerm (TermModel term)
    {
    	log.info(term.getTahunAjaran() + "-" + term.getTermType() + " updated");
    	termMapper.updateTerm(term);
    }

}
