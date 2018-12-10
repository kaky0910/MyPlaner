package com.spring.plan.model.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spring.plan.model.dao.DailyDao;
import com.spring.plan.model.dao.MemberDao;
import com.spring.plan.model.service.MemberService;
import com.spring.plan.model.vo.BlockMember;
import com.spring.plan.model.vo.Member;

@Service
public class MemberServiceImpl implements MemberService {

<<<<<<< HEAD
	@Resource
	private MemberDao memberDao;
	@Resource
	private DailyDao dailyDao;
	
	@Override
	public Member login(Member mvo) throws Exception {
		return memberDao.login(mvo);
	}

	@Override
	public int regist(Member mvo) throws Exception {
		int result = memberDao.regist(mvo);
		System.out.println("memo insert :::: "+dailyDao.insertMemo(mvo));
		return result;
	}

	@Override
	public boolean idCheck(String id) throws Exception {
		if(memberDao.idCheck(id)==1) return true;
		else return false;
	}

	@Override
	public int blockMember(int memberNo, int blockMemberNo) throws Exception {
		BlockMember blockMember = new BlockMember();
		blockMember.setMemberNo(memberNo);
		blockMember.setBlockMemberNo(blockMemberNo);
		return memberDao.blockMember(blockMember);
		
	}

	@Override
	public boolean checkKakao(Member member) throws Exception {
		if(memberDao.checkKakao(member)==0) return false;
		else return true;
	}

	@Override
	public int registKakao(Member mvo) throws Exception {
		int result = memberDao.registKakao(mvo);
		System.out.println("memo insert :::: "+dailyDao.insertMemo(mvo));
		return result;
	}

	@Override
	public Member kakaoLogin(Member mvo) throws Exception {
		return memberDao.kakaoLogin(mvo);
	}

}
=======
   @Resource
   MemberDao memberDao;
   
   @Override
   public Member login(Member mvo) throws Exception {
      return memberDao.login(mvo);
   }

   @Override
   public int regist(Member mvo) throws Exception {
      return memberDao.regist(mvo);
   }

   @Override
   public int idCheck(String id) throws Exception {
      return memberDao.idCheck(id);
   }

   @Override
   public int blockMember(int memberNo, int blockMemberNo) throws Exception {
      BlockMember blockMember = new BlockMember();
      blockMember.setMemberNo(memberNo);
      blockMember.setBlockMemberNo(blockMemberNo);
      return memberDao.blockMember(blockMember);
      
   }

   @Override
   public boolean checkKakao(Member member) throws Exception {
      if(memberDao.checkKakao(member)==0) return false;
      else return true;
   }

   @Override
   public int registKakao(Member mvo) throws Exception {
      return memberDao.registKakao(mvo);
   }

   @Override
   public Member kakaoLogin(Member mvo) throws Exception {
      return memberDao.kakaoLogin(mvo);
   }

}
>>>>>>> 2efc4869a926453b3bb988e8802ec28e2b27ec8e
