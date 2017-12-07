package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.dao.APIMapper;
import com.example.model.KurikulumModel;
import com.example.model.MahasiswaModel;
import com.example.model.ResponseModel;


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
		List<KurikulumModel> kurikulum = (List<KurikulumModel>) stuff.getResult();
		return kurikulum;
	}

	@Override
	public List<MahasiswaModel> allMahasiswa() {
		// TODO Auto-generated method stub
		List<KurikulumModel> kurikulum = restTemplate.getForObject("http://localhost:8090/api/getAllKurikulum", List.class);
		return null;
	}

}
