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

import de.unikoeln.idh.prasunweb.model.Book;
import de.unikoeln.idh.prasunweb.model.Section;
import de.unikoeln.idh.prasunweb.service.book.BookService;
import de.unikoeln.idh.prasunweb.service.section.SectionService;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private Environment env;

    @Autowired
    private BookService books;

    @Autowired
    private SectionService sections;

    @GetMapping("")
    public String index() {
        return "redirect:/";
    }

    @GetMapping("/{bookYear}")
    public String firstPage(@PathVariable("bookYear") String bookYear) {
        return "redirect:/book/" + bookYear + "/0";
    }

    @GetMapping("/{bookYear}/{page}")
    public ModelAndView listBookSections(@PathVariable("bookYear") String bookYear,
            @PathVariable("page") Integer page) {

        if (!this.books.existsByYear(bookYear)) {
            throw new RuntimeException("Book doesn't exist");
        }

        ModelAndView mv = new ModelAndView("book");
        Book book = this.books.getOneByYear(bookYear);

        Pageable pageable = PageRequest.of(page, this.env.getProperty("prasunweb.paging.sentences", Integer.class));
        Page<Section> sections = this.sections.getAllByBookAndLocale(pageable, book, "deu");

        mv.addObject("book", book);
        mv.addObject("bookYear", bookYear);
        mv.addObject("sections", sections);
        return mv;
    }

}
