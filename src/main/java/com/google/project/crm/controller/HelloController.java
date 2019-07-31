package com.google.project.crm.controller;


import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.project.crm.dao.ProductDao;
import com.google.project.crm.entity.Product;


@Controller
public class HelloController {
	@Autowired
	private ProductDao pDao;
	@RequestMapping("/hello")
	@ResponseBody
	public String hello() {
		// TODO Auto-generated constructor stub
		return "Hello";
	}

	@GetMapping("/index")
	public ModelAndView index() {
		// TODO Auto-generated constructor stub
		ModelAndView mv=new ModelAndView();
		
		mv.addObject("products",pDao.findAll());
		mv.setViewName("index");
		return mv;
	}
	@GetMapping("/demo")
	public ModelAndView insdfex(HttpSession session) {
		// TODO Auto-generated constructor stub
		ModelAndView mv=new ModelAndView();
		if(session.getAttribute("page")==null){
			session.setAttribute("page", 1);
		}
		int page=(int) session.getAttribute("page");
		if (page<1) {
			page=1;
			session.setAttribute("page", page);
		}
		Page<Product> p = null;
		int total=0;
		if (session.getAttribute("total")!=null) {
			total=(int)session.getAttribute("total");
			if(page>=total){
				page=total;
				session.setAttribute("page", page);
			}
		}
		p=PageHelper.startPage(page, 5);
		mv.addObject("products",pDao.findAll());
		total=p.getPages();
		session.setAttribute("total", total);
		
		
		mv.addObject("total",total);
		mv.addObject("current",page);
		mv.setViewName("demo");
		return mv;
	}
	@RequestMapping(value = "/add", produces = "text/plain;charset=UTF-8", method = RequestMethod.POST)
	@ResponseBody
	public String save(Product p) {
		
		pDao.save(p);
		return "{\"0\":\"下单成功,请查看数据库。\"}";
	}
	@RequestMapping(value = "/delete", produces = "text/plain;charset=UTF-8", method = RequestMethod.POST)
	@ResponseBody
	public String d(int id) {
		
		pDao.delete(id);
		return "{\"0\":\"下单成功,请查看数据库。\"}";
	}
	@RequestMapping(value = "/update", produces = "text/plain;charset=UTF-8", method = RequestMethod.POST)
	@ResponseBody
	public String d(Product p) {
		
		pDao.update(p);
		return "{\"0\":\"下单成功,请查看数据库。\"}";
	}
	@RequestMapping(value = "/setpage", produces = "text/plain;charset=UTF-8", method = RequestMethod.POST)
	@ResponseBody
	public String sg(int pageOffset,HttpSession session) {
		session.setAttribute("page", (int)session.getAttribute("page")+pageOffset);
		return "{\"0\":\"下单成功,请查看数据库。\"}";
	}
}
