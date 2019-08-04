package dh.master.info.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import dh.master.info.model.Work;

@Repository
public interface WorkRepository extends PagingAndSortingRepository<Work, Integer> {

	public Work findOneById(Integer workId);

	public List<Work> findAll();

	public Page<Work> findAll(Pageable pageable);

}
