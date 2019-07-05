package dh.master.info.service.locale;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import dh.master.info.model.Locale;
import dh.master.info.repository.LocaleRepository;

@Component
@Transactional
public class LocaleServiceImpl implements LocaleService {

	private final LocaleRepository locales;
	
	public LocaleServiceImpl (LocaleRepository locales) {
		this.locales=locales;
	}
	
	@Override
	public Locale save(Locale locale) {
		return locales.save(locale);
	}

	@Override
	public List<Locale> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
