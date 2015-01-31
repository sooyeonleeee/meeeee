package com.sooyeon.entity;

import java.util.Date;

public class Reply {
	private int replyNo;
	private String userId;
	private int commentNo;
	private String replyContent;
	private Date regDate;

	public Reply() {
	}

	public Reply(int replyNo, String userId, int commentNo,
			String replyContent, Date regDate) {
		super();
		this.replyNo = replyNo;
		this.userId = userId;
		this.commentNo = commentNo;
		this.replyContent = replyContent;
		this.regDate = regDate;
	}

	public int getReplyNo() {
		return replyNo;
	}

	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getCommentNo() {
		return commentNo;
	}

	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "Reply [replyNo=" + replyNo + ", userId=" + userId
				+ ", commentNo=" + commentNo + ", replyContent=" + replyContent
				+ ", regDate=" + regDate + "]";
	}

}
