package dh.master.info.service.locale;

import java.util.List;

import dh.master.info.model.Locale;

public interface LocaleService {
	
	public Locale save(Locale locale);
	
	public List<Locale> getAll();


}
