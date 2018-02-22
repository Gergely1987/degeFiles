package com.elsoproject.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elsoproject.domain.Blogger;
import com.elsoproject.domain.Story;
import com.elsoproject.repository.StoryRepository;
import com.elsoproject.service.BloggerService;
import com.elsoproject.service.StoryService;


//@RestController ami a requestMapping-ben van azt adja vissza
@Controller
public class HomeController {
	
	private StoryService storyService;
	private BloggerService bloggerService;
	
	
	public HomeController(StoryService storyService, BloggerService bloggerService) {
		this.storyService = storyService;
		this.bloggerService = bloggerService;
	}

	@RequestMapping("/")   //azért működik így mert a thymeleaf fel van véve a dependecyk közé
	public String stories(Model model, Locale locale) {
		model.addAttribute("pageTitle", "minden napra egy sztori"); //th-val kell beállítanom a html-en
		model.addAttribute("stories", storyService.getStories());  //StoryService-ből lekérjük az storykat
		
		//System.out.println(String.format("REquest received. Language: %s, Country: %s %n",locale.getLanguage(),locale.getDisplayCountry()));
		return "stories";
	}
	
//	@RequestMapping("/story")
//	public String story(Model model) {
//		model.addAttribute("pageTitle", "minden napra egy sztori");
//		model.addAttribute("story", storyService.getStory()); 
//		return "story";
//	}
//	
//
		@RequestMapping("/title/{title}")    // title/cím link alapján keresek cikket
	public String searhForUser(@PathVariable(value="title")String title, Model model) throws Exception { //a hivatkozott sztori címe ugyanaz mint amit átadunk a metódusnak	
		if(title==null) {
			throw new Exception("Nincs ilyen címmel sztori");
		}
		model.addAttribute("story", storyService.getSpecificStory(title));
		return "story";
	}
	
	
	
	
//		// az ilyen nevűre keresünk rá
//@RequestMapping("/user/{name}")   
//	public String searhForUser1(@PathVariable(value="name")String name, Model model) { //a hivatkozott name ugyanaz mint amit átadunk a metódusnak		
//	
//	System.out.println("alma");
//		if(name==null) {
//			System.out.println("körte");
//			throw new RuntimeException("Nincs ilyen névvel felhasználó");
//		}
//		System.out.println(name);
//	
//		List<Blogger>bloggerek=bloggerService.getBloggers();
//		for(Blogger b: bloggerek) {
//			if(b.getName().equals(name)) {
//				Blogger findByNameBlogger = bloggerService.findByNameBlogger(name);
//		model.addAttribute("blogger", findByNameBlogger);
//		return "user";
//			}
//		}
//
//		model.addAttribute("errormessage");
//		
//		return "error";
//		
//	}
	
	
//EXCAPTION KEZELÉSHEZ ha nem jó id-t ad meg
//így mondjuk el, hogy az exceptionoket elirányítsa valamilyen oldalra	
//	@ExceptionHandler(Exception.class)
//		public String exeptionHandler(HttpServletRequest ra, Exception ex, Model model) {
//		model.addAttribute("errMessage", ex.getMessage());
//
//			return  "error";
//		}
	
}
