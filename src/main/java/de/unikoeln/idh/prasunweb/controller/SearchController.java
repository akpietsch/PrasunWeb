package de.unikoeln.idh.prasunweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import de.unikoeln.idh.prasunweb.model.Sentence;
import de.unikoeln.idh.prasunweb.service.search.SearchService;
import de.unikoeln.idh.prasunweb.service.section.SectionService;

@Controller
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private Environment env;

    @Autowired
    private SearchService searchService;

    @Autowired
    private SectionService sections;

    @GetMapping("")
    public String index() {
        return "redirect:/";
    }

    @GetMapping("/{query}/{page}")
    public ModelAndView listSearchResult(@PathVariable("query") String query, @PathVariable("page") Integer page) {
        ModelAndView mv = new ModelAndView("test");

        // Section section = this.sections.getOneById(page);
        Pageable pageable = PageRequest.of(page, this.env.getProperty("prasunweb.paging.searchresults", Integer.class));

        Page<Sentence> searchResults = this.searchService.getAllSearchResultsByPage(query, pageable);
        // mv.addObject("section", section);
        mv.addObject("searchResults", searchResults);

        return mv;

    }

}
