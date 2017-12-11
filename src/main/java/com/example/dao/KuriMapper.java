package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.model.LinkStudentKuriModel;


@Mapper
public interface KuriMapper {

	@Select("Select * from link_student_kuri where id_student= #{npm}")
	List<LinkStudentKuriModel> checkIfExist(@Param("npm") int npm);

	@Update("UPDATE link_student_kuri SET id_kuri=#{kurikulum}, angkatan=#{angkatan} WHERE id_student = #{npm}")
	void updateAssign(@Param("npm")int npm, @Param("kurikulum")String kurikulum, @Param("angkatan") String angkatan);

	@Insert("INSERT INTO link_student_kuri (id_student, id_kuri, angkatan) VALUES (#{npm},#{kurikulum}, #{angkatan})")
	void addAssign(@Param("npm")int npm, @Param("kurikulum")String kurikulum, @Param("angkatan") String angkatan);

	@Select("Select * from link_student_kuri")
	List<LinkStudentKuriModel> allStudentKuri();
	
	@Select("Select COUNT(id_student), id_kuri, angkatan from link_student_kuri GROUP BY angkatan")
	@Results(value = {
			@Result(property="kurikulum", column="id_kuri"),
    })
	List<LinkStudentKuriModel> AngkatanKuriList();
}
