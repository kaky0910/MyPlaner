package com.spring.plan.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DailyController {
	
	@RequestMapping("/searchResult.do")				// 네이버 검색결과
	public ModelAndView searchResult(String word) throws Exception{
		String resource = "config/api.properties";
		Properties properties = new Properties();
		String naverClientId="";
		String naverSecretClientId="";
		String result="";
		
		try {
			Reader reader = Resources.getResourceAsReader(resource);
			properties.load(reader);
			naverClientId = properties.getProperty("naver.ClientId");
			naverSecretClientId = properties.getProperty("naver.SecretClientId");
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("client"+naverClientId);
		System.out.println("secretclient"+naverSecretClientId);
		try {
            String text = URLEncoder.encode(word, "UTF-8");
            String apiURL = "https://openapi.naver.com/v1/search/blog.json?query="+ text; // json 결과
            //String apiURL = "https://openapi.naver.com/v1/search/blog.xml?query="+ text; // xml 결과
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("X-Naver-Client-Id", naverClientId);
            con.setRequestProperty("X-Naver-Client-Secret", naverSecretClientId);
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream(),"UTF-8"));
            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream(),"UTF-8"));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            System.out.println(response.toString());
            result = response.toString();
        } catch (Exception e) {
            System.out.println(e);
        }
		
		return new ModelAndView("JsonView","result",result);
	}

}
