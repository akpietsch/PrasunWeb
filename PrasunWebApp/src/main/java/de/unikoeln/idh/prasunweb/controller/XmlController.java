package de.unikoeln.idh.prasunweb.controller;
//package de.unikoeln.idh.prasunweb.controller;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import de.unikoeln.idh.prasunweb.model.Work;
//import de.unikoeln.idh.prasunweb.service.IndexService;
//
//@Controller
//@ControllerAdvice
//public class XmlController {
//
//	@Autowired
//	IndexService indexer;
//
//	Map<Integer, Work> workMap = new HashMap<Integer, Work>();
//
//	@RequestMapping(value = "/test", method = RequestMethod.GET)
//	public String showWorks(@ModelAttribute("work") Work doc, BindingResult result, Model model) {
//		if (result.hasErrors()) {
//			return "error";
//		}
//
//		model.addAttribute("head", doc.getTitles());
//		model.addAttribute("content", doc.getFootnotes());
//
//		return "test";
//	}
//
//}
