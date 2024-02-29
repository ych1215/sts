package com.test.cmd;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.test.biz.TestService;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class TestController {

	@Resource
	TestService testService;

	@RequestMapping("/a")
	public String hello() {
		return "main";
	}

	@Transactional(readOnly = true)
	@RequestMapping(value = "test")
	public ModelAndView selectListMembers(Map<String, Object> map) throws Exception {

		ModelAndView mav = new ModelAndView();

		map.put("aa", "cc");
		List<Map<String, Object>> allMembers = testService.selectUserList(map);

		System.out.println(allMembers.toString());

		mav.addObject("Alllist", allMembers);
		mav.setViewName("login");
		return mav;

	}
	
	@Transactional(readOnly = true)
	@RequestMapping(value = "test2")
	public ModelAndView selectListTest(Map<String, Object> map) throws Exception {

		ModelAndView mav = new ModelAndView();

		map.put("aa", "cc");
		List<Map<String, Object>> allMembers = testService.selectUserList(map);

		System.out.println(allMembers.toString());

		mav.addObject("Alllist", allMembers);
		mav.setViewName("test");
		return mav;

	}

	@Transactional
	@RequestMapping(value = "err")
	public ModelAndView insertBak(Map<String, Object> map) throws Exception {

		ModelAndView mav = new ModelAndView();

		map.put("aa", "1");
		testService.insertUser(map);

		map.put("aa", "0");
		testService.insertUser(map);

		mav.addObject("Alllist", "");
		mav.setViewName("login");
		return mav;

	}
	
	
	@RequestMapping("/formSubmit")
	public ModelAndView formSubmitTest(HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		
		System.out.println("서브밋::"+request.getParameter("USER_ID"));
		System.out.println("서브밋맵::"+request.getParameterMap().toString());

		mav.addObject("Alllist", "{\"Alllist\":\"test\"}");
		
		//mav.setViewName("proxy");
		mav.setViewName("proxy2");
		
		return mav;
	}


}
