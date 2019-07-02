package dh.master.info.service.title;

import org.springframework.data.repository.PagingAndSortingRepository;

import dh.master.info.model.Work;

public interface TitleRepository extends PagingAndSortingRepository<Work, Long> {


}
