package com.trTest.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TrTestMapper {

	public int insertUser(Map<String, Object> map);
	
	public int insertUser2(Map<String, Object> map);
	
	public int insertUser3(Map<String, Object> map);

}