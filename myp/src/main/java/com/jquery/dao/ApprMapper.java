package com.jquery.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ApprMapper {
	
	public List<Map<String, Object>> selectApprList(Map<String, Object> map);
	public List<Map<String, Object>> selectReportList(Map<String, Object> map);
	public Map<String, Object> schApprUser(Map<String, Object> map);
	

}