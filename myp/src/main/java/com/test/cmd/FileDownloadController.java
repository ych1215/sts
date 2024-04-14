
package com.test.cmd;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class FileDownloadController {

    @RequestMapping(value = "/download", method = RequestMethod.POST)
    public void uploadFile(HttpServletRequest request, HttpServletResponse response) throws IllegalStateException, IOException {

       // String filePath = request.getSession().getServletContext().getRealPath("/") + File.separator + request.getParameter("fileName");
    	
    	 String filePath = "C:\\YCHapp_new\\file_up" + File.separator + request.getParameter("fileName"); // 지정된 경로에서 파일 다운 

        try {
        	
        	System.out.println("filePath::" +  filePath);
        	
        	
            File file = new File(filePath);

            if (file.exists()) {
                response.setContentType("application/octet-stream");
                response.setContentLength((int) file.length());

                String encodedFileName = URLEncoder.encode(request.getParameter("fileName"), "UTF-8");
                response.setHeader("Content-Disposition", "attachment; filename=\"" + encodedFileName + "\"");

                try (FileInputStream inputStream = new FileInputStream(file);
                        OutputStream outputStream = response.getOutputStream()) {

                    byte[] buffer = new byte[4096];
                    int bytesRead = -1;

                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }
                }
            } else {
                // 파일이 존재하지 않을 경우에 대한 처리
                response.getWriter().print("File not found");
            }
        } catch (IOException e) {
            e.printStackTrace(); // 예외 처리 필요
        }
    }
}
