package com.vue3.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmpMapper {

	public List<Map<String, Object>> selectUserList(Map<String, Object> map);
	
	public int insertEmp(Map<String, Object> map);
	

}