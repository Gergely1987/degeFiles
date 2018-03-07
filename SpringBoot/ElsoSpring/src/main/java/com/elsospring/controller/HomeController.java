package com.elsospring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elsospring.service.SpyService;

@RestController
public class HomeController {

	private SpyService spyService;

	@Value("${HomeController.msg}")
	private Integer message;
	
	@Autowired
	public void setSpyService(SpyService spyService) {
		this.spyService = spyService;
	}

	@RequestMapping("/")
	public String index() {
		//return spyService.iSaySomething();
		return String.valueOf(message);
	}
}
