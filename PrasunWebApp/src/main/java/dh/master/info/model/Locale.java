package dh.master.info.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "locales")
public class Locale implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Integer id;
	@ManyToOne
	private Section section;

	@OneToOne
	private Language lang;

	@ManyToMany
	private List<Sentence> content;
	private Sentence title;

	public Section getParagraph() {
		return section;
	}

	public void setParagraph(Section section) {
		this.section = section;
	}

	public Language getLang() {
		return lang;
	}

	public void setLang(Language lang) {
		this.lang = lang;
	}

	public Sentence getTitle() {
		return title;
	}

	public void setTitle(Sentence title) {
		this.title = title;
	}

	public List<Sentence> getContent() {
		return content;
	}

	public void setContent(List<Sentence> content) {
		this.content = content;
	}

	public Language getLanguage(String language) {
		switch (language) {
		case "de":
			return Language.GERMAN;
		case "prn":
			return Language.Prasun;
		default:
			return Language.WILDCARD;
		}
}
}
