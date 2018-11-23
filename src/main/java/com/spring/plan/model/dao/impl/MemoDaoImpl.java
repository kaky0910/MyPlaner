package com.spring.plan.model.dao.impl;

import org.springframework.stereotype.Repository;

import com.spring.plan.model.dao.MemoDao;

@Repository
public class MemoDaoImpl implements MemoDao {

	@Override
	public String getMemo(String nickname, String memo) throws Exception {
		return null;
	}

	@Override
	public int updateMemo(String nickname, String memo) throws Exception {
		return 0;
	}

}
