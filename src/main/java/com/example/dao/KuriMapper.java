package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.model.KurikulumModel;
import com.example.model.LinkStudentKuriModel;
import com.example.model.MahasiswaModel;


@Mapper
public interface KuriMapper {

	@Select("Select * from link_student_kuri where id_student= #{npm}")
	List<LinkStudentKuriModel> checkIfExist(@Param("npm") int npm);

	@Update("UPDATE link_student_kuri SET id_kuri=#{kurikulum}, angkatan=#{maha.tahunMasuk}, id_univ=#{maha.idUniv},id_fakultas=#{maha.idFakultas},id_prodi=#{maha.idProdi} WHERE id_student = #{maha.npm}")
	void updateAssign(@Param("maha") MahasiswaModel maha, @Param("kurikulum")String kurikulum);

	@Insert("INSERT INTO link_student_kuri (id_student, id_kuri, angkatan, id_univ, id_fakultas, id_prodi) VALUES (#{maha.npm},#{kurikulum}, #{maha.tahunMasuk}, #{maha.idUniv}, #{maha.idFakultas}, #{maha.idProdi})")
	void addAssign(@Param("maha") MahasiswaModel maha, @Param("kurikulum")String kurikulum);

	@Select("Select * from link_student_kuri")
	List<LinkStudentKuriModel> allStudentKuri();
	
	@Select("Select id_kuri, angkatan, id_univ, id_fakultas, id_prodi from link_student_kuri")
	@Results(value = {
			@Result(property="kurikulum", column="id_kuri"),
			@Result(property="idUniv", column="id_univ"),
			@Result(property="idFakultas", column="id_fakultas"),
			@Result(property="idProdi", column="id_prodi"),
    })
	List<LinkStudentKuriModel> AngkatanKuriList();
}
