package com.test.cmd;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class FileUploadController {

    @RequestMapping(value = "/FileUploadServlet", method = RequestMethod.POST)
    public String uploadFile(MultipartFile[]  photo, Model model , HttpServletRequest request) throws IllegalStateException, IOException {

    	
    //	request.setCharacterEncoding("UTF-8");
    	
    	
    	String contextRootPath = request.getSession().getServletContext().getRealPath("/");
    	
    	System.out.println (request.getParameter("description"));
    	
    	 for (MultipartFile file : photo) {
    	      // 파일 저장
    	      String filename = file.getOriginalFilename();
    	      File saveFile = new File(contextRootPath + filename);
    	      file.transferTo(saveFile);

    	      // DB에 저장
    	      // ...
    	    }

        // 모델에 파일 이름을 저장한다.

        return "main";
    }
}