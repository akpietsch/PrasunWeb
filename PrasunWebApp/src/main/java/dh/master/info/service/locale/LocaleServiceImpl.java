package dh.master.info.service.locale;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import dh.master.info.model.Locale;
import dh.master.info.repository.LocaleRepository;

@Component
@Transactional
public class LocaleServiceImpl implements LocaleService {

	private final LocaleRepository locales;

	public LocaleServiceImpl(LocaleRepository locales) {
		this.locales = locales;
	}

	@Override
	public Long count() {
		return locales.count();
	}

	@Override
	public Locale save(Locale locale) {
		return locales.save(locale);
	}

	@Override
	public Locale getOneById(Integer workId) {
		return locales.findOneById(workId);
	}

	@Override
	public List<Locale> getAll() {
		return locales.findAll();
	}

	@Override
	public Page<Locale> getAll(Pageable pageable) {
		return locales.findAll(pageable);
	}

}
