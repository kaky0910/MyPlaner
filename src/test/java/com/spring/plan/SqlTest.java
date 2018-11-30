package com.spring.plan;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.spring.plan.model.vo.Challenge;
import com.spring.plan.model.vo.ChallengeLog;
import com.spring.plan.model.vo.Daily;

public class SqlTest {
	/*@Test
	public void boardInsert() throws Exception{
		Reader reader = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(reader);
		SqlSession sqlSession = factory.openSession();
		
		Member member = new Member();
		member.setPassword("비번");
		Daily daily = new Daily();
		daily.setEmotion("ㅠㅠ");
		daily.setDay("20181128");
		daily.setMonth("11");
		daily.setMemberNo(4);
		Schedule schedule = new Schedule();
		schedule.setScheduleNo(0);
		schedule.setScheduleStartDate("20181111");
		schedule.setScheduleEndDate("20181130");
		schedule.setScheduleContent("내용");
		schedule.setScheduleTag("운동");
		schedule.setScheduleTitle("운동");
		System.out.println("11");
		System.out.println(sqlSession.selectOne("daily-mapper.selectEmotionByYear","2018"));
		sqlSession.commit();
		System.out.println("@2");
	}*/
	
	
	/////////////////////////////////////////////////////
	/////////////////////////////////////////////////////
	
	
/*	@Test
	public void sendMessage() throws Exception { // 메세지 보내기
		Reader reader = Resources.getResourceAsReader("config/SqlMapConfig.xml");

		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession sqlSession = factory.openSession();

		Message message = new Message(0, 0, 1, null, "메세지 보내기 1 컨텐트", "SEND MESSAGE TITLE 1!!");

		// int sendMessage(Message message) // 메세지 보내기
		System.out.println(message.getSenderMemberNo()+"님이 "+message.getDestinationMemberNo()+ "님에게 메세지 보냅니다.");
		sqlSession.insert("message-mapper.sendMessage", message);
		sqlSession.commit();
		System.out.println(message.getMessageTitle()+"보내기 성공!");
	}*/
	
	/*@Test
	public void getMessage() throws Exception {// 메세지 번호를 가지는 메세지 가져오기
		Reader reader = Resources.getResourceAsReader("config/SqlMapConfig.xml");

		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession sqlSession = factory.openSession();

		//Message getMessage(int messageNo) / messageNo를 가진 메세지 정보
		Message message = (Message)sqlSession.selectOne("message-mapper.getMessage", 13);
		
		System.out.println(message);
	}
	*/
/*	@Test
	public void deleteMessage() throws Exception {  // 메세지 번호를 가지는 메세지 삭제하기
		Reader reader = Resources.getResourceAsReader("config/SqlMapConfig.xml");

		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession sqlSession = factory.openSession();

		System.out.println("메세지를 삭제합니다.");
		sqlSession.delete("message-mapper.deleteMessage", 16);
		sqlSession.commit();
		System.out.println("메세지 삭제가 완료되었습니다");	
	}*/
	
	/*@Test
	public void getMessageList() throws Exception {
		Reader reader = Resources.getResourceAsReader("config/SqlMapConfig.xml");

		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession sqlSession = factory.openSession();

		List<Message> messageList = sqlSession.selectList("message-mapper.getMessageList", 1);
		
		for(Message message : messageList)
			System.out.println(message);
	}
	*/
	/*@Test
	public void getSendMessageList() throws Exception {
		Reader reader = Resources.getResourceAsReader("config/SqlMapConfig.xml");

		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession sqlSession = factory.openSession();

		List<Message> messageList = sqlSession.selectList("message-mapper.getSendMessageList", 0);
		
		for(Message message : messageList)
			System.out.println(message);
	}*/
	/*
	@Test
	public void readMessage() throws Exception {
		Reader reader = Resources.getResourceAsReader("config/SqlMapConfig.xml");

		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession sqlSession = factory.openSession();

		sqlSession.update("message-mapper.readMessage", 18);
		sqlSession.commit();
		
		Message message = (Message)sqlSession.selectOne("message-mapper.getMessage", 18);
		
		System.out.println(message);
		System.out.println(message.isCheck());
		System.out.println("메세지를 읽으셨습니다.");
	}*/
	
	
	
	//////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////
	
/*	@Test
	public void addChallenge() throws Exception {
		Reader reader = Resources.getResourceAsReader("config/SqlMapConfig.xml");

		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession sqlSession = factory.openSession();
		
		Challenge challenge = new Challenge(0,"C - TEST C-1", "2018-11-29", "2018-12-12",1, "TEST C", true);
		sqlSession.insert("challenge-mapper.addChallenge", challenge);
		sqlSession.commit();
		System.out.println(challenge.getChallengeTitle() + " << 도전 등록 성공!!");
	}*/
	
