package de.unikoeln.idh.prasunweb.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import de.unikoeln.idh.prasunweb.model.Section;
import de.unikoeln.idh.prasunweb.model.Sentence;

@Repository
public interface SentenceRepository extends PagingAndSortingRepository<Sentence, Integer> {

    public List<Sentence> findAll();

    public Page<Sentence> findAll(Pageable pageable);

    public Page<Sentence> findAllBySection(Pageable pageable, Section section);

    public Sentence findOneById(Integer sentenceId);

}
