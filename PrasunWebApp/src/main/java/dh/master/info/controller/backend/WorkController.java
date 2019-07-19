//package dh.master.info.controller.backend;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;
//
//import dh.master.info.model.Footnote;
//import dh.master.info.model.Language;
//import dh.master.info.model.Locale;
//import dh.master.info.model.Section;
//import dh.master.info.model.Sentence;
//import dh.master.info.model.Work;
//import dh.master.info.service.work.WorkService;
//
//@Controller
//public class WorkController {
//
//	@Autowired
//	private WorkService works;
//
//	@GetMapping("/list")
//	public ModelAndView list(Pageable pageable) {
//		ModelAndView mv = new ModelAndView("test");
//		Page<Work> page = works.getAll(pageable);
//
//		Work work = new Work();
//		work.setAuthor("author");
//		work.setGlossary("gloss");
//		work.setIntroduction("intro");
//
//		Section section = new Section();
//		work.addSection(section);
//
//		Language language = new Language();
//		language.setCode("en");
//		language.setTitle("English");
//
//		Locale locale = new Locale();
//		section.addLocale(locale);
//
//		Sentence title = new Sentence();
//		title.setContent("Title");
//
//		locale.setSection(section);
//		locale.setTitle(title);
//
//		Sentence sentence = new Sentence();
//		sentence.setContent("Content Sentence");
//		sentence.setLocale(locale);
//
//		Footnote footnote = new Footnote();
//		footnote.setSource("Zwei");
//		footnote.setTarget("Two");
//		footnote.setSentence(sentence);
//
//		works.save(work);
//
//		mv.addObject("page", page);
//		mv.addObject("author", work.getAuthor());
//		return mv;
//	}
//
//	@GetMapping("/view")
//	public ModelAndView view(@RequestParam(name = "workId") Integer workId) {
//		ModelAndView mv = new ModelAndView("backend/work/view");
//
//		mv.addObject("work", works.getOneById(workId));
//		return mv;
//	}
//
//}
