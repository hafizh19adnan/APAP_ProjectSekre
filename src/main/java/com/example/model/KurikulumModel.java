package com.example.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KurikulumModel {
	private int idKurikulum;
	private String kodeKurikulum;
	private String namaKurikulum;
	private int jumlahSKSWajib;
	private int jumlahSKSPilihan;
	private int	idUniversitas;
	private int idFakultas;
	private int idProdi;
	private List<MatkulModel> listMataKuliah;
	//model menunggu API
}