	/*@Test
	public void deleteChallenge() throws Exception {
		Reader reader = Resources.getResourceAsReader("config/SqlMapConfig.xml");

		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession sqlSession = factory.openSession();
	
		sqlSession.delete("challenge-mapper.deleteChallenge", 23);
		sqlSession.commit();

		System.out.println("Challenge가 삭제되었습니다.");
	}*/
	/*
	@Test
	public void addChallengeContent() throws Exception {
		Reader reader = Resources.getResourceAsReader("config/SqlMapConfig.xml");

		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession sqlSession = factory.openSession();
		
		List<ChallengeContent> challengeContentList = new ArrayList<ChallengeContent>();
		challengeContentList.add(new ChallengeContent(16, "Content 111"));
		challengeContentList.add(new ChallengeContent(16, "Content 222"));
		
		sqlSession.insert("challenge-mapper.addChallengeContent", challengeContentList);
		sqlSession.commit();
		
		for(int i = 0 ; i < challengeContentList.size(); i++)
			System.out.println(challengeContentList.get(i).getChallengeContent() + " << 세부 항목 등록 성공!!");
	}*/
	
/*	@Test
	public void deleteChallengeContent() throws Exception {
		Reader reader = Resources.getResourceAsReader("config/SqlMapConfig.xml");

		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession sqlSession = factory.openSession();
		
		String challengeContent = "Content CCC";
		sqlSession.delete("challenge-mapper.deleteChallengeContent", challengeContent);
		sqlSession.commit();
		
		System.out.println(challengeContent + " << 이 삭제되었습니당.");
	}*/
	
	
	/*@Test
	public void writeChallengeComment() throws Exception {
		Reader reader = Resources.getResourceAsReader("config/SqlMapConfig.xml");

		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession sqlSession = factory.openSession();
		
		ChallengeComment challengeComment = new ChallengeComment(0,0,14,1,"ㅋuㅋㅋㅋㅋㅋ",null);
		//challengeCommentList.add(new ChallengeComment(0,0,6,"huizz","안될 것 같은데여...",null));
		
		sqlSession.insert("challenge-mapper.writeChallengeComment", challengeComment);
		sqlSession.commit();
		
		System.out.println("댓글 등록 성공!!");
	}*/
	
/*	@Test
	public void deleteChallengeComment() throws Exception {
		Reader reader = Resources.getResourceAsReader("config/SqlMapConfig.xml");

		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession sqlSession = factory.openSession();

		sqlSession.delete("challenge-mapper.deleteChallengeComment", 35);
		sqlSession.commit();
		
		System.out.println("댓글 삭제 성공!!");
	}*/
	
	/*@Test
	public void checkChallenge() throws Exception {
		Reader reader = Resources.getResourceAsReader("config/SqlMapConfig.xml");

		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession sqlSession = factory.openSession();

		sqlSession.update("challenge-mapper.checkChallenge", new ChallengeContent(14, "힌트 재배치 여의봉 아끼기"));
		sqlSession.commit();
		
		System.out.println("오늘의 미션 컴플릿~~");
	}*/
	
	/*@Test
	public void getAllChallengeList() throws Exception {
		Reader reader = Resources.getResourceAsReader("config/SqlMapConfig.xml");

		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession sqlSession = factory.openSession();

		List<Challenge> challengeList = sqlSession.selectList("challenge-mapper.getAllChallengeList");
		
		for(Challenge c : challengeList)
			System.out.println(c);
	}*/
	
	/*@Test
	public void updateChallengeLog() throws Exception {
		Reader reader = Resources.getResourceAsReader("config/SqlMapConfig.xml");

		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession sqlSession = factory.openSession();

		sqlSession.insert("challenge-mapper.updateChallengeLog", new ChallengeLog(20,"log test", 1));
		sqlSession.commit();
		
		System.out.println("업데이트 성공!");
	}*/
	
	/*@Test
	public void getChallengeByNo() throws Exception {
		Reader reader = Resources.getResourceAsReader("config/SqlMapConfig.xml");

		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession sqlSession = factory.openSession();

		Challenge challenge = sqlSession.selectOne("challenge-mapper.getChallengeByNo", 14);
		System.out.println("11"+challenge.getChallengeLogList());
		System.out.println("22"+challenge.getChallengeContentList());
		System.out.println("33"+challenge.getChallengeCommentList());
	}*/
	
	/*@Test
	public void getChallengeByMonth() throws Exception {
		Reader reader = Resources.getResourceAsReader("config/SqlMapConfig.xml");

		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession sqlSession = factory.openSession();
		
		Daily challengeByMonth = new Daily(1, "11", "28");
		List<Challenge> list = sqlSession.selectList("challenge-mapper.getChallengeByMonth",challengeByMonth);
		
		System.out.println(list);
		for(Challenge c : list)
			System.out.println(c);
		
		System.out.println("출력 완료");
	}*/
	
	/*@Test
	public void getChallengeByMonth() throws Exception {
		Reader reader = Resources.getResourceAsReader("config/SqlMapConfig.xml");

		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession sqlSession = factory.openSession();
		
		Daily challengeByDay = new Daily(0, "11", "20181128");
		List<Challenge> list = sqlSession.selectList("challenge-mapper.getChallengeByDay",challengeByDay);
		
		System.out.println(list);
		for(Challenge c : list)
			System.out.println(c);
		
		System.out.println("출력 완료");
	}*/
	
}
