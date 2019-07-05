package dh.master.info.service.work;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import dh.master.info.model.Work;

public interface WorkService {

	public Long count();

	public Work save(Work work);

	public Work getOneById(Integer workId);

	public List<Work> getAll();

	public Page<Work> getAll(Pageable pageable);

	public List<Work> search(String term);

	public Page<Work> search(Pageable pageable, String term);

	default public Boolean existsById(Integer workId) {
		return (workId != null && getOneById(workId) != null);
	}

}
