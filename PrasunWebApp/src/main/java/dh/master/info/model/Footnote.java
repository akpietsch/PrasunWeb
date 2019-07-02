package dh.master.info.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "footnotes")

public class Footnote implements Serializable {
	private static final long serialVersionUID = -5590869234980268995L;

	@Id
	@GeneratedValue
	private Integer id;
	private String startString ;
	private String resultString;
	private int postition;

	

	private Sentence sentence;
	
	
	public Footnote() {

	}
	
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getStartString() {
		return startString;
	}


	public void setStartString(String startString) {
		this.startString = startString;
	}


	public String getResultString() {
		return resultString;
	}


	public void setResultString(String resultString) {
		this.resultString = resultString;
	}


	public int getPostition() {
		return postition;
	}


	public void setPostition(int postition) {
		this.postition = postition;
	}


	public Sentence getSentence() {
		return sentence;
	}


	public void setSentence(Sentence sentence) {
		this.sentence = sentence;
	}





	

}
