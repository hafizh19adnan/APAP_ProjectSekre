package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkStudentKuriModel {
	private String kurikulum;
	private String npm;
	private String angkatan;
	private String idUniv;
	private String idFakultas;
	private String idProdi;
}
