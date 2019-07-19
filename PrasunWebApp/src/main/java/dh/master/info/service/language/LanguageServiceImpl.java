package dh.master.info.service.language;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import dh.master.info.model.Language;
import dh.master.info.repository.LanguageRepository;

@Component
@Transactional
public class LanguageServiceImpl implements LanguageService {

	private final LanguageRepository languages;

	public LanguageServiceImpl(LanguageRepository languages) {
		this.languages = languages;

	}

	@Override
	public Long count() {
		return languages.count();
	}

	@Override
	public Language save(Language language) {
		return languages.save(language);
	}

	@Override
	public Language getOneById(Integer workId) {
		return languages.findOneById(workId);
	}

	@Override
	public List<Language> getAll() {
		return languages.findAll();
	}

	@Override
	public Page<Language> getAll(Pageable pageable) {
		return languages.findAll(pageable);
	}

}
