package com.elsoproject.domain;

import java.util.Date;

//jelezzük a Hibernate-nek hogy ez egy Entity
//@Entity (name="stories") //stories névvel hozza létre az adattáblát

public class Story {

	private Long id; // A hibernate-hoz kell ID mindig

	private String title;

	private String content;
	private Date posted;

	private Blogger blogger;

	public Story() { // privátnak kell lennie ennek az üres konstruktornak

	}

	public Story(String title, String content, Date posted, Long blogger_id) {
		this.title = title;
		this.content = content;
		this.posted = posted;
		this.blogger = new Blogger(blogger_id, "Geri", 30);
	}

	public Story(Long id, String title, String content, Date posted, Long blogger_id) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.posted = posted;
		this.blogger = new Blogger(blogger_id, "Geri", 30);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Story [title=" + title + blogger + "= author";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getPosted() {
		return posted;
	}

	public void setPosted(Date posted) {
		this.posted = posted;
	}

	public Blogger getBlogger() {
		return blogger;
	}

	public void setBlogger(Blogger blogger) {
		this.blogger = blogger;
	}

}
