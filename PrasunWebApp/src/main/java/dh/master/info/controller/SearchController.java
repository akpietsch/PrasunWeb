package dh.master.info.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import dh.master.info.service.SearchService;
@Controller
public class SearchController {
	

	@Autowired
	SearchService searcher;
	
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
