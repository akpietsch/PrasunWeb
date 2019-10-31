package de.unikoeln.idh.prasunweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

	@RequestMapping({ "/home", "/start" })
	public ModelAndView getHomepage() {
		return new ModelAndView("home");
	}

	@RequestMapping(value = "/book")
	public ModelAndView bookview() {
		return new ModelAndView("book");
	}
	

}
