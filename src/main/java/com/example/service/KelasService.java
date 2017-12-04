package com.example.service;

import java.util.List;

import com.example.model.KelasModel;
import com.example.model.MatkulModel;
import com.example.model.TermModel;

public interface KelasService {
	List<KelasModel> getAllKelas();

	KelasModel getKelasById(String id);
	
	List<TermModel> getTermByType(String type);
	
	void createKelas(KelasModel kelas);
	
	void updateKelas(KelasModel kelas);
	
	void deleteKelas(String id);
	
	KelasModel selectKelas(String id);
	
	//method sementara, nunggu api dari kurikulum
	List<MatkulModel> selectMatkul();


}
