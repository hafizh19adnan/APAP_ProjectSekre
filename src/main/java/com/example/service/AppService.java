package com.example.service;

import java.util.List;

import com.example.model.TermModel;
import com.example.model.UserModel;
import com.example.model.LinkStudentKuriModel;
import com.example.model.MatkulModel;
import com.example.model.JadwalModel;
import com.example.model.KelasModel;;

public interface AppService
{
	List<KelasModel> getAllKelas();

	KelasModel getKelasById(String id);
	
	List<TermModel> getTermByType(String type);
	
	void createKelas(KelasModel kelas);
	
	void updateKelas(KelasModel kelas);
	
	void deleteKelas(String id);
	
	KelasModel selectKelas(String id);
	
	//method sementara, nunggu api dari kurikulum
	MatkulModel selectMatkul();

}
