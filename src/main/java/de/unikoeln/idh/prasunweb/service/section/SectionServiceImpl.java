package de.unikoeln.idh.prasunweb.service.section;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import de.unikoeln.idh.prasunweb.model.Book;
import de.unikoeln.idh.prasunweb.model.Section;
import de.unikoeln.idh.prasunweb.repository.SectionRepository;

@Component
@Transactional
public class SectionServiceImpl implements SectionService {

    private final SectionRepository sections;

    public SectionServiceImpl(SectionRepository sections) {
        this.sections = sections;
    }

    @Override
    public List<Section> getAll() {
        return sections.findAll();
    }

    @Override
    public Page<Section> getAll(Pageable pageable) {
        return sections.findAll(pageable);
    }

    @Override
    public Page<Section> getAllByBookAndLocale(Pageable pageable, Book book, String locale) {
        return sections.findAllByBookAndLocale(pageable, book, locale);
    }

    @Override
    public Section getOneById(Integer sectionId) {
        return sections.findOneById(sectionId);
    }

    @Override
    public Section save(Section section) {
        return sections.save(section);
    }

    @Override
    public Long count() {
        return sections.count();
    }

    @Override
    public boolean existsById(Integer sectionId) {
        return this.getOneById(sectionId) != null;
    }

}
