package com.spring.plan.model.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.plan.model.dao.BoardDao;
import com.spring.plan.model.vo.Board;
import com.spring.plan.model.vo.BoardComment;

@Repository
public class BoardDaoImpl implements BoardDao {
	
	@Resource
	private SqlSession sqlsession;

	@Override
	public Board getBoardByNo(int boardNo) throws Exception {
		return sqlsession.selectOne("BoardMapper.getBoardByNO", boardNo);
	}

	@Override
	public List<Board> getAllBoard() throws Exception {
		return sqlsession.selectList("BoardMapper.getAllBoard");
	}

	@Override
	public List<Board> getBoardByTitle(String title) throws Exception {
		return sqlsession.selectList("BoardMapper.getBoardByTitle", title);
	}

	@Override
	public List<Board> getBoardByNickname(String nickname) throws Exception {
		return sqlsession.selectList("BoardMapper.getBoardByNickname",nickname);
	}

	@Override
	public int writeBoard(Board board) throws Exception {
		return sqlsession.insert("BoardMapper.write",board);
	}

	@Override
	public int updateBoard(Board board) throws Exception {
		return sqlsession.update("BoardMapper.updateBoard", board);
	}

	@Override
	public int deleteBoard(int boardNo) throws Exception {
		return sqlsession.delete("BoardMapper.deleteBoard", boardNo);
	}

	@Override
	public int addBoardComment(int boardNo, BoardComment boardComment) throws Exception {
		return sqlsession.insert("BoardMapper.addBoardComment", boardComment);
	}

	@Override
	public int deleteBoardComment(int boardNo, BoardComment boardComment) throws Exception {
		return sqlsession.delete("BoardMapper.deleteBoardComment", boardComment);
	}

}
