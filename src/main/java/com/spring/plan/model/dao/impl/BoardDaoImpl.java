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
		return sqlsession.selectOne("board-mapper.getBoardByNo", boardNo);
	}

	@Override
	public List<Board> getAllBoard() throws Exception {
		return sqlsession.selectList("board-mapper.getAllBoard");
	}

	@Override
	public List<Board> getBoardByTitle(String title) throws Exception {
		return sqlsession.selectList("board-mapper.getBoardByTitle", title);
	}
	
	@Override
	public int writeBoard(Board board) throws Exception {
		return sqlsession.insert("board-mapper.writeBoard",board);
	}

	@Override
	public int updateBoard(Board board) throws Exception {
		return sqlsession.update("board-mapper.updateBoard", board);
	}

	@Override
	public int deleteBoard(int boardNo) throws Exception {
		return sqlsession.delete("board-mapper.deleteBoard", boardNo);
	}

	@Override
	public int addBoardComment(int boardNo, BoardComment boardComment) throws Exception {
		return sqlsession.insert("board-mapper.addBoardComment", boardComment);
	}

	@Override
	public int deleteBoardComment(BoardComment boardComment) throws Exception {
		return sqlsession.delete("board-mapper.deleteBoardComment", boardComment);
	}

	@Override
	public List<Board> getBoardByMemberNo(int memberNo) throws Exception {
		return sqlsession.selectList("board-mapper.getBoardByMemberNo" , memberNo);
	}
}
