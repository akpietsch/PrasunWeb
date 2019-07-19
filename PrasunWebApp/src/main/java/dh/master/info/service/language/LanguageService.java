package dh.master.info.service.language;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import dh.master.info.model.Language;



public interface LanguageService {

	public Long count();

	public Language save(Language language);

	public Language getOneById(Integer languageId);

	public List<Language> getAll();

	public Page<Language> getAll(Pageable pageable);

	default public Boolean existsById(Integer languageId) {
		return (languageId != null && getOneById(languageId) != null);
	}

}
