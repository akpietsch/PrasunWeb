package dh.master.info.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class IndexController {

	@RequestMapping(value = "/home")
	public ModelAndView getHomepage() {
		return new ModelAndView("home");
	}

	@RequestMapping(value = "/book")
	public ModelAndView bookview() {
		return new ModelAndView("book");
	}

	@RequestMapping(value = "/search")
	public String search(Model model) {
		return "search";
	}

}
