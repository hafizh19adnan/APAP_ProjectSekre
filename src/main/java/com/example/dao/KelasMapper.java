package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.model.JadwalModel;
import com.example.model.KelasModel;
import com.example.model.MatkulModel;
import com.example.model.TermModel;

@Mapper
public interface KelasMapper {
	

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
    
    
    @Select("select * from kelas where id_term = #{id_term}")
    @Results(value = {
   		@Result(property="id", column="id"),	
    	@Result(property="jadwal_masuk", column="id",
    			javaType = List.class,
    			many=@Many(select="getJadwalMasuk"))
    })
	List<KelasModel> getAllKelasByIdTerm(String id_term);
    
    @Select("select * from term where tahun_ajaran = #{tahun_ajaran} and term_type = #{term_type}")
    @Results(value = {
			@Result(property="id", column="id"),
			@Result(property="tahunAjaran", column="tahun_ajaran"),
			@Result(property="tglIrsStart", column="tgl_irs_start"),
			@Result(property="tglIrsEnd", column="tgl_irs_end"),
			@Result(property="isiIrsStart", column="isi_irs_start"),
			@Result(property="isiIrsEnd", column="isi_irs_end"),
			@Result(property="termType", column="term_type")
    })
    TermModel getTermByTermType(String tahun_ajaran, String term_type);

	
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
	
	@Insert("INSERT INTO kelas (id, nama_kelas, id_matkul, dosen, ruangan, id_term, kode_kurikulum) VALUES (null, #{nama_kelas}, #{id_matkul}, #{dosen}, #{ruangan}, #{id_term}, #{kode_kurikulum})")
    void createKelas (KelasModel kelas);
	
	@Insert("INSERT INTO jadwal (id, id_kelas, hari, jam_masuk, jam_keluar) VALUES (null, #{id_kelas}, #{hari}, #{jam_masuk}, #{jam_keluar})")
    void createJadwal (JadwalModel jadwal);
	
	
	@Update("UPDATE kelas SET nama_kelas = #{nama_kelas}, id_matkul = #{id_matkul}, dosen = #{dosen}, ruangan = #{ruangan} WHERE id = #{id}")
	void updateKelas (KelasModel kelas);
	
	//method sementara, nunggu api dari kurikulum
	@Select("SELECT * FROM matkul")
	List<MatkulModel> selectMatkul();

}
