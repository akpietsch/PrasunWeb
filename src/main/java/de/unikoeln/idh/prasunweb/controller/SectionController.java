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

import de.unikoeln.idh.prasunweb.model.Section;
import de.unikoeln.idh.prasunweb.model.Sentence;
import de.unikoeln.idh.prasunweb.service.section.SectionService;
import de.unikoeln.idh.prasunweb.service.sentence.SentenceService;

@Controller
@RequestMapping("/section")
public class SectionController {

    @Autowired
    private Environment env;

    @Autowired
    private SectionService sections;

    @Autowired
    private SentenceService sentences;

    @GetMapping("")
    public String index() {
        return "redirect:/";
    }

    @GetMapping("/{sectionId}")
    public String firstPage(@PathVariable("sectionId") Integer sectionId) {
        return "redirect:/section/" + sectionId + "/0";
    }

    @GetMapping("/{sectionId}/{page}")
    public ModelAndView listSectionSentences(@PathVariable("sectionId") Integer sectionId,
            @PathVariable("page") Integer page) {

        if (!this.sections.existsById(sectionId)) {
            throw new RuntimeException("Section doesn't exist");
        }

        ModelAndView mv = new ModelAndView("section");
        Section section = this.sections.getOneById(sectionId);
        Section partner = section.getSections().get(0);

        Pageable pageable = PageRequest.of(page, this.env.getProperty("prasunweb.paging.sections", Integer.class));
        Page<Sentence> sectionSentences = this.sentences.getAllBySection(pageable, section);
        Page<Sentence> partnerSentences = this.sentences.getAllBySection(pageable, partner);

        if (sectionSentences.getTotalPages() != partnerSentences.getTotalPages()) {
            throw new RuntimeException("Sections don't match");
        }

        mv.addObject("section", section);
        mv.addObject("partner", partner);
        mv.addObject("sectionSentences", sectionSentences);
        mv.addObject("partnerSentences", partnerSentences);
        return mv;
    }

}
