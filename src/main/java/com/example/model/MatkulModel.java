package com.example.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatkulModel
{
	private int id;
	private String kode_matkul;
	private String nama_matkul;
    private int jumlah_sks;
    private String deskripsi;
//    private List<MatkulModel> prasyarat;
    private String term;
	private int is_wajib;
	private String id_universitas;
	private String id_fakultas;
	private String id_prodi;
}