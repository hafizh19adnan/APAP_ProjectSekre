package com.example.service;

import java.util.List;

import com.example.model.*;

public interface TermService
{
    TermModel selectTerm(int id);


    List<TermModel> selectAllTerms();


    void addTerm (TermModel term);


    void deleteTerm (int id);
    
    void updateTerm (TermModel term);
}
