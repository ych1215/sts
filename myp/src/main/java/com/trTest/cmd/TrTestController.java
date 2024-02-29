package com.trTest.cmd;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.trTest.biz.TrTestServiceImpl;

import jakarta.annotation.Resource;

@Controller
public class TrTestController {

	@Resource
	TrTestServiceImpl trTestService;
	
	
	@RequestMapping("view2")
	public ModelAndView selectListMembers(Map<String, Object> map) throws Exception {

		ModelAndView mav = new ModelAndView();
		mav.addObject("Alllist", "11");
		mav.setViewName("main");
		return mav;
	}
	
	@Transactional
	@RequestMapping("tr")
	public String  insertBak(Map<String, Object> map) throws Exception {

		System.out.println("111111111111111");
		ModelAndView mav = new ModelAndView("view2");

		map.put("aa", "1");
		trTestService.insertUser(map);

		map.put("aa", "2");
		trTestService.insertUser2(map); // 10건씩 끝어서 commit
		
		map.put("aa", "3");
		trTestService.insertUser3(map); // 새로운 트랜잭션 만들기
		
		//int a = 10/0; // 부모 트랜만 롤백 된다.

		mav.addObject("Alllist", "123");
		
		//mav.setViewName("login");
		//return mav; // 새로고치하면 또 inset되므로 리다이렉트 시킨다. , 브라우저 주소에  view2로  나와서 아무것도 안나오게 하려고 밑에 처럼 한다. 
		
		//return  "redirect:view2";
		return  "redirect:/";  // login 에 있는 컨트롤러의 / 호출 한다.
	}

}
