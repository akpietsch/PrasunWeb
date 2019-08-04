package dh.master.info.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import dh.master.info.model.Section;

@Repository
public interface SectionRepository extends PagingAndSortingRepository<Section, Integer> {

	public Section findOneById(Integer sectionId);

	public List<Section> findAll();

	public Page<Section> findAll(Pageable pageable);

}
