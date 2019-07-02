package dh.master.info.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "sentences")
public class Sentence implements Serializable {

	private static final long serialVersionUID = -8886043628545653675L;

	@Id
	@GeneratedValue
	private Integer id;

	private String content;
	
	@ManyToMany
	List<Footnote> footnotes;
	


	public Sentence() {

	}



	public Sentence(Integer id, String content) {
		this.id=id;
		this.content=content;
	}

//---->Setter& Getter
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
	public List<Footnote> getFootnotes() {
		return footnotes;
	}

	public void setFootnotes(List<Footnote> footnotes) {
		this.footnotes = footnotes;
	}


}
