package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkStudentKuriModel {
	private int id;
    private String id_kecamatan;
    private String kode_kelurahan;
    private String nama_kelurahan;
    private String kode_pos;

}
