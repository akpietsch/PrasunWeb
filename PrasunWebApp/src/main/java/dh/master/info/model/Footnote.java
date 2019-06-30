package dh.master.info.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity(name = "Footnotes")
@Table(name = "footnotes")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Footnote implements Serializable {
	private static final long serialVersionUID = -5590869234980268995L;

	@Id
	@GeneratedValue
	@JsonIgnore
	private Integer id;
	private String ftnText;
	private String position;

	

	@ManyToOne
	@JoinColumn(name = "workID", nullable = false)
	private Work work;

	public Footnote() {

	}

// -->Position
	public String getPosition() {
		return position;
	}

	public Footnote setPosition(String position) {
		this.position = position;
		return this;
	}

	public Boolean hasPosition() {
		return (position != null && !position.isEmpty());
	}

//--> Werk
	public Work getWork() {
		return work;
	}

	public Footnote setWork(Work work) {
		this.work = work;
		return this;
	}

//-->ID
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean hasId() {
		return (id != null && id > 0);
	}

//--> Footnote Text
	public String getFtnText() {
		return ftnText;
	}

	public Footnote setFtnText(String ftnText) {
		this.ftnText = ftnText;
		return this;
	}

	public Boolean hasFtnText() {
		return (ftnText != null && !ftnText.isEmpty());
	}

}
