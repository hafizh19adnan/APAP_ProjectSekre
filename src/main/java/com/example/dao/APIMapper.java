package com.example.dao;

import java.util.List;

import com.example.model.KurikulumModel;
import com.example.model.MahasiswaModel;

public interface APIMapper {
	List<KurikulumModel> allKurikulum();
	List<MahasiswaModel> allMahasiswa();
}
