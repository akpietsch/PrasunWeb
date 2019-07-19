package dh.master.info.service.sentence;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import dh.master.info.model.Sentence;
import dh.master.info.repository.SentenceRepository;

@Component
@Transactional
public class SentenceServiceImpl implements SentenceService {

	private final SentenceRepository sentences;

	public SentenceServiceImpl(SentenceRepository sentences) {
		this.sentences = sentences;
	}

	@Override
	public Long count() {
		return sentences.count();
	}

	@Override
	public Sentence save(Sentence sentence) {
		return sentences.save(sentence);
	}

	@Override
	public Sentence getOneById(Integer sentenceId) {

		return sentences.findOneById(sentenceId);
	}

	@Override
	public List<Sentence> getAll() {
		return sentences.findAll();
	}

	@Override
	public Page<Sentence> getAll(Pageable pageable) {
		return sentences.findAll(pageable);
	}

}
