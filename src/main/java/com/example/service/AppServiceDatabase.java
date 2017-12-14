package com.example.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.APIMapper;
import com.example.dao.AppMapper;
import com.example.model.TermModel;
import com.example.model.UserModel;
import com.example.model.LinkStudentKuriModel;
import com.example.model.MatkulModel;
import com.example.model.JadwalModel;
import com.example.model.KelasModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AppServiceDatabase implements AppService
{
	@Autowired
	AppMapper appMapper;
	
	@Autowired
	APIMapper apiMapper;
	
	@Override
	public UserModel getLoggedInUser(String name) {
		UserModel toReturn =appMapper.getLoggedUser(name);
		toReturn.setNama_univ(apiMapper.getNamaUniv(toReturn.getId_univ()));
		toReturn.setNama_fakultas(apiMapper.getNamaFakultas(toReturn.getId_univ(), toReturn.getId_fakultas()));
		return toReturn;
	}
   


}



