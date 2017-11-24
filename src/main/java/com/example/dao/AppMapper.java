package com.example.dao;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
//
//
//import org.apache.ibatis.annotations.Delete;
//import org.apache.ibatis.annotations.Insert;
//import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
//import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Update;

import com.example.model.TermModel;
import com.example.model.UserModel;
import com.example.model.LinkStudentKuriModel;
import com.example.model.MatkulModel;
import com.example.model.JadwalModel;
import com.example.model.KelasModel;


@Mapper
public interface AppMapper
{

    @Select("select * from kelas")
    @Results(value = {
   		@Result(property="id", column="id"),	
    	@Result(property="jadwal_masuk", column="id",
    			javaType = List.class,
    			many=@Many(select="getJadwalMasuk"))
    })
	List<KelasModel> getAllKelas();

    @Select("select * from kelas where id = #{id}")
    @Results(value = {
   		@Result(property="id", column="id"),
    	@Result(property="jadwal_masuk", column="id",
    			javaType = List.class,
    			many=@Many(select="getJadwalMasuk"))
    })
	KelasModel getKelasById(String id);

	
	   @Select("select j.id, id_kelas, hari, jam_masuk, jam_keluar  " + 
	    		"from kelas k join jadwal j " + 
	    		"on k.id = j.id_kelas " + 
	    		"where k.id = #{id}")
	List<JadwalModel> getJadwalMasuk(@Param("id") String id);

	
	 @Select("select * from term where term_type = #{type} ")  
	List<TermModel> getTermByType(String type);

	
	@Select("SELECT * FROM kelas where id = #{id}")
	KelasModel selectKelas(String id);
	
	@Delete("DELETE FROM kelas WHERE id = #{id}") 
	void deleteKelas(String id);
	
	@Insert("INSERT INTO kelas (id, nama_kelas, id_matkul, dosen, ruangan) VALUES (#{id}, #{nama_kelas}, #{id_matkul}, #{dosen}, #{ruangan})")
    void createKelas (KelasModel kelas);
	
	@Update("UPDATE kelas SET nama_kelas = #{nama_kelas}, id_matkul = #{id_matkul}, dosen = #{dosen}, ruangan = #{ruangan} WHERE id = #{id}")
	void updateKelas (KelasModel kelas);
	
//	method sementara, nunggu api dari kurikulum
	@Select("SELECT * FROM matkul")
	MatkulModel selectMatkul();

}

