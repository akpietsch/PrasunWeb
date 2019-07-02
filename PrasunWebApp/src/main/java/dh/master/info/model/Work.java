package dh.master.info.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "works")
public class Work implements Serializable {

	private static final long serialVersionUID = -2333662636408115444L;

	@Id
	@Column(name = "work_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	String author;
	String introduction;
	private String glossary;

	@OneToMany(mappedBy = "work", cascade = CascadeType.ALL)
	private List<Section> sections;

	public Work() {

	}

	public Work(Integer id, String author, String introduction, String glossary, List<Section> sections) {
		super();
		this.id = id;
		this.author = author;
		this.introduction = introduction;
		this.glossary = glossary;
		this.sections = sections;
	}

	public Integer getId() {
		return id;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getGlossary() {
		return glossary;
	}

	public void setGlossary(String glossary) {
		this.glossary = glossary;
	}

	public List<Section> getParagraphs() {
		return sections;
	}

	public void setParagraphs(List<Section> sections) {
		this.sections = sections;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}
