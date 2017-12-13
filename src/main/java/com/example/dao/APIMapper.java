package com.example.dao;

import java.util.List;

import com.example.model.KurikulumModel;
import com.example.model.MahasiswaModel;

public interface APIMapper {
	List<KurikulumModel> allKurikulum();
	List<MahasiswaModel> allMahasiswa();
	KurikulumModel kurikulumByKode(String Kode);
	String getNamaProdi(int univ, int fakultas, int prodi);
	String getNamaUniv(int id_univ);
	String getNamaFakultas(int id_univ, int id_fakultas);
	
}
