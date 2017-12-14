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
	private String nik;
    private String username;
    private int id_univ;
    private int id_fakultas;
    private String nama_univ;
    private String nama_fakultas;
    
}
