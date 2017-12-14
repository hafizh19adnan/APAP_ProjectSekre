package com.example.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KurikulumModel {
	private int id;
	private String kode_kurikulum;
	private String nama_kurikulum;
	private int jumlahSks;
	private int jumlahSksWajib;
	private int jumlahSksPilihan;
	private int	id_universitas;
	private int id_fakultas;
	private int id_prodi;
	private List<MatkulModel> matakuliah;
	//model menunggu API
}
