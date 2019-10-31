package de.unikoeln.idh.prasunweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SampleController {

	@RequestMapping({ "/text01","/1956-01"})
	public ModelAndView getText1() {
		return new ModelAndView("prasuni/1956-1");
	}
	
	@RequestMapping({ "/text02","/1956-02"})
	public ModelAndView getText2() {
		return new ModelAndView("prasuni/1956-2");
	}
	
	@RequestMapping({ "/text03","/1956-03"})
	public ModelAndView getText3() {
		return new ModelAndView("prasuni/1956-3");
	}
	@RequestMapping({"/text04","/1956-04"})
	public ModelAndView getText4() {
		return new ModelAndView("prasuni/1956-4");
	}
	@RequestMapping({"/text05","/1956-05"})
	public ModelAndView getText5() {
		return new ModelAndView("prasuni/1956-5");
	}
	@RequestMapping({"/text06","/1970-01"})
	public ModelAndView getText6() {
		return new ModelAndView("prasuni/1970-1");
	}
	@RequestMapping({"/text07","/1970-02"})
	public ModelAndView getText7() {
		return new ModelAndView("prasuni/1970-2");
	}
	@RequestMapping({"/text08","/1970-03"})
	public ModelAndView getText8() {
		return new ModelAndView("prasuni/1970-3");
	}
	@RequestMapping({"/text09","/1970-04"})
	public ModelAndView getText9() {
		return new ModelAndView("prasuni/1970-4");
	}
	@RequestMapping({"/text10","/1970-05"})
	public ModelAndView getText10() {
		return new ModelAndView("prasuni/1970-5");
	}
	
	@RequestMapping("/travel-1956")
	public ModelAndView getIntroduction1() {
		return new ModelAndView("travel1956");
	}
	
	@RequestMapping("/travel-1970")
	public ModelAndView getIntroduction2() {
		return new ModelAndView("travel1970");
	}
	
}
