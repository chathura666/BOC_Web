package com.sprhib.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LinkController {
	
	@RequestMapping(value="/")
	public ModelAndView mainPage() {
		return new ModelAndView("home");
	}
	
	@RequestMapping(value="/index")
	public ModelAndView indexPage() {
		return new ModelAndView("home");
	}
        
        @RequestMapping(value="/login")
	public ModelAndView loginPage() {
		return new ModelAndView("Login");
	}
        
//        @RequestMapping(value="/pbase")
//        public ModelAndView ProductsPage() {
//		return new ModelAndView("products");
//	}
}
