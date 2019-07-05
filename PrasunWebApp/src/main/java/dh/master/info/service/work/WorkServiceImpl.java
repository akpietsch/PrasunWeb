package dh.master.info.service.work;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import dh.master.info.model.Work;
import dh.master.info.repository.WorkRepository;

@Component
@Transactional
public class WorkServiceImpl implements WorkService {

	private final WorkRepository works;

	public WorkServiceImpl(WorkRepository works) {
		this.works = works;
	}

	@Override
	public Long count() {
		return works.count();
	}

	@Override
	public Work save(Work work) {
		return works.save(work);
	}

	@Override
	public Work getOneById(Integer workId) {
		return works.findOneById(workId);
	}

	@Override
	public List<Work> getAll() {
		return works.findAll();
	}

	@Override
	public Page<Work> getAll(Pageable pageable) {
		return works.findAll(pageable);
	}

	@Override
	public List<Work> search(String term) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Work> search(Pageable pageable, String term) {
		// TODO Auto-generated method stub
		return null;
	}

}