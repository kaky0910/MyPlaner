package com.spring.plan.controller;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.spring.plan.model.dao.BoardDao;
import com.spring.plan.model.service.BoardService;
import com.spring.plan.model.service.paging.ListVO;
import com.spring.plan.model.vo.Board;
import com.spring.plan.model.vo.Member;



@Controller
public class BoardController {
	
	@Resource
	private BoardService boardService;
	
	@Resource
	private BoardDao boardDao;
	
	@RequestMapping("boardwrite.do")
	public ModelAndView write(HttpSession session , Board board) throws Exception {
		boolean flag = true;
		session.setAttribute("flag", flag);
		Member member = (Member)session.getAttribute("member");
		if(member == null)
			return new ModelAndView("redirect:/index.jsp");
		
		
		board.setMember(member);
		
		// FileUpload 부분 추가
		MultipartFile mFile = board.getUploadFile();
		System.out.println(mFile.getSize() + "====" + mFile.isEmpty());// false
		if (mFile.isEmpty() == false) {
			String fileName = mFile.getOriginalFilename();
			board.setOrgfilename(fileName);

			String newFileName = System.currentTimeMillis() + fileName;
			board.setNewfilename(newFileName); // board에 모든 값의 주입이 끝났다.

			// upload 폴더에 transferTo 시킨다..
			String root = session.getServletContext().getRealPath("/");
			String path = root + "\\upload\\";
			System.out.println(root);
			File copyFile = new File(path + newFileName);
			mFile.transferTo(copyFile);// upload폴더로 이동됨....

		}
		
		boardService.writeBoard(board); // 이때 모든 정보가 db에 들어간다.
		return new ModelAndView("board/show_content", "board", board);
	}
	
	@RequestMapping("getboard.do")
	public ModelAndView writeBoard(Board board, int boardNo) throws Exception{
		Board b = boardService.getBoardByNo(boardNo);
		return new ModelAndView();
	}
	
	@RequestMapping("boardlist.do")
	public ModelAndView list(String pageNo) throws Exception {
		List<Board> lbo = boardService.getAllBoard();
		return new ModelAndView("board/list", "lbo", lbo);
	}
		
	
	@RequestMapping("deleteboard.do")
	public ModelAndView delete(HttpSession session, int boardNo) throws Exception {
		// FileUpload 부분을 추가함
		Board board = boardService.deleteBoard();
		
		String root = session.getServletContext().getRealPath("/");
		String path = root + "\\upload\\";
		
		File file = new File(path + board.getNewfilename());
        
        if(file.exists()){
            if(file.delete()){
                //System.out.println("개시발");
            }else{
                //System.out.println(" 아나이씨");
            }
        }else{
            //System.out.println("존나뭔데");
        }
		
		boardDao.deleteBoard(boardNo);
				
		return new ModelAndView("redirect:/boardlist.do");
	}
	
	@RequestMapping("updateboard.do")
	public ModelAndView update(int no) throws Exception {
		Board board = boardService.getBoardByNo(no);
		
		return new ModelAndView("board/update", "board", board);
	}
	
	@RequestMapping("updateResult.do")
	public ModelAndView updateResult(HttpSession session, Board pvo) throws Exception {
		System.out.println("oh holy shit");
		Member member = (Member)session.getAttribute("memeber");
		
		if(member == null) {
			return new ModelAndView("redirect:/index.jsp");
		}
		
		String root = session.getServletContext().getRealPath("/");
		String path = root + "\\upload\\";
		
		File file = new File(path + pvo.getNewfilename());
		System.out.println(pvo.getNewfilename() + " 77777777940707");
        
        if(file.exists()){
            if(file.delete()){
               
            }else{
                
            }
        }else{
           
        }
        
        MultipartFile mFile = pvo.getUploadFile();
		if (mFile.isEmpty() == false) {
			String fileName = mFile.getOriginalFilename();
			pvo.setOrgfilename(fileName);

			String newFileName = System.currentTimeMillis() + fileName;
			pvo.setNewfilename(newFileName);

			System.out.println(root);
			File copyFile = new File(path + newFileName);
			mFile.transferTo(copyFile);
		}
		
		boardService.updateBoard(pvo);
		
		return new ModelAndView("board/show_content", "board", pvo);
	}
}
