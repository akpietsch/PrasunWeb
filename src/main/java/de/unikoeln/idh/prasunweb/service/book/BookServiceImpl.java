package de.unikoeln.idh.prasunweb.service.book;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import de.unikoeln.idh.prasunweb.model.Book;
import de.unikoeln.idh.prasunweb.repository.BookRepository;

@Component
@Transactional
public class BookServiceImpl implements BookService {

    private final BookRepository books;

    public BookServiceImpl(BookRepository books) {
        this.books = books;
    }

    @Override
    public List<Book> getAll() {
        return books.findAll();
    }

    @Override
    public Page<Book> getAll(Pageable pageable) {
        return books.findAll(pageable);
    }

    @Override
    public Book getOneById(Integer bookId) {
        return books.findOneById(bookId);
    }

    @Override
    public Book getOneByYear(String year) {
        return books.findOneByTitleEndingWith(year);
    }

    @Override
    public Book save(Book book) {
        return books.save(book);
    }

    @Override
    public Long count() {
        return books.count();
    }

    public Boolean existsById(Integer bookId) {
        return (bookId != null && getOneById(bookId) != null);
    }

    public Boolean existsByYear(String year) {
        return (year != null && !year.isEmpty() && getOneByYear(year) != null);
    }

}
