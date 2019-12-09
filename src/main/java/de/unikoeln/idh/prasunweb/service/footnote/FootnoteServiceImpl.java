package de.unikoeln.idh.prasunweb.service.footnote;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import de.unikoeln.idh.prasunweb.model.Footnote;
import de.unikoeln.idh.prasunweb.repository.FootnoteRepository;

@Component
@Transactional
public class FootnoteServiceImpl implements FootnoteService {

    private final FootnoteRepository footnotes;

    public FootnoteServiceImpl(FootnoteRepository footnotes) {
        this.footnotes = footnotes;
    }

    @Override
    public List<Footnote> getAll() {
        return footnotes.findAll();
    }

    @Override
    public Page<Footnote> getAll(Pageable pageable) {
        return footnotes.findAll(pageable);
    }

    @Override
    public Footnote getOneById(Integer footnoteId) {
        return footnotes.findOneById(footnoteId);
    }

    @Override
    public Footnote save(Footnote footnote) {
        return footnotes.save(footnote);
    }

    @Override
    public Long count() {
        return footnotes.count();
    }

    public Boolean existsById(Integer footnoteId) {
        return (footnoteId != null && getOneById(footnoteId) != null);
    }

}
