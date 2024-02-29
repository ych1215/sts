package com.login.biz;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.login.dao.LoginMapper;

@Service
public class LoginServiceImpl {

   @Autowired
   LoginMapper loginMapper;

   public List<Map<String, Object>> selectUserList(Map<String, Object> map) throws Exception {
	   
       return loginMapper.selectUserList(map);
   }
   
   public int insertUser(Map<String, Object> map) throws Exception {
	   
       return loginMapper.insertUser(map);
   }
   
   
}

