package com.elsoproject.service;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elsoproject.domain.Blogger;
import com.elsoproject.domain.Story;
import com.elsoproject.repository.BloggerRepository;
import com.elsoproject.repository.StoryRepository;

@Service
public class BloggerService {
	
	private StoryRepository storyRepo;
	private BloggerRepository bloggerRepo;
	
	@Autowired
	public void setStoryRepo(StoryRepository storyRepo) {
		this.storyRepo = storyRepo;
	}
	
	@Autowired
	public void setBloggerRepo(BloggerRepository bloggerRepo) {
		this.bloggerRepo = bloggerRepo;
	}


//	public Blogger findByNameBlogger(String name) {	
//		return bloggerRepo.findByName(name);
//		
//	}
//
//	
//	public List<Blogger> getBloggers() {
//		return bloggerRepo.findAll();
//	}	

//	public List<Story> getStories() {
//		return storyRepo.findAll();
//	}	
//	
//	public Story getStory() {
//		return storyRepo.findFirstByOrderByPostedDesc();
//	}
//
//	public Story getSpecificStory(String title) {
//		return storyRepo.findByTitle(title);
//	}
	
//	@PostConstruct //ezzel állítom be hogy csak egyszer fusson le az init metódus, nem kell senkinek meghívni, automatikusan létrehozódik és lefut egyszer
//	public void init() { //új blogger elmentése itt kezdődik
//		Blogger blogger = new Blogger("Belső Geri",30);
//		bloggerRepo.save(blogger); 
//		
//		Story story =new Story("belső cím", "belső tartalom", new Date(), blogger);
//		storyRepo.save(story);
//		
//	}

}
