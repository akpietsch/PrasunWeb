package de.unikoeln.idh.prasunweb.service.book;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import de.unikoeln.idh.prasunweb.model.Book;

public interface BookService {

    public List<Book> getAll();

    public Page<Book> getAll(Pageable pageable);

    public Book getOneById(Integer bookId);

    public Book getOneByYear(String year);

    public Book save(Book book);

    public Long count();

    public Boolean existsById(Integer bookId);

    public Boolean existsByYear(String year);

}
