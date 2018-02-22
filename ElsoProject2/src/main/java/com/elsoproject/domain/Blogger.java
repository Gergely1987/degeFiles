package com.elsoproject.domain;

import java.util.ArrayList;
import java.util.List;



public class Blogger {
	
	
	private Long id;
	private String name;
	private int age;
	
	private List<Story>stories;
	
	private Blogger() {
		
	}

	
	public Blogger(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public Blogger(Long id, String name, int age) {
		this.id=id;
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
