package dh.master.info.model;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface WorkRepository extends PagingAndSortingRepository<Work, Integer> {

	public Work findByID(Integer docID);

	public List <Work> findByTitle();
	
	public List <Work> findAll();
	
	
	
	

}
