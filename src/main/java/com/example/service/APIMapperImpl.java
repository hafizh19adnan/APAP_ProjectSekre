package com.example.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.dao.APIMapper;
import com.example.model.KurikulumModel;
import com.example.model.MahasiswaModel;
import com.example.model.ResponseModel;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class APIMapperImpl implements APIMapper {

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
	   // Do any additional configuration here
	   return builder.build();
	}
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public List<KurikulumModel> allKurikulum() {
		// TODO Auto-generated method stub
		
//		Dummy Lokal
//		ResponseModel stuff = restTemplate.getForObject("http://localhost:8090/api/getAllKurikulum", ResponseModel.class);
//		RealAPI
		ResponseModel stuff = restTemplate.getForObject("http://localhost:8081/api/getAllKurikulum", ResponseModel.class);
		
		ArrayList<LinkedHashMap> kurikulum = (ArrayList<LinkedHashMap>) stuff.getResult();
		System.out.println(kurikulum.get(0));
		List<KurikulumModel> ret = new ArrayList<>();
		
		ObjectMapper mapper = new ObjectMapper();
		
		for (int i = 0; i < kurikulum.size(); i++) {
			ret.add(mapper.convertValue(kurikulum.get(i), KurikulumModel.class));
		}
		return ret;
	}

	@Override
	public List<MahasiswaModel> allMahasiswa() {
		// TODO Auto-generated method stub
		
		MahasiswaModel[] mahasiswa= restTemplate.getForObject("http://localhost:8090/api/getAllMahasiswa", MahasiswaModel[].class);
		
		return Arrays.asList(mahasiswa);
	}

	@Override
	public KurikulumModel kurikulumByKode(String Kode) {
		// TODO Auto-generated method stub
		
		// Dummy Lokal
//		ResponseModel stuff = restTemplate.getForObject("http://localhost:8090/api/getKurikulumByKode?kodeKurikulum="+Kode, ResponseModel.class);
		// RealAPI
		ResponseModel stuff = restTemplate.getForObject("http://localhost:8081/api/getKurikulum?kodeKurikulum="+Kode, ResponseModel.class);
		
		LinkedHashMap kurikulum = (LinkedHashMap) stuff.getResult();
		
		
		ObjectMapper mapper = new ObjectMapper();
		
		return mapper.convertValue(kurikulum, KurikulumModel.class);
	}

	@Override
	public String getNamaProdi(int univ, int fakultas, int prodi) {
		// TODO Auto-generated method stub
		ResponseModel stuff = restTemplate.getForObject("https://apap2017-univ-apps.herokuapp.com/getProdi/"+univ +"/" +fakultas+"/"+prodi, ResponseModel.class);
		LinkedHashMap kelasProdi = (LinkedHashMap) stuff.getResult();
		LinkedHashMap namaProdi = (LinkedHashMap) kelasProdi.get("prodi");
		
		return String.valueOf(namaProdi.get("nama_prodi"));
	}

	@Override
	public String getNamaUniv(int id_univ) {
		// TODO Auto-generated method stub
		ResponseModel stuff = restTemplate.getForObject("https://apap2017-univ-apps.herokuapp.com/getUniversitas/"+id_univ, ResponseModel.class);
		LinkedHashMap kelasUniv = (LinkedHashMap) stuff.getResult();
		LinkedHashMap namaUniv = (LinkedHashMap) kelasUniv.get("universitas");
		return String.valueOf(namaUniv.get("nama_univ"));
	}

	@Override
	public String getNamaFakultas(int id_univ, int id_fakultas) {
		// TODO Auto-generated method stub
		ResponseModel stuff = restTemplate.getForObject("https://apap2017-univ-apps.herokuapp.com/getFakultas/"+id_univ +"/" +id_fakultas, ResponseModel.class);
		LinkedHashMap kelasFakultas = (LinkedHashMap) stuff.getResult();
		LinkedHashMap namaFakultas= (LinkedHashMap) kelasFakultas.get("fakultas");
		return String.valueOf(namaFakultas.get("nama_fakultas"));
	}

}
