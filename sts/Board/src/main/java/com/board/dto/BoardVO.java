package com.board.dto;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;

@Component
public class BoardVO {
	private int num;
	private String category;
	private String title;
	private String writer;
	private Timestamp regdate;
	private int views;
	private String content;
	
	public BoardVO() {
		// TODO Auto-generated constructor stub
	}

	public BoardVO(int num, String category, String title, String writer, Timestamp regdate, int views,
			String content) {
		super();
		this.num = num;
		this.category = category;
		this.title = title;
		this.writer = writer;
		this.regdate = regdate;
		this.views = views;
		this.content = content;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Timestamp getRegdate() {
		return regdate;
	}

	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
}


