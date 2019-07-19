package dh.master.info.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dh.master.info.model.Footnote;

@Repository
public interface FootnoteRepository extends CrudRepository<Footnote, Integer> {

	public List<Footnote> findAll();

	public Page<Footnote> findAll(Pageable pageable);

	public Footnote findOneById(Integer footnoteId);
}
