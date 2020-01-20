package com.amazon.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.amazon.shoppingbackend.dao.CategoryDAO;
import com.amazon.shoppingbackend.dto.Category;

@Controller
public class PageController {
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("title", "Amazon.com");
		mv.addObject("categories",categoryDAO.list());
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
	
	
	
	/*
	 * Methods to load all products
	 */
	
	@RequestMapping(value="/show/all/products")
	public ModelAndView showAllProducts() {
		ModelAndView mv = new ModelAndView("listProducts");
		mv.addObject("title", "All Producs");
		mv.addObject("categories",categoryDAO.list());
		mv.addObject("userClickAllProducts",true);
		
		Category category = null;
		category = categoryDAO.get(1);
		mv.addObject("category", category);
		
		return mv;
	}
	
	@RequestMapping(value="/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("home");
		
		// categoryDAO to fetch a single category
		
		Category category = null;
		category = categoryDAO.get(id);
		
		mv.addObject("title", category.getName());
		mv.addObject("categories",categoryDAO.list());
		mv.addObject("userClickCategoryProducts",true);
		mv.addObject("category", category);
		return mv;
	}
	
	
}
