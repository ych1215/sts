package com.test.biz;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.login.dao.LoginMapper;
import com.test.dao.TestMapper;

@Service
public class TestServiceImpl implements TestService {

   @Autowired
   TestMapper testMapper;

   @Override
   public List<Map<String, Object>> selectUserList(Map<String, Object> map) throws Exception {
	   
       return testMapper.selectUserList(map);
   }
   
   
   @Override
   public int insertUser(Map<String, Object> map) throws Exception {
	   
       return testMapper.insertUser(map);
   }
   
   
}

