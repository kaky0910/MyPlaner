package com.spring.plan.model.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spring.plan.model.dao.BoardDao;
import com.spring.plan.model.service.BoardService;
import com.spring.plan.model.vo.Board;
import com.spring.plan.model.vo.BoardComment;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Resource
	private BoardDao boardDao;

	@Override
	public Board getBoardByNo(int boardNo) throws Exception {
		return boardDao.getBoardByNo(boardNo);
	}

	@Override
	public List<Board> getAllBoard() throws Exception {
		return boardDao.getAllBoard();
	}

	@Override
	public List<Board> getBoardByTitle(String title) throws Exception {
		return boardDao.getBoardByTitle(title);
	}

	@Override
	public int writeBoard(Board board) throws Exception {
		System.out.println("inset Àü:"+board.getBoardNo());
		boardDao.writeBoard(board);
		return boardDao.writeBoard(board);
		
	}
		
	@Override
	public int updateBoard(Board board) throws Exception {
		return boardDao.updateBoard(board) ;
	}

	@Override
	public int deleteBoard(int boardNo) throws Exception {
		return boardDao.deleteBoard(boardNo);
	}

	@Override
	public int addBoardComment(int boardNo, BoardComment boardComment) throws Exception {
		return boardDao.addBoardComment(boardNo, boardComment);
	}

	@Override
	public int deleteBoardComment(int boardNo, BoardComment boardComment) throws Exception {
		return boardDao.deleteBoardComment(boardNo, boardComment);
	}


}
