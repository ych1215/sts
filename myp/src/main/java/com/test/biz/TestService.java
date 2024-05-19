package com.test.biz;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public interface  TestService {


	public List<Map<String, Object>> selectUserList(Map<String, Object> map) throws Exception;
	
	public int insertUser(Map<String, Object> map) throws Exception;
	
	public int saveClob(Map<String, Object> map) throws Exception;
	
	public Map<String, Object> selectClob(Map<String, Object> map) throws Exception;
	
	
}