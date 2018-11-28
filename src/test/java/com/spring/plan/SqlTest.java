package com.spring.plan;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.spring.plan.model.vo.Daily;
import com.spring.plan.model.vo.Member;
import com.spring.plan.model.vo.Schedule;

public class SqlTest {
	@Test
	public void boardInsert() throws Exception{
		Reader reader = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(reader);
		SqlSession sqlSession = factory.openSession();
		
		Member member = new Member();
		member.setPassword("비번");
		Daily daily = new Daily();
		daily.setEmotion("ㅠㅠ");
		daily.setDay("20181128");
		Schedule schedule = new Schedule();
		schedule.setScheduleNo(0);
		schedule.setScheduleStartDate("20181111");
		schedule.setScheduleEndDate("20181130");
		schedule.setScheduleContent("내용");
		schedule.setScheduleTag("운동");
		schedule.setScheduleTitle("운동");
		sqlSession.insert("schedule-mapper.addSchedule",schedule);
		sqlSession.commit();
	}
}
