package com.bord.cmd;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.bord.biz.BoderServiceImpl;
import com.bord.biz.UserDTO;
import com.login.biz.LoginServiceImpl;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class BoderController {

	@Resource
	BoderServiceImpl boderServiceImpl;

	/**
	 * 썸머노트 조회
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
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
	 * 썸머노트 조회 clob
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@Transactional(readOnly = true)
	@RequestMapping("bord_clob")
	public ModelAndView selectClobListMembers(HttpServletRequest request) throws Exception {

		ModelAndView mav = new ModelAndView();

		Map<String, Object> map = new HashMap<String, Object>();

		List<UserDTO> allMembers = boderServiceImpl.selectBordClobList(map);

		if (allMembers == null || allMembers.size() == 0 || allMembers.get(0) == null) {
			System.out.println("BORD::" + "empt");
			mav.addObject("Alllist", "empt");

		} else {
			mav.addObject("Alllist", allMembers.get(0).getBord());
			System.out.println("BORD::" + allMembers.get(0).getBord());
			System.out.println("SEQ::" + allMembers.get(0).getBord());
		}
		
		
		//String url = "https://jsonplaceholder.typicode.com/posts/1";
		String url = "http://localhost:8089/users3/aaa/zzzz?qqq=23232";

		RestTemplate restTemplate = new RestTemplate();
		String json = restTemplate.getForObject(url, String.class);
		System.out.println("json::" +  json);

		mav.setViewName("summernoteBordClob");
		return mav;

	}

	/**
	 * 섬머 보드 저장
	 * 
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

	/**
	 * 섬머 보드 저장Clob
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Transactional
	@RequestMapping("saveSummernoteBordClob")
	// public ModelAndView saveSummernoteBordClob(HttpServletRequest request) throws
	// Exception {
	public String saveSummernoteBordClob(HttpServletRequest request) throws Exception {

		ModelAndView mav = new ModelAndView();

		System.out.println(request.getParameter("BORD"));

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("BORD", request.getParameter("BORD"));
		
		UserDTO userDTO = new UserDTO();
		
		userDTO.setBord(request.getParameter("BORD"));

		boderServiceImpl.saveSummernoteBordClob(userDTO);
		

		// mav.setViewName("summernoteBordClob");
		// return mav;
		return "redirect:/bord_clob";

	}

	/**
	 * 프로그램 게시판
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@Transactional(readOnly = true)
	@RequestMapping("pgmBord")
	public ModelAndView selectPgmBordList(HttpServletRequest request) throws Exception {

		ModelAndView mav = new ModelAndView();

		Map<String, Object> map = new HashMap<String, Object>();

		List<Map<String, Object>> pmgBordList = boderServiceImpl.selectPgmBordList(map);

		mav.addObject("pmgBordList", pmgBordList);

		mav.setViewName("pgmBord");
		return mav;

	}
	
	
	/**
	 * json 테스트 
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@Transactional(readOnly = true)
	@RequestMapping("json")
	public ModelAndView selectJsonPage(HttpServletRequest request) throws Exception {

		ModelAndView mav = new ModelAndView();

		mav.setViewName("/jquery/jsontest");
		return mav;

	}

}
