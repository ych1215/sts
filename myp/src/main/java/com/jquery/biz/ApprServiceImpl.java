package com.jquery.biz;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jquery.dao.ApprMapper;

@Service
public class ApprServiceImpl {

   @Autowired
   ApprMapper apprMapper;
   
   
  public List<Map<String, Object>> selectApprList(Map<String, Object> map) throws Exception {
       return apprMapper.selectApprList(map);
   }
  
  public List<Map<String, Object>> selectReportList(Map<String, Object> map) throws Exception {
      return apprMapper.selectReportList(map);
  }
  
  public Map<String, Object> schApprUser(Map<String, Object> map) throws Exception {
      return apprMapper.schApprUser(map);
  }
  
  
  
}

