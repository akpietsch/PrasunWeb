package de.unikoeln.idh.prasunweb.service.section;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import de.unikoeln.idh.prasunweb.model.Section;

public interface SectionService {

	public Long count();

	public Section save(Section section);

	public Section getOneById(Integer sectionId);

	public List<Section> getAll();

	public Page<Section> getAll(Pageable pageable);

}
