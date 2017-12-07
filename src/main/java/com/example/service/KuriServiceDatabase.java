package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.APIMapper;
import com.example.dao.AppMapper;
import com.example.dao.KuriMapper;
import com.example.model.KurikulumModel;
import com.example.model.MahasiswaModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class KuriServiceDatabase implements KuriService{

//	@Autowired
//    private KuriMapper kuriMapper;
	@Autowired
	private APIMapper apiMapper;
	
	@Override
	public List<KurikulumModel> allKurikulum() {
		// TODO Auto-generated method stub
		
		return apiMapper.allKurikulum();
	}

	@Override
	public List<MahasiswaModel> allMahasiswa() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> allAngkatan(List<MahasiswaModel> listMahasiswa) {
		// TODO Auto-generated method stub
		return null;
	}

}
