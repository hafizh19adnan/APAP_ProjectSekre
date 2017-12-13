package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.APIMapper;
import com.example.dao.AppMapper;
import com.example.dao.KuriMapper;
import com.example.model.AngkatanModel;
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
	public List<KurikulumModel> allKurikulum(int univ, int fakultas) {
		// TODO Auto-generated method stub
		List<KurikulumModel> toReturn = new ArrayList<>();
		List<KurikulumModel> toCheck = apiMapper.allKurikulum();
		for (int i = 0; i < toCheck.size(); i++) {
			if(toCheck.get(i).getIdFakultas() == fakultas && toCheck.get(i).getIdUniversitas()==univ) {
				toReturn.add(toCheck.get(i));
			}
		}
		
		return toReturn;
	}

	@Override
	public List<MahasiswaModel> allMahasiswa() {
		// TODO Auto-generated method stub
		return apiMapper.allMahasiswa();
	}

	@Override
	public List<AngkatanModel> allAngkatan(int univ, int fakultas) {
		// TODO Auto-generated method stub
		List<AngkatanModel> angkatan = new ArrayList<>();
		
		List<MahasiswaModel> mahasiswa = allMahasiswa();
//		System.out.println(mahasiswa);
		
		for(int a = 0; a < mahasiswa.size(); a++) {
			String tahun = mahasiswa.get(a).getTahunMasuk();
			if(mahasiswa.get(a).getIdUniv().equals(String.valueOf(univ)) && mahasiswa.get(a).getIdFakultas().equals(String.valueOf(fakultas))) {
				tahun = tahun.concat(" - "+apiMapper.getNamaProdi(univ, fakultas, Integer.valueOf(mahasiswa.get(a).getIdProdi())));
				AngkatanModel toInput = new AngkatanModel(mahasiswa.get(a).getTahunMasuk(), mahasiswa.get(a).getIdProdi(), tahun);
				
				if(!angkatan.contains(toInput)) {
					angkatan.add(toInput);
				}
				
				
			}
		}
		
		return angkatan;
		
	}

//	@Override
//	public List<String> allKurikulumName() {
//		// TODO Auto-generated method stub
//		List<String> kurikulumName = new ArrayList<String>();
//		List<KurikulumModel> kurikulum = allKurikulum();
//		
//		for(int a = 0; a < kurikulum.size(); a++) {
//			String nama= kurikulum.get(a).getNamaKurikulum();
//			if(!kurikulumName.contains(nama)) {
//				kurikulumName.add(nama);
//			}
//		}
//		
//		return kurikulumName;
//	}

	@Override
	public void assignKurikulum(String angkatan, String kurikulum) {
		// TODO Auto-generated method stub
		String[] toCheck = angkatan.split("-");
		String tahun = toCheck[0];
		String prodi = toCheck[1];
		List<MahasiswaModel> all= allMahasiswa();
		KurikulumModel assigner = apiMapper.kurikulumByKode(kurikulum);
		List<MahasiswaModel> toAssign = new ArrayList<MahasiswaModel>();
		for (int i = 0; i < all.size(); i++) {
			if(all.get(i).getTahunMasuk().equals(tahun) && all.get(i).getIdProdi().equals(prodi)) {
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
	public List<LinkStudentKuriModel> AllAngkatanKuri(int univ, int fakultas) {
		// TODO Auto-generated method stub
		
		List<LinkStudentKuriModel> angkatanKuri = kuriMapper.AngkatanKuriList();
		System.out.println(angkatanKuri);
		List<LinkStudentKuriModel> toReturn = new ArrayList<>();
		for (int i = 0; i < angkatanKuri.size(); i++) {
			System.out.println(i);
			if (angkatanKuri.get(i).getIdFakultas().equals(String.valueOf(fakultas)) && angkatanKuri.get(i).getIdUniv().equals(String.valueOf(univ))) {
				String newKuri = apiMapper.kurikulumByKode(angkatanKuri.get(i).getKurikulum()).getNamaKurikulum();
				System.out.println(newKuri);
				angkatanKuri.get(i).setKurikulum(newKuri);
				
				String cetakAngkatan = angkatanKuri.get(i).getAngkatan();
				
				cetakAngkatan = cetakAngkatan + " - " + apiMapper.getNamaProdi(univ, fakultas, Integer.valueOf(angkatanKuri.get(i).getIdProdi()));
				
				angkatanKuri.get(i).setAngkatan(cetakAngkatan);
				if(!toReturn.contains(angkatanKuri.get(i))) {
					toReturn.add(angkatanKuri.get(i));
				}
				
//				System.out.println(angkatanKuri.get(i).getKurikulum());
			}
			
		}
		return toReturn	;
	}

	@Override
	public List<LinkStudentKuriModel> AllAngkatanKuriRest() {
		List<LinkStudentKuriModel> angkatanKuri = kuriMapper.AngkatanKuriList();
		List<LinkStudentKuriModel> toReturn = new ArrayList<>();
		for (int i = 0; i < angkatanKuri.size(); i++) {
			if (!toReturn.contains(angkatanKuri.get(i))) {
				toReturn.add(angkatanKuri.get(i));
			}
		}
		return toReturn;
	}
	

}
