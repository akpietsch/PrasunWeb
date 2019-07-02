package dh.master.info.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

	@RequestMapping(value = "/search")
	public String search(Model model) {
		return "search";
	}

	@RequestMapping({ "/0001", "/Text-1" })
	public String test(Model model) {
		return "prasuni/0001 Text 01";
	}

	@RequestMapping({ "/0002", "/Disnis-Gang-zum-Eisgeist" })
	public String text2(Model model) {
		return "prasuni/0002 Disnis Gang zum Eisgeist";
	}

	@RequestMapping({ "/0003", "/Preislied-auf-einen-Verdienstfestgeber" })
	public String text3(Model model) {
		return "prasuni/0003 Text 3 Preislied auf einen Verdienstfestgeber";
	}

	@RequestMapping({ "/0004", "/Eheschluss-bei-den-Kafiren" })
	public String text4(Model model) {
		return "prasuni/0004 Text 4 Eheschluss bei den Kafiren";
	}

	@RequestMapping({ "/0005", "/Güšünǰog" })
	public String text5(Model model) {
		return "prasuni/0005 Text 5 Güšünǰog";
	}

	@RequestMapping({ "/0006", "/Text-6" })
	public String text6(Model model) {
		return "prasuni/0006 Text 6 Die treulosen Wesire";
	}

	@RequestMapping({ "/0007", "/Text-7" })
	public String text7(Model model) {
		return "prasuni/0001 Text";
	}

	@RequestMapping({ "/0008", "/Text-8" })
	public String test8(Model model) {
		return "prasuni/0008 Text 8 Ein Gang in die Unterwelt";
	}

	@RequestMapping({ "/0009", "/Text-9" })
	public String test9(Model model) {
		return "prasuni/0009 Text 9";
	}

}
