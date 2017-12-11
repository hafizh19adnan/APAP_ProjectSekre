package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MahasiswaModel {
	private int npm;
	private String username;
	private String namaLengkap;
	private long ipk;
	private String jenjang;
	private String tahunMasuk;
	private String kodeKurikulum;
	private String idUniv;
	private String idFakultas;
	private String idProdi;
  
}
