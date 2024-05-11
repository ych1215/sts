package com.test.cmd;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.bord.biz.UserDTO;

import jakarta.servlet.http.HttpServletRequest;


//@RestController  이렇게 하면 함수에 @ResponseBody 이거 필요 없음,  모든 함수가 레스트 api가 아닐때  @ResponseBody 붙여서 json형식으로 리턴 한다.
@Controller
public class TestRestController2 {

    
	/**
	 * 레스트 api 호출 , 
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@Transactional(readOnly = true)
	@RequestMapping("restapi")
	 @ResponseBody
	//public String selectClobListMembers(HttpServletRequest request,  @RequestBody Map<String, Object> param) throws Exception {  // josn 단건  받기 
	 public String selectClobListMembers(HttpServletRequest request,  @RequestBody List<Map<String, Object>> param) throws Exception { // josn 리스트로 받기 
		
		 //System.out.println("nick::" + param.get("nick")); // 파라미터 json 받기
		System.out.println("nick::" + param.get(0).get("nick")); // 파라미터 json 받기
		 
		
	    String url = "http://localhost:8089/users3/aaa/zzzz?qqq=한글~!!@#";
	    // String url = "https://jsonplaceholder.typicode.com/posts";

        // Create HttpHeaders object
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON); // Set Content-Type header
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON)); // Set Accept header
        headers.set("head1", "111"); // Set custom header

        HttpEntity<String> requestEntity = new HttpEntity<>(null, headers); // Passing null as request body

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
        
      //  ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET , requestEntity, String.class);
        
        /*  HttpMethod.POST 파라미터에 따라서 받는곳에서 변경.
          @RequestMapping(value = "/users3/{param1}/{param2}")  // GET, PUT, POST 무관 하게 할대.
	      @PostMapping(value = "/users3/{param1}/{param2}")
	      @GetMapping(value = "/users3/{param1}/{param2}")
	      @PutMapping(value = "/users3/{param1}/{param2}") 
         */

        String json = responseEntity.getBody();
        System.out.println("json::" + json);

		return json;

	}

}