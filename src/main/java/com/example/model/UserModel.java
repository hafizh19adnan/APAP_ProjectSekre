package com.example.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserModel
{
	private int id;
    private String nomor_kk;
    private String is_tidak_berlaku;
    private String alamat;
    private String rt;
    private String rw;
    private String kelurahan;
    private String kecamatan;
    private String kota;
    private String id_kelurahan;
    private List<KelasModel> anggota_keluarga;
    
   
        
    
}
