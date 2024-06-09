package com.vue3.biz;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dao.TestMapper;
import com.vue3.dao.EmpMapper;

@Service
public class EmpServiceImpl  {

   @Autowired
   EmpMapper empMapper;

   public List<Map<String, Object>> selectUserList(Map<String, Object> map) throws Exception {
	   
       return empMapper.selectUserList(map);
   }
   
   
   
   public Map<String, Object> selectEmpSchDtl(Map<String, Object> map) throws Exception {
	   
       return empMapper.selectEmpSchDtl(map);
   }
   
   
 public int insertEmp(Map<String, Object> map) throws Exception {
	   
       return empMapper.insertEmp(map);
   }
   
   
   
   
}

