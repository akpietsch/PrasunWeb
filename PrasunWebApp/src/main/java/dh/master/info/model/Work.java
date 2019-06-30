package dh.master.info.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "Works")
@Table(name = "works")
public class Work implements Serializable {

	private static final long serialVersionUID = -2333662636408115444L;

	@Id
	@GeneratedValue
	@JsonIgnore
	private Integer id;
	private String author;

	@OneToMany(mappedBy = "work", cascade = CascadeType.ALL)
	private List<Title> titles;

	@OneToMany(mappedBy = "work", cascade = CascadeType.ALL)
	private List<Footnote> footnotes;

	public Work() {

	}

	public Work(List<Title> titles, List<Footnote> footnotes) {
		this.titles = titles;
		this.footnotes = footnotes;
	}

//	----> Setter & Getter
	
	public List<Title> getTitles() {
		return titles;
	}

	public void setTitles(List<Title> titles) {
		this.titles = titles;
	}

	public List<Footnote> getFootnotes() {
		return footnotes;
	}

	public void setFootnotes(List<Footnote> footnotes) {
		this.footnotes = footnotes;
	}

	public Integer getId() {
		return id;
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
