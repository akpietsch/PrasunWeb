package dh.master.info.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dh.master.info.model.Language;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Integer> {

	public Language findOneById(Integer languageId);
	
	public List<Language> findAll();
	
	public Page<Language> findAll(Pageable pageable);

}
