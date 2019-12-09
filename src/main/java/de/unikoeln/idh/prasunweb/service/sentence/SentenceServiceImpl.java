package de.unikoeln.idh.prasunweb.service.sentence;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import de.unikoeln.idh.prasunweb.model.Section;
import de.unikoeln.idh.prasunweb.model.Sentence;
import de.unikoeln.idh.prasunweb.repository.SentenceRepository;

@Component
@Transactional
public class SentenceServiceImpl implements SentenceService {

    private final SentenceRepository sentences;

    public SentenceServiceImpl(SentenceRepository sentences) {
        this.sentences = sentences;
    }

    @Override
    public List<Sentence> getAll() {
        return sentences.findAll();
    }

    @Override
    public Page<Sentence> getAll(Pageable pageable) {
        return sentences.findAll(pageable);
    }

    @Override
    public Page<Sentence> getAllBySection(Pageable pageable, Section section) {
        return sentences.findAllBySection(pageable, section);
    }

    @Override
    public Sentence getOneById(Integer sentenceId) {
        return sentences.findOneById(sentenceId);
    }

    @Override
    public Sentence save(Sentence sentence) {
        return sentences.save(sentence);
    }

    @Override
    public Long count() {
        return sentences.count();
    }

}
