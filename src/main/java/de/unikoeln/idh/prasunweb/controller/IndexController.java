package de.unikoeln.idh.prasunweb.controller;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import de.unikoeln.idh.prasunweb.model.Section;
import de.unikoeln.idh.prasunweb.service.section.SectionService;

@Controller
public class IndexController {

	@Autowired
	private SectionService sections;

	@RequestMapping({ "/home", "/start" })
	public ModelAndView getHomepage() {
		return new ModelAndView("home");
	}

	@RequestMapping(value = "/book")
	public ModelAndView bookview() {
		return new ModelAndView("book");
	}

	@GetMapping({ "/test" })
	public ModelAndView test(@RequestParam String id) {
		ModelAndView mv = new ModelAndView("test");
		mv.addObject("section", this.sections.getOneById(Integer.parseInt(id)));
		return mv;
	}

}
