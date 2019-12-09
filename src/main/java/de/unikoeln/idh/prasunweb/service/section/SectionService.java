package de.unikoeln.idh.prasunweb.service.section;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import de.unikoeln.idh.prasunweb.model.Book;
import de.unikoeln.idh.prasunweb.model.Section;

public interface SectionService {

    public List<Section> getAll();

    public Page<Section> getAll(Pageable pageable);

    public Page<Section> getAllByBookAndLocale(Pageable pageable, Book book, String locale);

    public Section getOneById(Integer sectionId);

    public Section save(Section section);

    public Long count();

    public boolean existsById(Integer sectionId);

}
