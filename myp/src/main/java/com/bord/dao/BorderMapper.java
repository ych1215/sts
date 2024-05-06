package com.bord.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BorderMapper {

	public List<Map<String, Object>> selectBordList(Map<String, Object> map);

	public int saveSummernoteBord(Map<String, Object> map);

	public int saveSummernoteBordClob(Map<String, Object> map);

	public List<Map<String, Object>> selectBordClobList(Map<String, Object> map);

	public String selectSeq(Map<String, Object> map);

	public List<Map<String, Object>> selectPgmBordList(Map<String, Object> map);

}