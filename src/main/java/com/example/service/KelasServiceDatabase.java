package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.KelasMapper;
import com.example.model.KelasModel;
import com.example.model.MatkulModel;
import com.example.model.TermModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class KelasServiceDatabase implements KelasService {

	
	 @Autowired
	    private KelasMapper kelasMapper;

		@Override
		public List<KelasModel> getAllKelas() {
			 log.info ("select all kelas");
		     return kelasMapper.getAllKelas();
		    }

		@Override
		public KelasModel getKelasById(String id) {
			log.info ("select kelas by id {}", id);
			return kelasMapper.getKelasById(id);
		}

		@Override
		public List<TermModel> getTermByType(String type) {
			log.info("select term by type {}", type);
			return kelasMapper.getTermByType(type);
		}

		@Override
		public void createKelas(KelasModel kelas) {
			log.info("create kelas");
			kelasMapper.updateKelas(kelas);
		}

		@Override
		public void updateKelas(KelasModel kelas) {
			log.info("update kelas");
			kelasMapper.updateKelas(kelas);
		}

		@Override
		public void deleteKelas(String id) {
			log.info("delete kelas by id {}", id);
			 kelasMapper.deleteKelas(id);
		}

		@Override
		public KelasModel selectKelas(String id) {
			log.info("select kelas by id {}", id);
			return kelasMapper.selectKelas(id);
		}

		//method sementara, nunggu api dari kurikulum
		@Override
		public List<MatkulModel> selectMatkul() {
			log.info("select matkul sementaraaa");
			return kelasMapper.selectMatkul();
		}
}
