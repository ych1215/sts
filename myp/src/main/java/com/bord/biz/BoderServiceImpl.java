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

   /**
    * 섬머 보드 저장 
    * @param map
    * @return
    * @throws Exception
    */
   public int saveSummernoteBord(Map<String, Object> map) throws Exception {
       return borderMapper.saveSummernoteBord(map);
   }
   
}

