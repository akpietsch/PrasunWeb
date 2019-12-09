package de.unikoeln.idh.prasunweb.service.sentence;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import de.unikoeln.idh.prasunweb.model.Section;
import de.unikoeln.idh.prasunweb.model.Sentence;

public interface SentenceService {

    public List<Sentence> getAll();

    public Page<Sentence> getAll(Pageable pageable);

    public Page<Sentence> getAllBySection(Pageable pageable, Section section);

    public Sentence getOneById(Integer sentenceId);

    public Sentence save(Sentence sentence);

    public Long count();

}
