package de.unikoeln.idh.prasunweb.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import de.unikoeln.idh.prasunweb.model.Book;
import de.unikoeln.idh.prasunweb.model.Section;

@Repository
public interface SectionRepository extends PagingAndSortingRepository<Section, Integer> {

    public List<Section> findAll();

    public Page<Section> findAll(Pageable pageable);

    public Page<Section> findAllByBookAndLocale(Pageable pageable, Book book, String locale);

    public Section findOneById(Integer sectionId);

}
