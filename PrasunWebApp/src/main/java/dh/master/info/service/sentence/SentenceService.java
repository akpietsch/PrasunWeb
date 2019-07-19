package dh.master.info.service.sentence;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import dh.master.info.model.Sentence;

public interface SentenceService {

	public Long count();
	public Sentence save(Sentence sentence);
	public Sentence getOneById(Integer sentenceId);
	public List <Sentence> getAll();
	public Page<Sentence> getAll(Pageable pageable);
}
