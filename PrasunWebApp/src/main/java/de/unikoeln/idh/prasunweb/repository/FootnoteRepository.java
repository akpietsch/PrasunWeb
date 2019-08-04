package de.unikoeln.idh.prasunweb.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import de.unikoeln.idh.prasunweb.model.Footnote;

//PAging and S
@Repository
public interface FootnoteRepository extends PagingAndSortingRepository<Footnote, Integer> {

	public List<Footnote> findAll();

	public Page<Footnote> findAll(Pageable pageable);

	public Footnote findOneById(Integer footnoteId);

}
