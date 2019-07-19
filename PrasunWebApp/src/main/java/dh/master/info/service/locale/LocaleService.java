package dh.master.info.service.locale;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import dh.master.info.model.Locale;

public interface LocaleService {

	public Long count();

	public Locale save(Locale locale);

	public Locale getOneById(Integer localeId);

	public List<Locale> getAll();

	public Page<Locale> getAll(Pageable pageable);

	default public Boolean existsById(Integer localeId) {
		return (localeId != null && getOneById(localeId) != null);
	}

}
