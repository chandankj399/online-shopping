package com.amazon.onlineshopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("title", "Amazon.com");
		return mv;
	}
	
	
	@RequestMapping(value="/about", method=RequestMethod.GET)
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("about");
		mv.addObject("title", "Amazon.com");
		return mv;
	}
	
	
//	@GetMapping("/test")
//	public ModelAndView test(@RequestParam(value="greetingFromURL",required = false ) String greetingFromMethod) {
//		if (greetingFromMethod == null) {
//			greetingFromMethod = "Default Greeting";
//		}
//		ModelAndView mv = new ModelAndView("page");
//		mv.addObject("greeting", greetingFromMethod);
//		return mv;
//	}
	
	@GetMapping("/test/{greetingFromURL}/{secondPathVariable}")
	public ModelAndView test(@PathVariable("greetingFromURL") String greetingFromMethod,@PathVariable("secondPathVariable") String greeting2FromMethod ) {
		if (greetingFromMethod == null) {
			greetingFromMethod = "Default Greeting";
		}
		
		String insideMethod = greetingFromMethod + greeting2FromMethod;
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting", insideMethod);
		return mv;
	}
	
	
	
}
