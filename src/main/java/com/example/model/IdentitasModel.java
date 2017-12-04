package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IdentitasModel {
	private String universitas;
	private String fakultas;
	private String jurusan;
	private String jenjang;
	private int angkatan;
}
