package de.unikoeln.idh.prasunweb.controller.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import de.unikoeln.idh.prasunweb.model.Footnote;
import de.unikoeln.idh.prasunweb.model.Section;
import de.unikoeln.idh.prasunweb.model.Sentence;
import de.unikoeln.idh.prasunweb.model.Work;
import de.unikoeln.idh.prasunweb.service.work.WorkService;

@Controller
public class WorkController {

	@Autowired
	private WorkService works;

	@GetMapping("/list")
	public ModelAndView list(Pageable pageable) {
		ModelAndView mv = new ModelAndView("test");
		Page<Work> page = works.getAll(pageable);
		mv.addObject("page", page);
		page.getContent();
		return mv;
	}

	@GetMapping("/view")
	public ModelAndView view(@RequestParam(name = "workId") Integer workId) {
		ModelAndView mv = new ModelAndView("backend/work/view");

		mv.addObject("work", works.getOneById(workId));
		return mv;
	}

	@GetMapping("/test")
	public String test() {
		Sentence title = new Sentence();
		title.setContent("This is a Title");
	
		Footnote footnote = new Footnote();
		footnote.setSource("Zwei");
		footnote.setTarget("Two");

		Sentence sentence = new Sentence();
		sentence.setContent("Content Sentence");
		sentence.addFootnote(footnote);

		Section section = new Section();
		section.setTitle(title);
		section.addSentences(sentence);
		section.setLocale("eng");

		Work work = new Work();
		work.setAuthor("author");
		work.setGlossary("gloss");
		work.setIntroduction("intro");
		work.addSections(section);

		works.save(work);

		return "redirect:/list";
	}

}
