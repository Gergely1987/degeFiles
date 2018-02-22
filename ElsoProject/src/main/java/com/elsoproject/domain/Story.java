package com.elsoproject.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

//jelezzük a Hibernate-nek hogy ez egy Entity
//@Entity (name="stories") //stories névvel hozza létre az adattáblát

@Entity //csak jpa esetén van entity
public class Story {
	@GeneratedValue //jelezzük, hogy az adatbázisnak kell az ID-t generálnia
	@Id	//ezzel tesszük primary key-jé
	private Long id; //A hibernate-hoz kell ID mindig

	@Column(name="cím")//az adatbázisban cím névvel hozzuk létre az oszlopot, így könnyen hozzá tud csatolódni egy már futó és létező adatbázishoz amiben CÍM az oszlop
	private String title;
	//@Column(name="tartalom", length=1000)//átállítom a nevét, és a fogadható karakterek számát is beállítom!!!
	@Column(columnDefinition="TEXT")// ez egy bőduletes nagy méretűre állítja be a befogadható String méretét
	private String content;
	private Date posted;
	@ManyToOne //jelzem, hogy egy bloggernek lehet sok storija
	private Blogger blogger;
	
	private Story() {  //privátnak kell lennie ennek az üres konstruktornak
		
	}
		
	
	public Story(String title, String content, Date posted, Blogger blogger ) {
		super();
		this.title = title;
		this.content = content;
		this.posted = posted;
		this.blogger = blogger;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "Story [title=" + title+ blogger+"= author";
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
