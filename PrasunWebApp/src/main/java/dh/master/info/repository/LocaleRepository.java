package dh.master.info.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dh.master.info.model.Locale;
import dh.master.info.model.Work;

@Repository
public interface LocaleRepository extends CrudRepository<Work, Integer> {
	
	public Locale findOneById(Integer localeId);
	public Page<Locale> findAll(Pageable pageable);
	public Locale save(Locale locale);

}
