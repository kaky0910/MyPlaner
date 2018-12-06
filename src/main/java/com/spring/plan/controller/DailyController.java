package com.spring.plan.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;
import java.util.Properties;

import javax.annotation.Resource;

import org.apache.ibatis.io.Resources;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.plan.model.dao.DailyDao;
import com.spring.plan.model.service.ChallengeService;
import com.spring.plan.model.service.HabitService;
import com.spring.plan.model.service.ScheduleService;
import com.spring.plan.model.vo.Daily;
import com.spring.plan.model.vo.Member;

@Controller
public class DailyController {
	
	@Resource
	private DailyDao dailyDao;
	@Resource
	private HabitService habitService;
	@Resource
	private ScheduleService scheduleService;
	@Resource
	private ChallengeService challengeService;
	
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
	
	@RequestMapping("loadingDaily.do")
	public ModelAndView loadingDaily(int memberNo) throws Exception{
		Daily daily = new Daily();
		
		daily.setDay(Daily.getDayByDate());
		daily.setMemberNo(memberNo);
		
		String emotion = dailyDao.getTodayEmotion(daily);
		if(emotion!=null) daily.setEmotion(emotion);
		daily.setMemo(dailyDao.getMemo(memberNo));
		
		daily.setScheduleList(scheduleService.getScheduleByMonth(daily));
		System.out.println("@@@@@@@@@  "+daily.getHabitList());
		daily.setHabitList(habitService.getHabitList(memberNo));
		System.out.println("getHabitList :::::::: "+daily.getHabitList());
		daily.setChallengeList(challengeService.getChallengeByMonth(daily.getMonth(), memberNo));		
		
		System.out.println(daily);
		System.out.println("::::"+daily.getScheduleFormattedArray());
		System.out.println("!!!!!!!  "+daily.getWeeklyCheckHabit());
		return new ModelAndView("index","daily",daily);
	}

}
