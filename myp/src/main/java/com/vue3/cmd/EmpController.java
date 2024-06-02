package com.vue3.cmd;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@RestController
public class EmpController {

    @CrossOrigin(origins = "*")
    @PostMapping(value = "/empSch")
    public HashMap<String, Integer> getUsers(@RequestBody Map<String, Object> requestBody) {
        HashMap<String, Integer> scores = new HashMap<>();

        // 요청 본문에서 데이터 추출
        String empNm = (String) requestBody.get("empNm");
        List<Map<String, Object>> empListObj = (List<Map<String, Object>>) requestBody.get("list_m");
        Map<String, Object> empOjb = (Map<String, Object>) requestBody.get("empOjb");

        // 출력 확인
        System.out.println("empNm: " + empNm);
        System.out.println("empListObj: " + empListObj);
        System.out.println("empOjb: " + empOjb);

        // 키와 값 저장
        scores.put("John Doe", 90);
        scores.put("Jane Doe", 80);
        scores.put("John Smith", 70);

        return scores;
    }
	
	@CrossOrigin(origins = "*")
    @RequestMapping(value = "/empSch_GET", method = RequestMethod.GET)
    public HashMap<String, Integer> getUsers(HttpServletRequest request,
                                             HttpServletResponse response,
                                             HttpSession session,
                                             @RequestParam String empNm,
                                             @RequestParam String list_m,
                                             @RequestParam String empOjb) throws Exception {
        HashMap<String, Integer> scores = new HashMap<>();

        // URL 디코딩을 수행
        String decodedEmpList = java.net.URLDecoder.decode(list_m, "UTF-8");
        String decodedEmpOjb = java.net.URLDecoder.decode(empOjb, "UTF-8");

        // JSON 문자열을 다시 객체로 변환
        ObjectMapper objectMapper = new ObjectMapper();
        List<Map<String, Object>> empListObj = objectMapper.readValue(decodedEmpList, List.class);
        Map<String, Object> empOjbObj = objectMapper.readValue(decodedEmpOjb, Map.class);

        // 출력 확인
        System.out.println("empNm: " + empNm);
        System.out.println("list_m: " + empListObj);
        System.out.println("empOjb: " + empOjbObj);

        // 키와 값 저장
        scores.put("John Doe", 90);
        scores.put("Jane Doe", 80);
        scores.put("John Smith", 70);

        return scores;
    }
}
