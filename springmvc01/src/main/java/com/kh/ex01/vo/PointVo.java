package com.kh.ex01.vo;

import java.sql.Date;

public class PointVo {
	private int pid;
	private String userid;
	private int point;
	private int pcode;
	private Date pointdate;

	public PointVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PointVo(String userid, int point, int pcode) {
		super();
		this.userid = userid;
		this.point = point;
		this.pcode = pcode;
	}

	public PointVo(int pid, String userid, int point, int pcode, Date pointdate) {
		super();
		this.pid = pid;
		this.userid = userid;
		this.point = point;
		this.pcode = pcode;
		this.pointdate = pointdate;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public int getPcode() {
		return pcode;
	}

	public void setPcode(int pcode) {
		this.pcode = pcode;
	}

	public Date getPointdate() {
		return pointdate;
	}

	public void setPointdate(Date pointdate) {
		this.pointdate = pointdate;
	}

	@Override
	public String toString() {
		return "PointVo [pid=" + pid + ", userid=" + userid + ", point=" + point + ", pcode=" + pcode + ", pointdate="
				+ pointdate + "]";
	}

}
