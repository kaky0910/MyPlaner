package com.spring.plan.model.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.plan.model.service.BoardService;
import com.spring.plan.model.vo.Board;
import com.spring.plan.model.vo.BoardComment;

@Service
public class BoardServiceImpl implements BoardService {

	@Override
	public Board getBoardByNo(int boardNo) throws Exception {
		return null;
	}

	@Override
	public List<Board> getAllBoard() throws Exception {
		return null;
	}

	@Override
	public List<Board> getBoardByTitle(String title) throws Exception {
		return null;
	}

	@Override
	public List<Board> getBoardByNickname(String nickname) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int writeBoard(Board board) throws Exception {
		return 0;
	}

	@Override
	public int updateBoard(Board board) throws Exception {
		return 0;
	}

	@Override
	public int deleteBoard(int boardNo) throws Exception {
		return 0;
	}

	@Override
	public int addBoardComment(int boardNo, BoardComment boardComment) throws Exception {
		return 0;
	}

	@Override
	public int deleteBoardComment(int boardNo, BoardComment boardComment) throws Exception {
		return 0;
	}

}
