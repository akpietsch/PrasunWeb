package de.unikoeln.idh.prasunweb.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import de.unikoeln.idh.prasunweb.model.Sentence;

@Repository
public interface SentenceRepository extends PagingAndSortingRepository<Sentence, Integer> {

	public Sentence findOneById(Integer sentenceId);

	public List<Sentence> findAll();

	public Page<Sentence> findAll(Pageable pageable);

}
