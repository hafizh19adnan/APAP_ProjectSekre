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
		
		ResponseModel stuff = restTemplate.getForObject("http://localhost:8090/api/getAllKurikulum", ResponseModel.class);
		
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
		ResponseModel stuff = restTemplate.getForObject("http://localhost:8090/api/getKurikulumByKode?kodeKurikulum="+Kode, ResponseModel.class);
		
		LinkedHashMap kurikulum = (LinkedHashMap) stuff.getResult();
		
		
		ObjectMapper mapper = new ObjectMapper();
		
		return mapper.convertValue(kurikulum, KurikulumModel.class);
	}

}
