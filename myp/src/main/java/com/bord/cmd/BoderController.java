package com.bord.cmd;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoderController {

	@Transactional(readOnly = true)
	@RequestMapping("bord")
	public ModelAndView selectListMembers(Map<String, Object> map) throws Exception {

		ModelAndView mav = new ModelAndView();

		mav.setViewName("summernoteBord");
		return mav;

	}


}
