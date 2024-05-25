package com.test.cmd;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Map;

import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@MultipartConfig
public class TestFile2 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @RequestMapping(value = "filetest2")
    public ModelAndView filetest2(Map<String, Object> map,   HttpServletRequest request , HttpServletResponse response) throws Exception {
    	
        // 사용자 이름 추출
        String userName = request.getParameter("username");

        // 업로드된 파일을 저장할 디렉토리
        String uploadDirectory = "C:/uploads/abc/";
        File uploadDir = new File(uploadDirectory);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        // 업로드된 파일들을 처리
        Collection<Part> parts = request.getParts();
        for (Part part : parts) {
            String fileName = extractFileName(part);
            if (fileName != null && !fileName.isEmpty()) {
                // 파일 저장
                try (InputStream inputStream = part.getInputStream()) {
                    File file = new File(uploadDirectory, fileName);
                    try (OutputStream outputStream = new FileOutputStream(file)) {
                        byte[] buffer = new byte[4096];
                        int bytesRead = -1;
                        while ((bytesRead = inputStream.read(buffer)) != -1) {
                            outputStream.write(buffer, 0, bytesRead);
                        }
                    }
                }
            }
        }

        // 사용자 이름 출력
        response.getWriter().print("Files uploaded successfully by " + userName + "!");
		return null;
    }

    // 파일 이름을 추출하는 메서드
    private String extractFileName(Part part) {
        String contentDisposition = part.getHeader("content-disposition");
        if (contentDisposition != null) {
            String[] items = contentDisposition.split(";");
            for (String item : items) {
                if (item.trim().startsWith("filename")) {
                    return item.substring(item.indexOf("=") + 2, item.length() - 1);
                }
            }
        }
        return null;
    }
}
