package com.kh.ex01.vo;

import java.sql.Date;

public class CommentVo {
	private int cno;
	private int bno;
	private String content;
	private String userid;
	private Date regdate;

	public CommentVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CommentVo(int cno, int bno, String content, String userid, Date regdate) {
		super();
		this.cno = cno;
		this.bno = bno;
		this.content = content;
		this.userid = userid;
		this.regdate = regdate;
	}

	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "CommentVo [cno=" + cno + ", bno=" + bno + ", content=" + content + ", userid=" + userid + ", regdate="
				+ regdate + "]";
	}

}
