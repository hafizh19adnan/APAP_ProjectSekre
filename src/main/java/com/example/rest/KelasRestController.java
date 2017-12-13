package com.example.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.APIMapper;
import com.example.model.JadwalModel;
import com.example.model.KelasModel;
import com.example.model.KurikulumModel;
import com.example.model.MatkulModel;
import com.example.model.ResponseErrorModel;
import com.example.model.ResponseModel;
import com.example.model.TermModel;
import com.example.service.KelasService;
import com.example.service.TermService;

@RestController
@RequestMapping("/api")
public class KelasRestController {

	@Autowired
	KelasService kelasService;

	@Autowired
	TermService termService;

	@RequestMapping("/getAllKelas")
	public Object getAll() {
		List<TermModel> allTerm = termService.selectAllTerms();
		List<KelasModel> classes = kelasService.getAllKelas();
		for (int i = 0; i < classes.size(); i++) {
			int id_term = classes.get(i).getId_term();
			String nama_term = "";
			for (int j = 0; j < allTerm.size(); j++) {
				int id = allTerm.get(j).getId();
				String tahun = ""+ allTerm.get(j).getTahunAjaran();
				String tipe = ""+ allTerm.get(j).getTermType();
				if (id==id_term) {
					nama_term = tahun+"-"+tipe;
				}
			}
			classes.get(i).setNama_term(nama_term);
		}

		if (classes.size() != 0) {
			return new ResponseModel("200", "success", classes);
		} else {
			return new ResponseErrorModel("404", "Kelas Not Found");
		}

	}

	@RequestMapping("/getKelas/{id}")
	public KelasModel getKelasByID(@PathVariable(value = "id") String id) {

		KelasModel kelas = kelasService.getKelasById(id);

		List<TermModel> allTerm = termService.selectAllTerms();
		int id_term = kelas.getId_term();
		String nama_term = "";
		for (int j = 0; j < allTerm.size(); j++) {
			int id_all_term = allTerm.get(j).getId();
			String tahun = ""+ allTerm.get(j).getTahunAjaran();
			String tipe = ""+ allTerm.get(j).getTermType();
			if (id_all_term==id_term) {
				nama_term = tahun+"-"+tipe;
			}
		}
		kelas.setNama_term(nama_term);
		return kelas;
	}

	@RequestMapping("/getAllKelasByKuriTerm")
	public Object getAllByKuriTerm(@RequestParam(value = "kodeKurikulum", required = false) String kode_kurikulum1,
			@RequestParam(value = "namaTerm", required = false) String nama_term1) {

		List<TermModel> allTerm = termService.selectAllTerms();

		String[] term = nama_term1.split("-");
		String tahunAjaran = term[0];
		String termType = term[1];
		int termTypeInteger = Integer.parseInt(termType);
		int id_term = 0;

		for (int i = 0; i < allTerm.size(); i++) {
			String tahun = allTerm.get(i).getTahunAjaran();
			int tipe = allTerm.get(i).getTermType();
			if (tahun.equals(tahunAjaran) && termTypeInteger == tipe) {
				id_term = allTerm.get(i).getId();
			}
		}
		System.out.println(kode_kurikulum1);
		System.out.println(id_term);
		List<KelasModel> kelasByKuriTerm = kelasService.getAllKelasByKuriTerm(kode_kurikulum1, id_term);
		for (int i = 0; i < kelasByKuriTerm.size(); i++) {
			kelasByKuriTerm.get(i).setNama_term(nama_term1);
		}
		if (kelasByKuriTerm.size() != 0) {
			return new ResponseModel("200", "success", kelasByKuriTerm);
		} else {
			return new ResponseErrorModel("404", "Kelas Not Found");
		}

	}

}
