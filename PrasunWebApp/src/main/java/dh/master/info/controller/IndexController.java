package dh.master.info.controller;

import java.io.IOException;
import java.util.List;

import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.highlight.InvalidTokenOffsetsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import dh.master.info.data.Nuristani;
import dh.master.info.service.SearchService;


@Controller
public class IndexController {

	@Autowired
	SearchService searcher;
	
	
	@GetMapping("/home")
	public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
			Model model) {
		model.addAttribute("name", name);
		
		
		return "home";
	}
	
	@RequestMapping(value = "/texts")
	public ModelAndView person() {
		
		
		return new ModelAndView("texts");
	}
	
	

	
//	@RequestMapping(value="/bookview/heading{id}", method=RequestMethod.GET)
	@GetMapping("/bookview")
	public String prasText1(Model model, Nuristani result) {
			
	
		model.addAttribute("heading", result.heading);
		model.addAttribute("text",result.text);
		
	    return "bookview";
	}
	
	@RequestMapping(value = "/header")
	public ModelAndView getHeader() {
		return new ModelAndView("header");
	}
	
	@RequestMapping(value = "/footer")
	public ModelAndView getFooter() {
		return new ModelAndView("footer");
	}
	@RequestMapping(value = "/search") 
	public String search(Model model) {
		return "search";
	}
	
//	@ResponseBody
//	@RequestMapping(value = "/searchResult")
//	public String result(@RequestParam("searchPhrase") String searchPhrase,
//			@RequestParam(value="page") Integer page,		
//			Model model)
//			throws ParseException, InvalidTokenOffsetsException, IOException {
//
//			List<SearchResult> resultList = null;
//			page = page == null ? 1 : page;
//
//		resultList = searcher.search(searchPhrase);
//
//		String resultString = "";
//		for(SearchResult result: resultList) {
//			resultString += result.getTitle();
//		}
//
//		return resultString;
//	}


	public SearchService getSearcher() {
		return searcher;
	}
	public void setSearchService(SearchService searcher) {
		this.searcher = searcher;
	}


}
