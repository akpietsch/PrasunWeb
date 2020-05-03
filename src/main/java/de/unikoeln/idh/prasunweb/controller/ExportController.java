package de.unikoeln.idh.prasunweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import de.unikoeln.idh.prasunweb.model.Book;
import de.unikoeln.idh.prasunweb.model.Section;
import de.unikoeln.idh.prasunweb.service.book.BookService;
import de.unikoeln.idh.prasunweb.service.section.SectionService;

@Controller
@RequestMapping("/export")
public class ExportController {

	@Autowired
	private BookService books;

	@Autowired
	private SectionService sections;

	@GetMapping("/book/{bookYear}")
	public @ResponseBody Book exportBook(@PathVariable("bookYear") String bookYear) {

		if (!this.books.existsByYear(bookYear)) {
			throw new RuntimeException("Book doesn't exist");
		}

		return this.books.getOneByYear(bookYear);
	}

	@GetMapping("/section/{sectionId}")
	public @ResponseBody Section listSectionSentences(@PathVariable("sectionId") Integer sectionId) {

		if (!this.sections.existsById(sectionId)) {
			throw new RuntimeException("Section doesn't exist");
		}

		return this.sections.getOneById(sectionId);
	}

}
