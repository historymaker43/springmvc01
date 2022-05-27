package com.kh.ex01.vo;

import java.sql.Date;
import java.util.Arrays;

public class BoardVo {
	private int bno;
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	private int viewcnt;
	private int re_group;
	private int re_level;
	private int re_seq;
	private String[] files;

	public BoardVo(int bno, String title, String content, String writer, Date regdate, int viewcnt, int re_group,
			int re_level, int re_seq) {
		super();
		this.bno = bno;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.regdate = regdate;
		this.viewcnt = viewcnt;
		this.re_group = re_group;
		this.re_level = re_level;
		this.re_seq = re_seq;
	}

	public String[] getFiles() {
		return files;
	}

	public void setFiles(String[] files) {
		this.files = files;
	}

	public int getRe_level() {
		return re_level;
	}

	public void setRe_level(int re_level) {
		this.re_level = re_level;
	}

	public int getRe_group() {
		return re_group;
	}

	public void setRe_group(int re_group) {
		this.re_group = re_group;
	}

	public int getRe_seq() {
		return re_seq;
	}

	public void setRe_seq(int re_seq) {
		this.re_seq = re_seq;
	}

	public BoardVo() {
		super();
	}

	public BoardVo(String title, String content, String writer) {
		super();
		this.title = title;
		this.content = content;
		this.writer = writer;
	}

	public BoardVo(int bno, String title, String content, String writer, Date regdate, int viewcnt) {
		super();
		this.bno = bno;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.regdate = regdate;
		this.viewcnt = viewcnt;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		if (bno > 0) {
			this.bno = bno;
		}
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		if (title != null && !title.equals("")) {
			this.title = title;
		}
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getViewcnt() {
		return viewcnt;
	}

	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}

	@Override
	public String toString() {
		return "BoardVo [bno=" + bno + ", title=" + title + ", content=" + content + ", writer=" + writer + ", regdate="
				+ regdate + ", viewcnt=" + viewcnt + ", re_group=" + re_group + ", re_level=" + re_level + ", re_seq="
				+ re_seq + ", files=" + Arrays.toString(files) + "]";
	}

}
