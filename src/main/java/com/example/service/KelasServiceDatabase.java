package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.KelasMapper;
import com.example.model.JadwalModel;
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
			kelasMapper.createKelas(kelas);
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

		@Override
		public KelasModel selectKelasByNewest() {
			log.info("select kelas by biggest id {}");
			return kelasMapper.selectKelasByNewest();
		}

		@Override
		public void createJadwal(JadwalModel jadwal) {
			log.info("create jadwal");
			kelasMapper.createJadwal(jadwal);
			
		}

		@Override
		public List<KelasModel> getAllKelasByKuriTerm(String kodeKurikulum, int id_term) {
			log.info ("select all kelas by kodeKurikulum and nama_term {}", kodeKurikulum);
			log.info ("select all kelas by kodeKurikulum and nama_term {}", id_term);
			return kelasMapper.getAllKelasByKuriTerm(kodeKurikulum, id_term);
		}

		@Override
		public void deleteJadwal(String id) {
			// TODO Auto-generated method stub
			log.info("delete jadwal by id {}", id);
			kelasMapper.deleteJadwal(id);
		}

		@Override
		public JadwalModel selectJadwal(String id) {
			// TODO Auto-generated method stub
			log.info("select jadwal by id {}", id);
			return kelasMapper.selectJadwal(id);
		}

		@Override
		public void updateJadwal(JadwalModel jadwal) {
		log.info("update jadwal");
		kelasMapper.updateJadwal(jadwal);
		}

//		@Override
//		public List<KelasModel> getKelasByKuriTerm(String kodeKurikulum, String nama_term) {
//			log.info ("select all kelas by kodeKurikulum and nama_term {}", kodeKurikulum, nama_term);
//			return kelasMapper.getKelasByKuriTerm(kodeKurikulum, nama_term);
//			
//		}
		
		
}
