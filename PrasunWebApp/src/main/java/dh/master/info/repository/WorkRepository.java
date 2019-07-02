package dh.master.info.repository;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import dh.master.info.model.Work;
@Repository
public interface WorkRepository extends PagingAndSortingRepository<Work, Integer> {

	Work findOne(Integer id);
	
	List<Work> findAllByID (Integer id, Pageable pageable );

	Page<Work> findAll(Pageable pageable);
	

}
