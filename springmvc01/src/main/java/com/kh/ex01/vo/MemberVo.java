package com.kh.ex01.vo;

import java.sql.Date;

public class MemberVo {
	private String userid;
	private String userpw;
	private String username;
	private String email;
	private Date regdate;
	private Date updatedate;
	private int m_point;
	private String m_pic;

	public MemberVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MemberVo(String userid, String userpw, String username, String email, Date regdate, Date updatedate,
			int m_point) {
		super();
		this.userid = userid;
		this.userpw = userpw;
		this.username = username;
		this.email = email;
		this.regdate = regdate;
		this.updatedate = updatedate;
		this.m_point = m_point;
	}

	public MemberVo(String userid, String userpw, String username, String email) {
		super();
		this.userid = userid;
		this.userpw = userpw;
		this.username = username;
		this.email = email;
	}

	public MemberVo(String userid, String userpw, String username, String email, Date regdate, Date updatedate) {
		super();
		this.userid = userid;
		this.userpw = userpw;
		this.username = username;
		this.email = email;
		this.regdate = regdate;
		this.updatedate = updatedate;
	}

	public MemberVo(String userid, String userpw, String username, String email, Date regdate, Date updatedate,
			int m_point, String m_pic) {
		super();
		this.userid = userid;
		this.userpw = userpw;
		this.username = username;
		this.email = email;
		this.regdate = regdate;
		this.updatedate = updatedate;
		this.m_point = m_point;
		this.m_pic = m_pic;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserpw() {
		return userpw;
	}

	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public Date getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}

	public int getM_point() {
		return m_point;
	}

	public void setM_point(int m_point) {
		this.m_point = m_point;
	}

	public String getM_pic() {
		return m_pic;
	}

	public void setM_pic(String m_pic) {
		this.m_pic = m_pic;
	}

	@Override
	public String toString() {
		return "MemberVo [userid=" + userid + ", userpw=" + userpw + ", username=" + username + ", email=" + email
				+ ", regdate=" + regdate + ", updatedate=" + updatedate + ", m_point=" + m_point + ", m_pic=" + m_pic
				+ "]";
	}

}
