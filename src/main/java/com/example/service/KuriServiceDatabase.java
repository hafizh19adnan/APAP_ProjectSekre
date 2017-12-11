package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.APIMapper;
import com.example.dao.AppMapper;
import com.example.dao.KuriMapper;
import com.example.model.KurikulumModel;
import com.example.model.LinkStudentKuriModel;
import com.example.model.MahasiswaModel;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class KuriServiceDatabase implements KuriService{

	@Autowired
    private KuriMapper kuriMapper;
	@Autowired
	private APIMapper apiMapper;
	
	@Override
	public List<KurikulumModel> allKurikulum() {
		// TODO Auto-generated method stub
		
		return apiMapper.allKurikulum();
	}

	@Override
	public List<MahasiswaModel> allMahasiswa() {
		// TODO Auto-generated method stub
		return apiMapper.allMahasiswa();
	}

	@Override
	public List<String> allAngkatan() {
		// TODO Auto-generated method stub
		List<String> angkatan = new ArrayList<String>();
		
		List<MahasiswaModel> mahasiswa = allMahasiswa();
//		System.out.println(mahasiswa);
		
		for(int a = 0; a < mahasiswa.size(); a++) {
			String tahun = mahasiswa.get(a).getTahunMasuk();
			if(!angkatan.contains(tahun)) {
				angkatan.add(tahun);
			}
		}
		
		return angkatan;
		
	}

	@Override
	public List<String> allKurikulumName() {
		// TODO Auto-generated method stub
		List<String> kurikulumName = new ArrayList<String>();
		List<KurikulumModel> kurikulum = allKurikulum();
		
		for(int a = 0; a < kurikulum.size(); a++) {
			String nama= kurikulum.get(a).getNamaKurikulum();
			if(!kurikulumName.contains(nama)) {
				kurikulumName.add(nama);
			}
		}
		
		return kurikulumName;
	}

	@Override
	public void assignKurikulum(String angkatan, String kurikulum) {
		// TODO Auto-generated method stub
		List<MahasiswaModel> all= allMahasiswa();
		KurikulumModel assigner = apiMapper.kurikulumByKode(kurikulum);
		List<MahasiswaModel> toAssign = new ArrayList<MahasiswaModel>();
		for (int i = 0; i < all.size(); i++) {
			if(all.get(i).getTahunMasuk().equals(angkatan)) {
				toAssign.add(all.get(i));
			}
		}
		if(checkIfExist(toAssign.get(0).getNpm())) {
			
			for (int i = 0; i < toAssign.size(); i++) {
				
				kuriMapper.updateAssign(toAssign.get(i), assigner.getKodeKurikulum());
			}
			
			
		}else {
			for (int i = 0; i < toAssign.size(); i++) {
				kuriMapper.addAssign(toAssign.get(i), assigner.getKodeKurikulum());
			}
			
		}
		
		
	}

	private boolean checkIfExist(int npm) {
		// TODO Auto-generated method stub
		if(kuriMapper.checkIfExist(npm).isEmpty()) {
			return false;
		}else return true;
		
	}

	@Override
	public List<LinkStudentKuriModel> AllAngkatanKuri() {
		// TODO Auto-generated method stub
		
		List<LinkStudentKuriModel> angkatanKuri = kuriMapper.AngkatanKuriList();
		for (int i = 0; i < angkatanKuri.size(); i++) {
			String newKuri = apiMapper.kurikulumByKode(angkatanKuri.get(i).getKurikulum()).getNamaKurikulum();
//			System.out.println(newKuri);
			angkatanKuri.get(i).setKurikulum(newKuri);
//			System.out.println(angkatanKuri.get(i).getKurikulum());
		}
		return angkatanKuri	;
	}

}
