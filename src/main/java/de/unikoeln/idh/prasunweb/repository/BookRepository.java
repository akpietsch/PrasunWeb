package de.unikoeln.idh.prasunweb.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import de.unikoeln.idh.prasunweb.model.Book;

@Repository
public interface BookRepository extends PagingAndSortingRepository<Book, Integer> {

    public List<Book> findAll();

    public Page<Book> findAll(Pageable pageable);

    public Book findOneById(Integer bookId);

    public Book findOneByTitleEndingWith(String year);

}
