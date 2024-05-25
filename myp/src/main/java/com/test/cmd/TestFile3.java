package com.test.cmd;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@MultipartConfig
public class TestFile3 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @RequestMapping(value = "filetest3")
    public ModelAndView filetest(Map<String, Object> map,   HttpServletRequest request , HttpServletResponse response) throws Exception {
    	
    	 // 1. BufferedReader를 사용하여 요청 본문을 읽습니다.
        BufferedReader reader = request.getReader();
        String line;
        StringBuilder sb = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }

        // 2. 요청 본문에서 데이터 추출합니다.
        String formData = sb.toString();
        String[] parts = formData.split("&");
        for (String part : parts) {
            String[] keyValue = part.split("=");
            String key = keyValue[0];
            String value = keyValue[1];
            System.out.println(key + ": " + value);
        }

        // 3. HTML 응답을 생성합니다.
        response.setContentType("text/html");
        response.setContentType("text/html; charset=UTF-8"); 
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>처리 결과</title></head>");
        out.println("<body>");
        out.println("<h1>요청 데이터  request.getReader() 출력 </h1>");
        out.println("<p>" + formData + "</p>");
        out.println("</body>");
        out.println("</html>");
		return null;
    }

  
}
