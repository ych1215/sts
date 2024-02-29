package com.Proxy.cmd;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class ProxyController {

	@RequestMapping("/proxy")
	public String proxy(HttpServletRequest request) {

		String qStr = request.getQueryString();

		URL url = null;
		HttpURLConnection yc = null;
		try {

			String targetURL = "http://localhost:8089/proxy_test";
			url = new URL(targetURL);
			yc = (HttpURLConnection) url.openConnection();
			yc.setDoOutput(true);
			yc.setInstanceFollowRedirects(false);
			yc.setRequestMethod("POST");
			yc.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
			OutputStream os = yc.getOutputStream();
			os.write(readJSONStringFromRequestBody(request).getBytes());
			os.flush();
			BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream(), "UTF-8"));
			String inputLine;
			StringBuilder sb = new StringBuilder();
			while ((inputLine = in.readLine()) != null) {
				sb.append(inputLine).append("\n");
			}
			in.close();
			return sb.toString();
		} catch (ProtocolException e) {
			e.printStackTrace();
			return null;
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (yc != null)
				yc.disconnect();
		}
	}

	@RequestMapping("/proxy_test")
	public String test(HttpServletRequest request) {
		
		System.out.println("FORM_ID::"+request.getParameter("FORM_ID"));
		System.out.println("USER_ID::"+request.getParameter("USER_ID"));

		//return "{key:'xxxxx'}"; // 오류 
		//return "{'key':'xxxxx'}";  // 오류 
		//return "{ \"FORM_ID\": \"120000110403\", \"USER_ID\": \"highsens\", \"key\" : \"한글\", \"key2\" : 1111 , \"key3\" : abc}"; // 오류 // 숫자 외에는 모두 쌍따옴표로 해야 한다. 
		//return "{ 11111: \"120000110403\", \"USER_ID\": \"highsens\", \"key\" : \"한글\", \"key2\" : 1111 }"; // 오류 // 키는 무조건 쌍따옴표로 해야 한다.  
		return "{ \"staus\":\"S\", \"FORM_ID\": \"120000110403\", \"USER_ID\": \"highsens\", \"key\" : \"한글\", \"key2\" : 1111 }";
	}

	public String readJSONStringFromRequestBody(HttpServletRequest request) {

		System.out.println("11111111111");

		StringBuffer json = new StringBuffer();
		String line = null;
		try {
			BufferedReader reader = request.getReader();
			while ((line = reader.readLine()) != null) {
				json.append(line);
				System.out.println("line::" + line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (json != null) {
			System.out.println("json::" + json.toString());
		}
		return json.toString();
	}

}
