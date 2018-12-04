package com.spring.plan.model.vo;

public class BlockMember {
	private int memberNo;
	private int blockMemberNo;
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo2) {
		this.memberNo = memberNo2;
	}
	public int getBlockMemberNo() {
		return blockMemberNo;
	}
	public void setBlockMemberNo(int blockMemberNo) {
		this.blockMemberNo = blockMemberNo;
	}
	@Override
	public String toString() {
		return "BlockMember [memberNo=" + memberNo + ", blockMemberNo=" + blockMemberNo + "]";
	}
	
}
