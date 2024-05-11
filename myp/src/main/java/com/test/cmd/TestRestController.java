package com.test.cmd;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;


@RestController
public class TestRestController {

    
    @RequestMapping(value = "users")
    public HashMap<String, Integer> getUsers(@RequestHeader("Host") String host, HttpServletRequest request) {
    	
    	HashMap<String, Integer> scores = new HashMap<>();

        // 키와 값 저장
        scores.put("John Doe", 90);
        scores.put("Jane Doe", 80);
        scores.put("John Smith", 70);
        
      String domain = host;
        
        System.out.println("ych::"+ domain);
        System.out.println("FORM_ID::"+ request.getParameter("FORM_ID"));
        
        scores.put("host cnt", domain.length());
        
    	
        return  scores;
    }
    
	@RequestMapping(value = "/users2/{param1}")
    public HashMap<String, Integer> getUsers2(@PathVariable("param1") String param11, @RequestHeader("Host") String host, HttpServletRequest request) {
		
		System.out.println(param11);
		System.out.println(host);
		
        HashMap<String, Integer> scores = new HashMap<>();
        scores.put("John Doe", 90);
        scores.put("Jane Doe", 80);
        scores.put("John Smith", 70);
        return scores;
    }
	
	  @RequestMapping(value = "/users3/{param1}/{param2}")  // GET, PUT, POST 무관 하게 할대.
	  //@PostMapping(value = "/users3/{param1}/{param2}")
	  //@GetMapping(value = "/users3/{param1}/{param2}")
	  //@PutMapping(value = "/users3/{param1}/{param2}")
	    public List<HashMap<String, Integer>> getUsers3(@PathVariable("param1") String param1, @PathVariable("param2") String param2
	    		, @RequestHeader(name = "head1", required = false, defaultValue = "defaultAaaValue") String aaa
	    		,   @RequestHeader("Host") String host
	    		,  HttpServletRequest request) {

	        System.out.println("param1" + param1);
	        System.out.println("param2" + param2);
	        System.out.println("host::" + host);
	        System.out.println("aaa::" + aaa);
	        
	        System.out.println("aaa2::" +   request.getHeader("head1"));
	        
	        System.out.println("request::" + request.getParameter("qqq"));

	        List< HashMap<String, Integer>> userScores = new ArrayList<>();
	        
	        
	        
	        HashMap<String, Integer> scores = new HashMap<>();
	        scores.put("John Doe", 90);
	        scores.put("Jane Doe", 80);
	        scores.put("John Smith", 70);
	        
	        userScores.add(scores);
	        
	        scores = new HashMap<>();
	        scores.put("John Doe", 901);
	        scores.put("Jane Doe", 801);
	        scores.put("John Smith", 701);
	        
	        userScores.add(scores);

	        return userScores;
	    }

}