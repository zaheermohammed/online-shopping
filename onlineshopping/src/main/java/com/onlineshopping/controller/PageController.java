package com.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.online.shopping.DAO.CategoryDAO;
import com.online.shopping.DAOimpl.CategoryDAOImpl;
import com.online.shopping.DTO.CategoryDTO;

@Controller
public class PageController {

	@Autowired
	private CategoryDAO categoryDAO;
	
	@RequestMapping(value={"/","/index","/home"})
	public ModelAndView index(){
		ModelAndView mv= new ModelAndView("page");
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("title", "Home");
		mv.addObject("userClickHome", true);
		return mv;
	}
	
	@RequestMapping(value="about")
	public ModelAndView aboutUs(){
		ModelAndView mv= new ModelAndView("page");
		mv.addObject("title", "About Us");
		mv.addObject("userClickAbout", true);
		return mv;
	}
	
	@RequestMapping(value="contact")
	public ModelAndView contactUs(){
		ModelAndView mv= new ModelAndView("page");
		mv.addObject("title", "Contact Us");
		mv.addObject("userClickContact", true);
		return mv;
	}
	
	/* load all products and base on category */
	@RequestMapping(value="show/all/products")
	public ModelAndView showallProduct(){
		ModelAndView mv= new ModelAndView("page");
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("title", "All Products");
		mv.addObject("userClickAllProducts", true);
		return mv;
	}
	
	@RequestMapping(value="show/category/{id}/products")
	public ModelAndView showCategoryProduct(@PathVariable("id") int id){
		ModelAndView mv= new ModelAndView("page");
		
		CategoryDTO category = null;
		category = categoryDAO.get(id);
		
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("title", category.getName());
		mv.addObject("category", category);
		mv.addObject("userClickCategoryProducts", true);
		return mv;
	}
	
}
