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
	private String email_pribadi;
	private String email_univ;
	private BiodataModel biodata;
	private IdentitasModel Identitas;
	private BiodataOrtuModel Biodata_Ortu;
  
}
