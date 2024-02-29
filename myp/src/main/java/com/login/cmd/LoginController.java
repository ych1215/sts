package com.login.cmd;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.login.biz.LoginServiceImpl;

import jakarta.annotation.Resource;

@Controller
public class LoginController {

	@Resource
	LoginServiceImpl loginService;

	@RequestMapping("/")
	public String hello() {
		return "main";
	}

	@Transactional(readOnly = true)
	@RequestMapping("login")
	public ModelAndView selectListMembers(Map<String, Object> map) throws Exception {

		ModelAndView mav = new ModelAndView();

		map.put("aa", "cc");
		List<Map<String, Object>> allMembers = loginService.selectUserList(map);

		System.out.println(allMembers.toString());

		mav.addObject("Alllist", allMembers);
		mav.setViewName("login");
		return mav;

	}

	@Transactional
	@RequestMapping("bak")
	public ModelAndView insertBak(Map<String, Object> map) throws Exception {

		ModelAndView mav = new ModelAndView();

		map.put("aa", "1");
		loginService.insertUser(map);

		map.put("aa", "0");
		loginService.insertUser(map);

		mav.addObject("Alllist", "");
		mav.setViewName("login");
		return mav;

	}

}
