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

import com.example.model.*;

@Mapper
public interface TermMapper
{
    @Select("select id, tahun_ajaran, tgl_irs_start, tgl_irs_end, isi_irs_start, isi_irs_end, term_type from term where id = #{id}")
    @Results(value = {
    		@Result(property="id", column="id"),
			@Result(property="tahunAjaran", column="tahun_ajaran"),
			@Result(property="tglIrsStart", column="tgl_irs_start"),
			@Result(property="tglIrsEnd", column="tgl_irs_end"),
			@Result(property="isiIrsStart", column="isi_irs_start"),
			@Result(property="isiIrsEnd", column="isi_irs_end"),
			@Result(property="termType", column="term_type")
    })
    TermModel selectTerm (@Param("id") int id);

    @Select("select id, tahun_ajaran, tgl_irs_start, tgl_irs_end, isi_irs_start, isi_irs_end, term_type from term")
    @Results(value = {
			@Result(property="id", column="id"),
			@Result(property="tahunAjaran", column="tahun_ajaran"),
			@Result(property="tglIrsStart", column="tgl_irs_start"),
			@Result(property="tglIrsEnd", column="tgl_irs_end"),
			@Result(property="isiIrsStart", column="isi_irs_start"),
			@Result(property="isiIrsEnd", column="isi_irs_end"),
			@Result(property="termType", column="term_type")
    })
    List<TermModel> selectAllTerms();

    @Insert("INSERT INTO term (id, tahun_ajaran, tgl_irs_start, tgl_irs_end, isi_irs_start, isi_irs_end, term_type) VALUES (null, #{tahunAjaran}, #{tglIrsStart}, #{tglIrsEnd}, #{isiIrsStart}, #{isiIrsEnd}, #{termType})")
    void addTerm (TermModel term);
    
    @Delete("delete from term where id= #{id}")
    void deleteTerm (@Param("id") int id);

    @Update("update term set tahun_ajaran = #{tahunAjaran}, tgl_irs_start = #{tglIrsStart}, tgl_irs_end = #{tglIrsEnd}, isi_irs_start = #{isiIrsStart}, isi_irs_end = #{isiIrsEnd}, term_type = #{termType} where id = ${id}")
    void updateTerm (TermModel term);

    
}
