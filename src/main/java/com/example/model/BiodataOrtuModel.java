package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BiodataOrtuModel {
	private String nama_ayah;
	private String nama_ibu;
	private String no_hp_ayah;
	private String no_hp_ibu;
	private String alamat_ortu;

}
