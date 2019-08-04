package dh.master.info.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import dh.master.info.model.Sentence;

@Repository
public interface SentenceRepository extends PagingAndSortingRepository<Sentence, Integer> {

	public Sentence findOneById(Integer sentenceId);

	public List<Sentence> findAll();

	public Page<Sentence> findAll(Pageable pageable);

}
