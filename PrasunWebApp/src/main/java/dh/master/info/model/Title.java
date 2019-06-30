package dh.master.info.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "Titles")
@Table(name = "titles")
public class Title implements Serializable {

	private static final long serialVersionUID = 8407720903534196950L;

	@Id
	@GeneratedValue
	private Long id;
	private String language;

	@OneToOne
	@JoinColumn(name = "workID")
	private Work work;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Sentence> sentences;

	public Title() {
	}

	public Title(List<Sentence> sentences, String language) {
		this.sentences = sentences;
		this.language = language;
	}

	//------------> Getter and Setter
	public Work getWork() {
		return work;
	}

	public void setWork(Work work) {
		this.work = work;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Sentence> getSentences() {
		return sentences;
	}

	public void setSentences(List<Sentence> sentences) {
		this.sentences = sentences;
	}
}
