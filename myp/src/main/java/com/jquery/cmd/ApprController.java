package com.jquery.cmd;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jquery.biz.ApprServiceImpl;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class ApprController {

	@Resource
	ApprServiceImpl apprServiceImpl;

	@Transactional(readOnly = true)
	@RequestMapping("appr")
	public ModelAndView selectApprList(HttpServletRequest request, HttpSession session,
			@RequestParam Map<String, String> params) throws Exception {

		ModelAndView mav = new ModelAndView();

		Map<String, Object> map = new HashMap<String, Object>();

		List<Map<String, Object>> apprList = apprServiceImpl.selectApprList(map);

		mav.addObject("apprList", apprList);

		mav.setViewName("jquery/appr");

		return mav;

	}

	/**
	 * 아이프레임 리포트1 호출
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@Transactional(readOnly = true)
	@RequestMapping("report1")
	public ModelAndView salJsp(HttpServletRequest request, HttpSession session,
			@RequestParam Map<String, String> params) throws Exception {

		ModelAndView mav = new ModelAndView();

		Map<String, Object> map = new HashMap<String, Object>();

		List<Map<String, Object>> reprot1List = apprServiceImpl.selectReportList(map);

		mav.addObject("reprot1List", reprot1List);

		mav.setViewName("jquery/report1");

		return mav;

	}

	/**
	 * 승인자 검색
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@Transactional(readOnly = true)
	@ResponseBody
	@RequestMapping("schApprUser")
	public Map<String, Object> schApprUser(HttpServletRequest request, HttpSession session,
			@RequestBody Map<String, Object> params) throws Exception {

		System.out.println("==>" + params);

		Map<String, Object> schApprUser = apprServiceImpl.schApprUser(params);

		//Map<String, Object> renMap = new HashMap<String, Object>();
		//renMap.put("USER_NAME", schApprUser.get("USER_NAME"));
		
		return schApprUser; // sql값을 바로 전달해도 됨.

	}

}
