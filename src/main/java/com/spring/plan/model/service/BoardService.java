package com.spring.plan.model.service;

import java.util.List;

import com.spring.plan.model.vo.Board;
import com.spring.plan.model.vo.BoardComment;

public interface BoardService {

	// board return
	Board getBoardByNo(int boardNo) throws Exception;

	// 게시판 전체 글 return (paging)
	List<Board> getAllBoard() throws Exception;

	// 게시판 제목 검색 (paging)
	List<Board> getBoardByTitle(String title) throws Exception;

	// 글 올리기
	int writeBoard(Board board) throws Exception;

	// 글 수정
	int updateBoard(Board board) throws Exception;

	// 글 삭제
	int deleteBoard(int boardNo) throws Exception;

	// 댓글달기
	int addBoardComment(int boardNo, BoardComment boardComment) throws Exception;

	// 댓글삭제
	int deleteBoardComment(BoardComment boardComment) throws Exception;
}
