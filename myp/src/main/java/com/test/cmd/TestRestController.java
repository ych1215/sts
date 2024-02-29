package com.test.cmd;

import java.util.HashMap;

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

}