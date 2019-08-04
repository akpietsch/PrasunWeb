package dh.master.info.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)

@Entity
@Table(name = "sentences")
public class Sentence implements Serializable {

	private static final long serialVersionUID = -8886043628545653675L;

	@Id
	@GeneratedValue
	private Integer id;

	@ManyToOne
	@JoinColumn
	private Section section;

	@OneToMany(mappedBy = "sentence", cascade = CascadeType.ALL)
	private List<Footnote> footnotes = new ArrayList<Footnote>();

	private String content;

	public Sentence addFootnote(Footnote... footnotes) {
		for (Footnote footnote : footnotes) {
			this.footnotes.add(footnote.setSentence(this));
		}

		return this;
	}

}
