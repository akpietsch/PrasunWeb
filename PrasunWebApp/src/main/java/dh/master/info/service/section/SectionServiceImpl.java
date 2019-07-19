package dh.master.info.service.section;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import dh.master.info.model.Section;
import dh.master.info.repository.SectionRepository;

@Component
@Transactional
public class SectionServiceImpl implements SectionService {

	private final SectionRepository sections;

	public SectionServiceImpl(SectionRepository sections) {
		this.sections = sections;
	}

	@Override
	public Long count() {
		return sections.count();
	}

	@Override
	public Section save(Section section) {
		return sections.save(section);
	}

	@Override
	public Section getOneById(Integer sectionId) {

		return sections.findOneById(sectionId);
	}

	@Override
	public List<Section> getAll() {
		return sections.findAll();
	}

	@Override
	public Page<Section> getAll(Pageable pageable) {
		return sections.findAll(pageable);
	}

}
