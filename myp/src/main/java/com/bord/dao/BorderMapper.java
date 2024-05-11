package com.bord.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.bord.biz.UserDTO;

@Mapper
public interface BorderMapper {

	public List<Map<String, Object>> selectBordList(Map<String, Object> map);

	public int saveSummernoteBord(Map<String, Object> map);

	public int saveSummernoteBordClob(UserDTO map);

	public List<UserDTO> selectBordClobList(Map<String, Object> map);

	public String selectSeq(Map<String, Object> map);

	public List<Map<String, Object>> selectPgmBordList(Map<String, Object> map);

}