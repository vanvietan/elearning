package com.luv2code.java14.elearning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	  @GetMapping("/hello")
	    public String root(Model theModel){
		  
		  theModel.addAttribute("theDate", new java.util.Date());
		  	
	        return "hello";
	    }
}
