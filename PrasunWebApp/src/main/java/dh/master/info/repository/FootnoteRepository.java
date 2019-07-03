package dh.master.info.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import dh.master.info.model.Footnote;
@Repository
public interface FootnoteRepository extends PagingAndSortingRepository<Footnote, Long> {

	
}
