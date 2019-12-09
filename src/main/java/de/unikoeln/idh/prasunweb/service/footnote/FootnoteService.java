package de.unikoeln.idh.prasunweb.service.footnote;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import de.unikoeln.idh.prasunweb.model.Footnote;

public interface FootnoteService {

    public List<Footnote> getAll();

    public Page<Footnote> getAll(Pageable pageable);

    public Footnote getOneById(Integer footnoteId);

    public Footnote save(Footnote footnote);

    public Long count();

    public Boolean existsById(Integer footnoteId);

}
