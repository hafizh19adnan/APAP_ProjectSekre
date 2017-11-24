package com.example.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private AppMapper appMapper;

	@Override
	public List<KelasModel> getAllKelas() {
		 log.info ("select all kelas");
	     return appMapper.getAllKelas();
	    }

	@Override
	public KelasModel getKelasById(String id) {
		log.info ("select kelas by id {}", id);
		return appMapper.getKelasById(id);
	}

	@Override
	public List<TermModel> getTermByType(String type) {
		log.info("select term by type {}", type);
		return appMapper.getTermByType(type);
	}

	@Override
	public void createKelas(KelasModel kelas) {
		log.info("create kelas");
		appMapper.updateKelas(kelas);
	}

	@Override
	public void updateKelas(KelasModel kelas) {
		log.info("update kelas");
		appMapper.updateKelas(kelas);
	}

	@Override
	public void deleteKelas(String id) {
		log.info("delete kelas by id {}", id);
		 appMapper.deleteKelas(id);
	}

	@Override
	public KelasModel selectKelas(String id) {
		log.info("select kelas by id {}", id);
		return appMapper.selectKelas(id);
	}

	//method sementara, nunggu api dari kurikulum
	@Override
	public MatkulModel selectMatkul() {
		log.info("select matkul sementaraaa");
		return appMapper.selectMatkul();
	}


}



