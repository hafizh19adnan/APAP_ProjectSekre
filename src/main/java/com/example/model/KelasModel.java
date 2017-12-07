package com.example.model;


import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KelasModel
{
	private int id;
	private int id_matkul;
	private String nama_kelas;
	private String nama_matkul;
    private String dosen;
    private String ruangan;
	private List<JadwalModel> jadwal_masuk;
	private String hari;
	private String jam;
    private int id_term;


}