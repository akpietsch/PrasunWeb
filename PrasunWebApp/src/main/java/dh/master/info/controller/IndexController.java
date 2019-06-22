package dh.master.info.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dh.master.info.data.Nuristani;
import dh.master.info.service.IndexService;
import dh.master.info.service.SearchService;


@Controller
@ControllerAdvice
public class IndexController {

	@Autowired
	SearchService searcher;
	
	@Autowired
	IndexService indexer;
	
	
	
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
	@RequestMapping(value="/bookview")
	public String submit(ModelAndView model,BindingResult result, Nuristani nuristani) {
		 if (result.hasErrors()) {
	            return "error";
	        }		
	
		model.addObject("heading", nuristani.getHeading());
		model.addObject("text",nuristani.getText());
		
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
