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
import javax.persistence.OneToOne;
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
@Table(name = "locales")
public class Locale implements Serializable {

	private static final long serialVersionUID = 8014050154361201346L;

	@Id
	@GeneratedValue
	private Integer id;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Section section;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Language language;

	@OneToOne
	@JoinColumn(nullable = false)
	private Sentence title;

	@OneToMany(mappedBy = "locale", cascade = CascadeType.ALL)
	private List<Sentence> content;


	public Locale addSentence(Sentence sentence) {
		if (sentence != null) {
			if (this.content == null) {
				this.content = new ArrayList<Sentence>();
			}
			this.content.add(sentence.setLocale(this));

		}
		return this;

	}
}
