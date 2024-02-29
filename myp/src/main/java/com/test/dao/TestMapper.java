package com.test.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestMapper {

	public List<Map<String, Object>> selectUserList(Map<String, Object> map);

	public int insertUser(Map<String, Object> map);

}