package com.example.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TermModel {
	private Integer id;
    private String tahunAjaran;
    private String tglIrsStart;
    private String tglIrsEnd;
    private String isiIrsStart;
    private String isiIrsEnd;
    private int termType;
    
    @JsonIgnore
    private String termString;
    
    @JsonIgnore
    public String getTS()
    {
    	return termString;
    }
	
    @JsonIgnore
    public String getTermString() {
    	if(termType==1) {
    		this.termString = "Ganjil";
    	}
    	else if(termType==2) {
    		this.termString = "Genap";
    	}
    	else {
    		this.termString = "Semester Pendek";
    	}
    	return termString;
	}
    

    
    public void updateTermType(String termString ,int termType) {
	    if(this.termString.equals("Ganjil")) {
	    	this.termType = 1;
	    }
	    else if(this.termString.equals("Genap")) {
	    	this.termType = 2;
	    }
	    else {
	    	this.termType = 3;
	    }
	}
  
}
