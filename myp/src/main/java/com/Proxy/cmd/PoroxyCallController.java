package com.Proxy.cmd;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class PoroxyCallController {

	@RequestMapping("/proxy_jsp")
	public String hello() {
		
		System.out.println("==========");
		
		return "proxy";
	}
	
	// 포워드 테스트 (  request,  response 객체를 그대로 전달한다.)
	@RequestMapping("forward_test")
	public String hello2( HttpServletRequest request, HttpServletResponse response  ) {
		
		System.out.println("=========222=");
		
		
		// forward 2가지 방법 
		// 아래 처럼@RequestMapping 의 주소를 써도 된다 , public String hello2( HttpServletRequest request, HttpServletResponse response  ) {
		// return "forward:/proxy_jsp";
		
		/* void 로 수정해야함  ,   public void hello2( HttpServletRequest request, HttpServletResponse response  ) {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/proxy.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		 return "forward:/proxy_jsp";
	}
	
	// 리다이렉트 test (  request,  response 객체가 새로 만들어진다)
	@RequestMapping("redirect_test")
	public String hello3( HttpServletRequest request, HttpServletResponse response  ) {
		
		System.out.println("=========333=");
		
		 return "redirect:/proxy_jsp";
	}
     // TEST 이거 보이냐??

}
