package com.pgmBord.cmd;

import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pgmBord.biz.PgmBoderServiceImpl;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class PgmBoderController {

	@Resource
	PgmBoderServiceImpl pgmBoderServiceImpl;

	/**
	 * 프로그램 보드 목록 조회
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@Transactional(readOnly = true)
	@RequestMapping("pgm_bord")
	public ModelAndView selectPgmBordList (
											  HttpServletRequest request 
											, HttpServletResponse response
											, HttpSession session
											, @RequestParam Map<String, Object> params
											, @RequestHeader("Host") String host
											/*
											  @RequestBody List<Map<String, Object>> param  json 리스트 받기
											  @RequestBody Map<String, Object> param   json 단건 받기
											 */
											
			                              ) throws Exception {

		ModelAndView mav = new ModelAndView();

		//Map<String, Object> map = new HashMap<String, Object>();
		
		System.out.println("파람::" + params.toString());

		List<Map<String, Object>> pgmBordList = pgmBoderServiceImpl.selectPgmBordList(params);

		mav.addObject("pgmBordList", pgmBordList);
		
		// 클라이언트에서 보낸 해더 읽기 
		 StringBuilder sb = new StringBuilder();
	        Enumeration<String> headerNames = request.getHeaderNames();
	        while (headerNames.hasMoreElements()) {
	            String name = headerNames.nextElement();
	            String value = request.getHeader(name);
	            sb.append(name + ": " + value + "\n");
	        }
	        System.out.println("해더::" + sb.toString());
	        
		
		 response.addHeader("ych-serverheader", "Hello from Spring!"); // 클라이언트로 해더 보내기.

		mav.setViewName("pgmBoder/pgmBordList");
		return mav;

	}
	
	/**
	 * 프로그램 보드 상세 조회
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@Transactional(readOnly = true)
	@RequestMapping("pgm_bord_dtl")
	public ModelAndView selectPgmBordDtl (@RequestParam Map<String, Object> params) throws Exception {

		ModelAndView mav = new ModelAndView();
		
		System.out.println("파람::" + params.toString());

		Map<String, Object> pgmBordDtl = pgmBoderServiceImpl.selectPgmBordDtl(params);

		mav.addObject("pgmBordDtl", pgmBordDtl);
		
		mav.setViewName("pgmBoder/pgmBordDtl");
		return mav;
	}
	
	
	/**
	 *  프로그램 보드 신규 페이지 호출
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Transactional
	@RequestMapping("pgm_bord_new")
	public ModelAndView newPgmBordDtl(@RequestParam Map<String, Object> params) throws Exception {

		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("pgmBoder/pgmBordDtlNew");
		return mav;
	}
	
	/**
	 *  프로그램 보드 신규 저장
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Transactional
	@RequestMapping("pgm_bord_dtl_save")
	public String savePgmBordDtlSave(@RequestParam Map<String, Object> params) throws Exception {
		System.out.println("내용::"+ params.toString());
		
		pgmBoderServiceImpl.savePgmBordDtlSave(params);
		
		return "redirect:pgm_bord";

	}
	
	/**
	 *  프로그램 보드 수정
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@Transactional
	@RequestMapping("pgm_bord_dtl_update")
	public String savePgmBordDtlUpdate(@RequestParam Map<String, Object> params) throws Exception {
		
		System.out.println("내용::"+ params.toString());
		
		pgmBoderServiceImpl.savePgmBordDtlUpdate(params);
		
		return "redirect:pgm_bord";

	}

}
