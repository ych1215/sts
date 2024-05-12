package com.pgmBord.biz;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bord.biz.UserDTO;
import com.pgmBord.dao.PgmBorderMapper;

@Service
public class PgmBoderServiceImpl {

	@Autowired
	PgmBorderMapper pgmBorderMapper;

	public List<Map<String, Object>> selectPgmBordList(Map<String, Object> map) throws Exception {
		return pgmBorderMapper.selectPgmBordList(map);
	}
	
	public Map<String, Object> selectPgmBordDtl(Map<String, Object> map) throws Exception {
		return pgmBorderMapper.selectPgmBordDtl(map);
	}
	
	public int savePgmBordDtlSave(Map<String, Object> map) throws Exception {
		return pgmBorderMapper.savePgmBordDtlSave(map);
	}
	public int savePgmBordDtlUpdate(Map<String, Object> map) throws Exception {
		return pgmBorderMapper.savePgmBordDtlUpdate(map);
	}
	

}
