package com.elsoproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elsoproject.domain.Story;
import com.elsoproject.service.StoryService;

@RestController
public class ApiController {
	
// nyers nézetet akarjuk így visszaadni, csak az objektumokat magukat küldjük
	private StoryService storyService;

	@Autowired
	public void setStoryService(StoryService storyService) {
		this.storyService = storyService;
	}

	
//	@RequestMapping("/story")
//	public Story story() {
//		return storyService.getStory();
//		
//	}
//
//	@RequestMapping("/title/{title}") // title/cím link alapján keresek cikket
//	public Story searhForUser(@PathVariable(value="title")String title) { // a hivatkozott sztori címe ugyanaz mint amit átadunk a metódusnak
//		return storyService.getSpecificStory(title);
//	}
////	
//	@RequestMapping("/stories/{name}") // title/cím link alapján keresek cikket
//	public List<Story> searhForStoriesByBloggerName(@PathVariable(value="name")String name) { // a hivatkozott sztori címe ugyanaz mint amit átadunk a metódusnak
//		return storyService.getStoriesByBloggerName(name);
//	}
}
