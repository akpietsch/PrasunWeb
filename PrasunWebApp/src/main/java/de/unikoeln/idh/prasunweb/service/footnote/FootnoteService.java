package de.unikoeln.idh.prasunweb.service.footnote;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import de.unikoeln.idh.prasunweb.model.Footnote;

public interface FootnoteService {

	public Long count();

	public Footnote save(Footnote footnote);

	public Footnote getOneById(Integer footnoteId);

	public List<Footnote> getAll();

	public Page<Footnote> getAll(Pageable pageable);

	default public Boolean existsById(Integer footnoteId) {
		return (footnoteId != null && getOneById(footnoteId) != null);
	}

}
