package com.example.model;


import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KelasModel
{
	private Integer id;
	private int id_matkul;
	private String nama_kelas;
	public String nama_matkul;
    private String dosen;
    private String ruangan;
	private String hari;
	private String jam;
    private int id_term;
    private String kode_kurikulum;
    private String nama_term;
    private List<JadwalModel> jadwal_masuk;
    
//  @JsonIgnore
//    public String getNama_Matkul()
//    {
//    	return nama_matkul;
//    }
//    
    @JsonIgnore
    public String getHari()
    {
    	return hari;
    }
    
    @JsonIgnore
    public String getJam()
    {
    	return jam;
    }

}