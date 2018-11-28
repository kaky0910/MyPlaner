package com.spring.plan.model.vo;

public class BlockMember {
	private String memberNo;
	private String blockMemberNo;
	public String getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}
	public String getBlockMemberNo() {
		return blockMemberNo;
	}
	public void setBlockMemberNo(String blockMemberNo) {
		this.blockMemberNo = blockMemberNo;
	}
	@Override
	public String toString() {
		return "BlockMember [memberNo=" + memberNo + ", blockMemberNo=" + blockMemberNo + "]";
	}
	
}
