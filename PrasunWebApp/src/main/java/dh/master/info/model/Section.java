package dh.master.info.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "sections")
public class Section implements Serializable {

	private static final long serialVersionUID = 8407720903534196950L;

	@Id
	@GeneratedValue
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "work_id")
	private Work work;

	@OneToMany(mappedBy = "section", cascade = CascadeType.ALL)
	private List<Locale> locales;
	
	public Section() {
		
	}

	public Section(Integer id, List<Locale> locales) {
		super();
		this.id = id;
		this.locales = locales;
	}

	public Work getWork() {
		return work;
	}

	public void setWork(Work work) {
		this.work = work;
	}

	public Section(List<Locale> locales) {
		this.locales = locales;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Locale> getLocales() {
		return locales;
	}

	public void setLocales(List<Locale> locales) {
		this.locales = locales;
	}

}
