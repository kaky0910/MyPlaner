package com.spring.plan.model.service.paging;

import java.util.List;

import com.spring.plan.model.vo.Board;


public class BoardListVO {					///	페이징 처리할때 사용 각자 하나씩 복사해서 새로 만드셈 필요할때마다 이름은 *****ListVO 
	private List<Board> list;
	private PagingBean pb;
	private int memberNo;
	private int pageNo;
	
	
	public BoardListVO(List<Board> list, PagingBean pb, int memberNo) {
		super();
		this.list = list;
		this.pb = pb;
		this.memberNo = memberNo;
	}
	
	public BoardListVO() {}
	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public List<Board> getList() {
		return list;
	}
	public void setList(List<Board> list) {
		this.list = list;
	}
	public PagingBean getPb() {
		return pb;
	}
	public void setPb(PagingBean pb) {
		this.pb = pb;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	@Override
	public String toString() {
		return "BoardListVO [list=" + list + ", pb=" + pb + "]";
	}

}
