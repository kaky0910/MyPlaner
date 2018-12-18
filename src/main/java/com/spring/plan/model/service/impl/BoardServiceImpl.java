package com.spring.plan.model.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spring.plan.model.dao.BoardDao;
import com.spring.plan.model.service.BoardService;
import com.spring.plan.model.service.paging.BoardListVO;
import com.spring.plan.model.service.paging.MessageListVO;
import com.spring.plan.model.service.paging.PagingBean;
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
	public BoardListVO getAllBoard(int memberNo, int bpageNo) throws Exception {
		int pn = 0;
		if(bpageNo == 0) pn=1;
		else pn = bpageNo;
		
		int total = boardDao.totalBoardNumber(memberNo);
		
		PagingBean pb = new PagingBean(total, pn);
		
		BoardListVO param = new BoardListVO();
	
		param.setMemberNo(memberNo);
		param.setPageNo(bpageNo);
		
		return new BoardListVO(boardDao.getAllBoard(param), pb, memberNo);
	}

	@Override
	public List<Board> getBoardByTitle(String title) throws Exception {
		return boardDao.getBoardByTitle(title);
	}

	@Override
	public int writeBoard(Board board) throws Exception {
		System.out.println("inset Àü:"+board.getBoardNo());
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
	public int deleteBoardComment(BoardComment boardComment) throws Exception {
		return boardDao.deleteBoardComment(boardComment);
	}

}
