package dh.master.info.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "languages")

public class Language implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer id;
	@OneToOne
	private Locale locale;

	public static final Language GERMAN = null;

	public static final Language Prasun = null;

	public static final Language WILDCARD = null;

}
