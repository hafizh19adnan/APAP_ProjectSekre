package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.dao.APIMapper;
import com.example.dao.KelasDAO;
import com.example.model.JadwalModel;
import com.example.model.KelasModel;
import com.example.model.KurikulumModel;
import com.example.model.MatkulModel;
import com.example.model.TermModel;
import com.example.service.KelasService;
import com.example.service.TermService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class KelasController {
	
	@Autowired
    KelasService kelasDAO;
	
	@Autowired
	APIMapper apiMapperImpl;
	
	@Autowired
	TermService termDAO;

	@RequestMapping("/kelas")
	public String view(Model model, Model modelMatkul, Model modelTerm, Model modelKuri,
			@RequestParam(value = "kode_kurikulum",required=false) String kode_kurikulum) {
		
		if(kode_kurikulum==null) {
			return "redirect:/pilihKurikulum";
		}
		
		KurikulumModel kuri = new KurikulumModel();
		kuri.setKodeKurikulum(kode_kurikulum);
		System.out.println("inikode+"+kode_kurikulum);
		modelKuri.addAttribute("kuri", kuri);

		List<KelasModel> semuakelas = kelasDAO.getAllKelas();
		//udh ada api getAllKurikulum
		List<KurikulumModel> kurikulum = apiMapperImpl.allKurikulum();
		KurikulumModel kurikulumNow = null;
		
		for (int i = 0; i < kurikulum.size(); i++) {
			if (kurikulum.get(i).getKodeKurikulum().equals(kode_kurikulum)) {
				kurikulumNow = kurikulum.get(i);
			}
		}
		
		List<MatkulModel> MatkulByKurikulum = kurikulumNow.getListMataKuliah();
		modelMatkul.addAttribute("matkul", MatkulByKurikulum);
		List<TermModel> allTerm = termDAO.selectAllTerms();
		
		for (int i = 0; i < allTerm.size(); i++) {
			String tahun = allTerm.get(i).getTahunAjaran();
			String tipe = allTerm.get(i).getTermString();
			String tahunDantipe = tahun+" - "+tipe;
			allTerm.get(i).setTahunDantipe(tahunDantipe);
		}
		
		modelTerm.addAttribute("term", allTerm);
		
		//ini kalo udh ada kode kurikulum
		List<KelasModel> kelasByKurikulum = new ArrayList<KelasModel>();
		
		for (int i = 0; i < semuakelas.size(); i++) {
			if (semuakelas.get(i).getKode_kurikulum().equals(kode_kurikulum)) {
				kelasByKurikulum.add(semuakelas.get(i));
			}
		}
		
		String nama_matkul = "";
		
		for (int i = 0; i < kelasByKurikulum.size(); i++) {
			KelasModel kelasNow = kelasByKurikulum.get(i);	
			TermModel term = termDAO.selectTerm(kelasNow.getId_term());
	    	 String tahun_term = term.getTahunAjaran();
	    	 String jenis_term = Integer.toString(term.getTermType());
	    	 String nama_term = tahun_term +"-"+jenis_term;
	    	 kelasByKurikulum.get(i).setNama_term(nama_term);
			int idMatkul = kelasNow.getId_matkul();
			for (int j = 0; j < MatkulByKurikulum.size(); j++) {
				if (idMatkul == MatkulByKurikulum.get(j).getIdMatkul()) {
					nama_matkul = MatkulByKurikulum.get(j).getNamaMatkul();
					kelasByKurikulum.get(i).setNama_matkul(nama_matkul);
				}
			}
			
			List<JadwalModel> jadwal = kelasNow.getJadwal_masuk();
			
			StringBuilder stringBuilderHari = new StringBuilder();
			StringBuilder stringBuilderJam = new StringBuilder();

			for (int k = 0; k < jadwal.size(); k++) {
				JadwalModel jadwalNow = jadwal.get(k);
				stringBuilderHari.append(jadwalNow.getHari());
				stringBuilderJam.append(jadwalNow.getJam_masuk()).append(" - ").append(jadwalNow.getJam_keluar());
				
				if (k+1 !=jadwal.size()) {
					//tambah enter
					stringBuilderHari.append("||");
					stringBuilderJam.append("||");
					
				}
			}
			String hari = stringBuilderHari.toString();
			String jam = stringBuilderJam.toString();
			kelasByKurikulum.get(i).setHari(hari);
			kelasByKurikulum.get(i).setJam(jam);
		}
		System.out.println("-----------------------"+'\n'+semuakelas.size());
		
		model.addAttribute("semuakelas", kelasByKurikulum);
		return "kelas";
	}
	
	
	
	  @RequestMapping("/kelas/detail/{id}")
	    public String viewPath (Model model,
	            @PathVariable(value = "id") String id)
	    {
	        KelasModel kelas = kelasDAO.getKelasById(id);
	        

	        if (kelas != null) {
	        	TermModel term = termDAO.selectTerm(kelas.getId_term());
		    	 String tahun_term = term.getTahunAjaran();
		    	 String jenis_term = Integer.toString(term.getTermType());
		    	 String nama_term = tahun_term +"-"+jenis_term;
		    	 kelas.setNama_term(nama_term);
	        	String kode_kurikulum = kelas.getKode_kurikulum();
	        	//udh ada api getAllKurikulum
	    		List<KurikulumModel> kurikulum = apiMapperImpl.allKurikulum();
	    		KurikulumModel kurikulumNow = null;
	    		
	    		for (int i = 0; i < kurikulum.size(); i++) {
	    			if (kurikulum.get(i).getKodeKurikulum().equals(kode_kurikulum)) {
	    				kurikulumNow = kurikulum.get(i);
	    			}
	    		}
	    		
	    		List<MatkulModel> MatkulByKurikulum = kurikulumNow.getListMataKuliah();
	    		
	    		String nama_matkul = "";
	    		int idMatkul = kelas.getId_matkul();
				for (int j = 0; j < MatkulByKurikulum.size(); j++) {
					if (idMatkul == MatkulByKurikulum.get(j).getIdMatkul()) {
						nama_matkul = MatkulByKurikulum.get(j).getNamaMatkul();
						kelas.setNama_matkul(nama_matkul);
					}
				}
				
				List<JadwalModel> jadwal = kelas.getJadwal_masuk();
				
				StringBuilder stringBuilderHari = new StringBuilder();
				StringBuilder stringBuilderJam = new StringBuilder();

				for (int k = 0; k < jadwal.size(); k++) {
					JadwalModel jadwalNow = jadwal.get(k);
					stringBuilderHari.append(jadwalNow.getHari());
					stringBuilderJam.append(jadwalNow.getJam_masuk()).append(" - ").append(jadwalNow.getJam_keluar());
					
					if (k+1 !=jadwal.size()) {
						//tambah enter
						stringBuilderHari.append("\n");
						stringBuilderJam.append("\n");
						
					}
				}
				String hari = stringBuilderHari.toString();
				String jam = stringBuilderJam.toString();
				kelas.setHari(hari);
				kelas.setJam(jam);
	    		
	            model.addAttribute ("kelas", kelas);
	            return "kelas-detail";
	        } else {
	            model.addAttribute ("id", id);
	            return "kelas-not-found";
	        }
	    }

    @RequestMapping("/kelas/delete/{id}")
    public String deleteKelas (Model model, @PathVariable(value = "id") String id)
    {
    	  KelasModel kelas = kelasDAO.selectKelas(id);

          if (kelas != null) {
        	  kelasDAO.deleteKelas (id);
        	  return "kelas-delete";
          } else {
              model.addAttribute ("id", id);
              return "kelas-not-found";
          }
          
          //sementara, kalo kelas diapus, jadwal ttp ada ya
          //solusi: pake FK di DB
     
    }
    
    @RequestMapping("/jadwal/delete/{id}")
    public void deleteJadwal (Model model, @PathVariable(value = "id") String id)
    {
    	  JadwalModel jadwal = kelasDAO.selectJadwal(id);

          if (jadwal != null) {
        	  kelasDAO.deleteJadwal(id);
          }
          
          //sementara, kalo kelas diapus, jadwal ttp ada ya
          //solusi: pake FK di DB
     
    }
    
    

    @RequestMapping("/kelas/update/{id}")
    public String updateKelas (Model model, Model modelMatkul, Model modelTerm, @PathVariable(value = "id") String id)
    {
    	  KelasModel kelas = kelasDAO.getKelasById(id);
    	  kelas.setJam("test123");
    	  String kode_kurikulum = kelas.getKode_kurikulum();
    	//udh ada api getAllKurikulum
    	  
  		List<KurikulumModel> kurikulum = apiMapperImpl.allKurikulum();
  		KurikulumModel kurikulumNow = null;
  		model.addAttribute("kuri", kode_kurikulum);
  		model.addAttribute("hari", "asdasdad");
  		for (int i = 0; i < kurikulum.size(); i++) {
  			if (kurikulum.get(i).getKodeKurikulum().equals(kode_kurikulum)) {
  				kurikulumNow = kurikulum.get(i);
  			}
  		}
  		
  		List<MatkulModel> MatkulByKurikulum = kurikulumNow.getListMataKuliah();
  		modelMatkul.addAttribute("matkul", MatkulByKurikulum);
  		List<TermModel> allTerm = termDAO.selectAllTerms();
  		
  		for (int i = 0; i < allTerm.size(); i++) {
			String tahun = allTerm.get(i).getTahunAjaran();
			String tipe = allTerm.get(i).getTermString();
			String tahunDantipe = tahun+" - "+tipe;
			allTerm.get(i).setTahunDantipe(tahunDantipe);
		}
		
  		
  		modelTerm.addAttribute("term", allTerm);
    	  
          if (kelas != null) {
        	  TermModel term = termDAO.selectTerm(kelas.getId_term());
		    	 String tahun_term = term.getTahunAjaran();
		    	 String jenis_term = Integer.toString(term.getTermType());
		    	 String nama_term = tahun_term +"-"+jenis_term;
		    	 kelas.setNama_term(nama_term);
		    	 
        	  model.addAttribute("kelas", kelas);
        //	  System.out.println(kelas.getJadwal_masuk());
        	  return "kelas-update";
          } else {
              return "kelas-not-found";
          }
    }
    
    
    @RequestMapping(value = "/kelas/updatesubmit", method = RequestMethod.GET)
    public String updateSubmit (@ModelAttribute KelasModel kelas) {
//        List<JadwalModel> jadwal = kelas.getJadwal_masuk();
    	System.out.println("=======  " + kelas + "  =======");
    	kelasDAO.updateKelas(kelas);
    	String[] arrIdJadwal = kelas.getJam().split(",");
    	for (int ii = 0; ii < arrIdJadwal.length; ii++) {
    		kelasDAO.deleteJadwal(arrIdJadwal[ii]);
    	}
    	return "class-update-success";
    } 
    
    
       @RequestMapping("/kelas/add/submit/")
    public String addSubmit (
            @RequestParam(value = "nama_kelas", required = false) String nama_kelas,
            @RequestParam(value = "id_matkul", required = false) int id_matkul,
            @RequestParam(value = "nama_dosen", required = false) String dosen,
            @RequestParam(value = "hari", required = false)  List<String> hari,
            @RequestParam(value = "ruangan", required = false) String ruangan,
            @RequestParam(value = "id_term", required = false) int id_term,
            @RequestParam(value = "jam_masuk", required = false)  List<String> jam_masuk,
            @RequestParam(value = "jam_selesai", required = false)  List<String> jam_selesai,
            @RequestParam(value = "kodeKurikulum", required = false) String kode_kurikulum)
    {
    	 TermModel term = termDAO.selectTerm(id_term);
    	 String tahun_term = term.getTahunAjaran();
    	 String jenis_term = Integer.toString(term.getTermType());
    	 String nama_term = tahun_term +"-"+jenis_term;
    	 
    	 KelasModel kelas = new KelasModel (null, id_matkul, nama_kelas, null, dosen, ruangan, null, null, id_term, kode_kurikulum,nama_term,  null);
    	   
    	 kelasDAO.createKelas(kelas);
    	   
    	  KelasModel kelasBaru= kelasDAO.selectKelasByNewest();
    	  int id_kelas = kelasBaru.getId();
    	  System.out.println(jam_masuk);
    	  System.out.println(jam_selesai);

    	  makeJadwal(id_kelas, hari, jam_masuk, jam_selesai); 
    	  return "kelas-success-add";
    }
      
    public void makeJadwal (int id_kelas,  List<String> hari,  List<String> jam_masuk,  List<String> jam_selesai ) {
    	  //asumsi: setiap input jadwal, pasti memasukkan hari, jam masuk, dan jam selesai
 	   List<String> jumlahHari = hari;
 	   List<String> jumlahJamMasuk = jam_masuk;
 	   List<String> jumlahJamSelesai = jam_selesai;
 	   
 	   int jumlahJadwal = jumlahHari.size();
 	   
 	   for (int i = 0; i < jumlahJadwal; i++) {
 		String hariNow = jumlahHari.get(i);
 		String jam_masukNow = jumlahJamMasuk.get(i);
	 		String jam_selesaiNow = jumlahJamSelesai.get(i);
 		
 		JadwalModel jadwal = new JadwalModel (null, id_kelas, hariNow, jam_masukNow, jam_selesaiNow);
 	 	kelasDAO.createJadwal(jadwal);
 	   }
 	   
    }

    
/*
    @RequestMapping(value = "/kelas/add", method = RequestMethod.POST)
    public void addSubmit (@ModelAttribute KelasModel kelas)
    {
    	//sementara pake kelasDAO krn blm ada dr api nya
    	List<MatkulModel> matkul = kelasDAO.selectMatkul();
    	
    	
    //	String nama_matkul = matkul.getNamaMatkul();
    //	kelas.setNama_matkul(nama_matkul);
        kelasDAO.createKelas(kelas);
    } 
*/
    
    @RequestMapping(value="/pilihKurikulum")
    public String pilihKurikulum(Model model) {
    	List<KurikulumModel> kurikulum = apiMapperImpl.allKurikulum();
    	model.addAttribute("kuri", kurikulum);
    	return "kelas-intro";
    }
    
    @RequestMapping(value="/submitPilihKurikulum")
    public String submitPilihKurikulum(Model model,@RequestParam(value = "kode_kurikulum", required = false) String kode_kurikulum) {
      	return "redirect:/kelas?kode_kurikulum="+kode_kurikulum;
    }
}
