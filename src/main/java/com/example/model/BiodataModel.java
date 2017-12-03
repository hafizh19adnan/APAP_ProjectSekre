package com.example.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BiodataModel {
	private String jenis_kelamin;
	private String no_HP;
	private String tempat_lahir;
	private String tanggal_lahir;
	private String alamat;
}
