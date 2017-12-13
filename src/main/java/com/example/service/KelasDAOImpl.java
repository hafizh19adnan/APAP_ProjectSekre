/*package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.dao.KelasDAO;
import com.example.model.KurikulumModel;

@Service
public class KelasDAOImpl implements KelasDAO{

	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public List<KurikulumModel> selectAllKurikulum() {
		ResponseEntity<List<KurikulumModel>> rateResponse = restTemplate.exchange("http://localhost:8090/api/getAllKurikulum/", HttpMethod.GET, null,new ParameterizedTypeReference<List<KurikulumModel>>() {});
		List<KurikulumModel> kurikulum = rateResponse.getBody();
		return kurikulum;	
	}
}
*/