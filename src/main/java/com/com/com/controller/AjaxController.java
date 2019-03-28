package com.com.com.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.com.com.service.AjaxService;

@Controller
public class AjaxController {

	@Resource(name="service")
	private AjaxService ajaxService;

	@RequestMapping("search")
	public String gosearch() throws Exception {
		return "search";
	}
	@RequestMapping("list")
	public ModelAndView search(@RequestParam Map<String, Object> map) throws Exception {
		List<String> list =  ajaxService.search(map);
		ModelAndView mv = new ModelAndView("search");
		mv.addObject("list", list);
		mv.setViewName("list");
		return mv;
	}
}
