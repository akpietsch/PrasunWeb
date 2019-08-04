package de.unikoeln.idh.prasunweb.service.sentence;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import de.unikoeln.idh.prasunweb.model.Sentence;

public interface SentenceService {

	public Long count();
	public Sentence save(Sentence sentence);
	public Sentence getOneById(Integer sentenceId);
	public List <Sentence> getAll();
	public Page<Sentence> getAll(Pageable pageable);
}
