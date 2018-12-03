package com.spring.plan.model.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.plan.model.dao.ScheduleDao;
import com.spring.plan.model.vo.Daily;
import com.spring.plan.model.vo.Schedule;

@Repository
public class ScheduleDaoImpl implements ScheduleDao {

	@Resource
	SqlSession sqlSession;
	
	@Override
	public int addSchedule(Schedule schedule) throws Exception {
		return sqlSession.insert("schedule-mapper.addSchedule",schedule);
	}

	@Override
	public int deleteSchedule(int scheduleNo) throws Exception {
		return sqlSession.delete("schedule-mapper.deleteSchedule",scheduleNo);
	}

	@Override
	public int updateSchedule(Schedule schedule) throws Exception {
		return sqlSession.update("schedule-mapper.updateSchedule",schedule);
	}

	
	@Override
	public Schedule getScheduleDetail(int scheduleNo) throws Exception {
		return sqlSession.selectOne("schedule-mapper.getScehduleDetail",scheduleNo);
	}

	@Override
	public List<Schedule> getScheduleByDay(Daily daily) throws Exception {
		return sqlSession.selectList("schedule-mapper.getScheduleByDay",daily);
	}

	@Override
	public List<Schedule> getScheduleByMonth(Daily daily) throws Exception {
		return sqlSession.selectList("schedule-mapper.getScheduleByMonth",daily);
	}

}
