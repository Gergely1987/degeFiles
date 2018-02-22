package com.elsoproject.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity  //csak JPA esetén van entity
public class Blogger {
	
	@GeneratedValue //jelezzük, hogy az adatbázisnak kell az ID-t generálnia
	@Id //ezzel tesszük primary key-jé
	private Long id;
	private String name;
	private int age;
	@JsonBackReference
	@OneToMany  (mappedBy="blogger")  //a storynak csak egy szerzője lehet, jelzem, hogy a kettő kapcsolatából ő a felsőbbrendű
	private List<Story>stories;
	
	private Blogger() {
		
	}

	
	public Blogger(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}



	public List<Story> getStories() {
		return stories;
	}



	public void setStories(ArrayList<Story> stories) {
		this.stories = stories;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	

}
