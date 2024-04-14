package com.bord.cmd;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bord.biz.BoderServiceImpl;
import com.login.biz.LoginServiceImpl;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class BoderController {
	
	@Resource
	BoderServiceImpl boderServiceImpl;
	
	@Transactional(readOnly = true)
	@RequestMapping("bord")
	public ModelAndView selectListMembers(HttpServletRequest request) throws Exception {

		ModelAndView mav = new ModelAndView();
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<Map<String, Object>> allMembers = boderServiceImpl.selectBordList(map);
		
		mav.addObject("Alllist", allMembers.get(0).get("BORD"));
		
		System.out.println("BORD2::" + allMembers.toString());
		
		System.out.println("BORD::" + allMembers.get(0).get("BORD"));
		
		mav.setViewName("summernoteBord");
		return mav;

	}
	
	
	/**
	 * 섬머 보드 저장
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Transactional
	@RequestMapping("saveSummernoteBord")
	public ModelAndView saveSummernoteBord(HttpServletRequest request) throws Exception {

		ModelAndView mav = new ModelAndView();
		
		System.out.println(request.getParameter("BORD"));
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("BORD", request.getParameter("BORD"));

		boderServiceImpl.saveSummernoteBord(map);

		mav.setViewName("summernoteBord");
		return mav;

	}


}
