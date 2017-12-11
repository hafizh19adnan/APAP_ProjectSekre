package com.example.service;

import java.util.List;


import com.example.model.KurikulumModel;
import com.example.model.LinkStudentKuriModel;
import com.example.model.MahasiswaModel;

public interface KuriService {

	List<KurikulumModel> allKurikulum();
	List<MahasiswaModel> allMahasiswa();
	List<String> allAngkatan();
	List<String> allKurikulumName();
	void assignKurikulum(String angkatan, String kurikulum);
	List<LinkStudentKuriModel> AllAngkatanKuri();
	
}
