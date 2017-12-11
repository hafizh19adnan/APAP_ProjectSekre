package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JadwalModel {
	private Integer id;
	private int id_kelas;
	private String hari;
	private String jam_masuk;
	private String jam_keluar;

}
