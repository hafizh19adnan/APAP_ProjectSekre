package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AngkatanModel {
	private String tahun;
	private String id_prodi;
	private String nama_angkatan_prodi;
}
