package com.bord.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BorderMapper {
	public int saveSummernoteBord(Map<String, Object> map);
	public List<Map<String, Object>> selectBordList(Map<String, Object> map);

}