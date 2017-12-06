package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.JadwalModel;
import com.example.model.KelasModel;
import com.example.model.MatkulModel;
import com.example.model.TermModel;
import com.example.service.KelasService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class KelasController {
	
	@Autowired
    KelasService kelasDAO;
	
	@RequestMapping("/pilihKurikulum")
	public String chooseKurikulum(Model model) {
		return "kelas-intro";
	}
	
	@RequestMapping("/kelas")
	public String view(Model model) {
		
		List<KelasModel> semuakelas = kelasDAO.getAllKelas();
	// ini buat kalo udh ada apinya	
	//	List<MatkulModel> semuamatkul = kelasDAO.getAllMatkul();
		
		//yg ini sementara, dummy dibuat
		List<MatkulModel> semuamatkul = kelasDAO.selectMatkul();
		String nama_matkul = "";
		
		for (int i = 0; i < semuakelas.size(); i++) {
			KelasModel kelasNow = semuakelas.get(i);			
			int idMatkul = kelasNow.getId_matkul();
			for (int j = 0; j < semuamatkul.size(); j++) {
				if (idMatkul == semuamatkul.get(j).getIdMatkul()) {
					nama_matkul = semuamatkul.get(j).getNamaMatkul();
					semuakelas.get(i).setNama_matkul(nama_matkul);
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
					stringBuilderHari.append("\n");
					stringBuilderJam.append("\n");
					
				}
			}
			String hari = stringBuilderHari.toString();
			String jam = stringBuilderJam.toString();
			semuakelas.get(i).setHari(hari);
			semuakelas.get(i).setJam(jam);
		}
		
		model.addAttribute("semuakelas", semuakelas);
		return "kelas";
	}
	
	
	
	  @RequestMapping("/kelas/detail/{id}")
	    public String viewPath (Model model,
	            @PathVariable(value = "id") String id)
	    {
	        KelasModel kelas = kelasDAO.getKelasById(id);

	        if (kelas != null) {
	        	//yg ini sementara, dummy dibuat
	    		List<MatkulModel> semuamatkul = kelasDAO.selectMatkul();
	    		String nama_matkul = "";
	    		int idMatkul = kelas.getId_matkul();
				for (int j = 0; j < semuamatkul.size(); j++) {
					if (idMatkul == semuamatkul.get(j).getIdMatkul()) {
						nama_matkul = semuamatkul.get(j).getNamaMatkul();
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
     
    }
    
    

    @RequestMapping("/kelas/update/{id}")
    public String updateKelas (Model model, @PathVariable(value = "id") String id)
    {
    	  KelasModel kelas = kelasDAO.selectKelas(id);
    	  
          if (kelas != null) {
        	  model.addAttribute("kelas",kelas);
        	  return "kelas-update";
          } else {
              return "kelas-not-found";
          }
    }
    
    @RequestMapping(value = "/kelas/update", method = RequestMethod.POST)
    public void updateSubmit (@ModelAttribute KelasModel kelas) {
         kelasDAO.updateKelas(kelas);     
    }
    
    
       @RequestMapping("/kelas/add/submit")
    public String addSubmit (
            @RequestParam(value = "nama_kelas", required = false) String nama_kelas,
            @RequestParam(value = "nama_matkul", required = false) String nama_matkul,
            @RequestParam(value = "dosen", required = false) String dosen,
            @RequestParam(value = "hari", required = false) String hari,
            @RequestParam(value = "ruangan", required = false) String ruangan,
            @RequestParam(value = "jam_masuk", required = false) String jam_masuk,
            @RequestParam(value = "jam_selesai", required = false) String jam_selesai)
    {
     	//search id_matkul
    	//bikin id_kelas
   	   //bikin id_jadwal
     	 
    	
    	   
  //      KelasModel kelas = new KelasModel (id_kelas, id_matkul, nama_kelas, null, dosen, ruangan, null, null, null);
  //      JadwalModel jadwal = new JadwalModel (id_jadwal, id_kelas, hari, jam_masuk, jam_selesai);
    	//kelasDAO.createKelas
    	//kelasDAO.createJadwal

        return "kelas-success-add";
    }
      


    @RequestMapping(value = "/kelas/add", method = RequestMethod.POST)
    public void addSubmit (@ModelAttribute KelasModel kelas)
    {
    	//sementara pake kelasDAO krn blm ada dr api nya
    	List<MatkulModel> matkul = kelasDAO.selectMatkul();
    	
    	
    //	String nama_matkul = matkul.getNamaMatkul();
    //	kelas.setNama_matkul(nama_matkul);
        kelasDAO.createKelas(kelas);
    }
    
    
    
    

}
