package com.pgmBord.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PgmBorderMapper {

	public List<Map<String, Object>> selectPgmBordList(Map<String, Object> map);
	public Map<String, Object> selectPgmBordDtl(Map<String, Object> map);
	public int savePgmBordDtlSave(Map<String, Object> map);
	public int savePgmBordDtlUpdate(Map<String, Object> map);
}