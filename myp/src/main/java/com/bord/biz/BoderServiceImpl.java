package com.bord.biz;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bord.dao.BorderMapper;
import com.login.dao.LoginMapper;

@Service
public class BoderServiceImpl {

	@Autowired
	BorderMapper borderMapper;

	public List<Map<String, Object>> selectBordList(Map<String, Object> map) throws Exception {
		return borderMapper.selectBordList(map);
	}

	public List<UserDTO> selectBordClobList(Map<String, Object> map) throws Exception {
		return borderMapper.selectBordClobList(map);
	}

	/**
	 * 섬머 보드 저장
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public int saveSummernoteBord(Map<String, Object> map) throws Exception {
		return borderMapper.saveSummernoteBord(map);
	}

	/**
	 * 섬머 보드 저장 clob
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public int saveSummernoteBordClob(UserDTO map) throws Exception {
		return borderMapper.saveSummernoteBordClob(map);
	}

	public String selectSeq(Map<String, Object> map) throws Exception {
		return borderMapper.selectSeq(map);
	}

	public List<Map<String, Object>> selectPgmBordList(Map<String, Object> map) throws Exception {
		return borderMapper.selectPgmBordList(map);
	}

}
