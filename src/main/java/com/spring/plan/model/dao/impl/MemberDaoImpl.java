package com.spring.plan.model.dao.impl;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.plan.model.dao.MemberDao;
import com.spring.plan.model.vo.BlockMember;
import com.spring.plan.model.vo.Member;

@Repository
public class MemberDaoImpl implements MemberDao {
	
	@Resource
	SqlSession sqlSession;

	@Override
	public Member login(Member mvo) throws Exception {
		return sqlSession.selectOne("member-mapper.login",mvo);
	}

	@Override
	public int regist(Member mvo) throws Exception {
		return sqlSession.insert("member-mapper.regist",mvo);
	}

	@Override
	public int idCheck(String id) throws Exception {
		return sqlSession.selectOne("member-mapper.idCheck",id);
	}

	@Override
	public int blockMember(BlockMember blockMember) throws Exception {
		return sqlSession.insert("member-mapper.blockMember",blockMember);
	}

	@Override
	public int checkKakao(Member mvo) throws Exception {
		return sqlSession.selectOne("member-mapper.checkKakaoId",mvo.getKakaoId());
	}

	@Override
	public int registKakao(Member mvo) throws Exception {
		return sqlSession.insert("member-mapper.registKakao",mvo);
	}

	@Override
	public Member kakaoLogin(Member mvo) throws Exception {
		return sqlSession.selectOne("member-mapper.kakaoLogin",mvo);
	}

}
