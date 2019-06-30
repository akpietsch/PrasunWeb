package dh.master.info.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "Sentences")
@Table(name = "sentences")
public class Sentence extends Title implements Serializable {
	
	private static final long serialVersionUID = 6517072584087211218L;

	@Id
	@GeneratedValue
	private Long id;

	private String content;

	@ManyToOne
	@JoinColumn(name = "titleID")
	private Title title;

	@OneToMany
	@Column(nullable = false)
	private String language;

	public Sentence() {

	}

	public Sentence(Title title, String language) {
		this.title = title;
		this.language = language;
	}

//---->Setter& Getter
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean hasId() {
		return (id != null && id > 0);
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Boolean hasContent() {
		return (content != null && id > 0);
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

}
