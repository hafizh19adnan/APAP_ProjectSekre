package com.example.service;

import java.util.List;

import com.example.model.KurikulumModel;
import com.example.model.MahasiswaModel;

public interface KuriService {

	List<KurikulumModel> allKurikulum();
	List<MahasiswaModel> allMahasiswa();
	List<String> allAngkatan(List<MahasiswaModel> listMahasiswa);
	
}
