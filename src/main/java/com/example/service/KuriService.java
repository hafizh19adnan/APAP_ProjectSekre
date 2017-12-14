package com.example.service;

import java.util.List;

import com.example.model.AngkatanModel;
import com.example.model.KurikulumModel;
import com.example.model.LinkStudentKuriModel;
import com.example.model.MahasiswaModel;

public interface KuriService {

	List<KurikulumModel> allKurikulum(int univ, int fakultas);
	List<MahasiswaModel> allMahasiswa();
	List<AngkatanModel> allAngkatan(int univ, int fakultas);
//	List<String> allKurikulumName();
	void assignKurikulum(String angkatan, String kurikulum);
	List<LinkStudentKuriModel> AllAngkatanKuri(int univ, int fakultas);
	List<LinkStudentKuriModel> AllAngkatanKuriRest();
	
}
