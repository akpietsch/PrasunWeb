package dh.master.info.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
@Table(name = "works")
public class Work implements Serializable {

	private static final long serialVersionUID = -4066191514208159663L;

	@Id
	@GeneratedValue
	private Integer id;

	@OneToMany(mappedBy = "work", cascade = CascadeType.ALL)
	private List<Section> sections;

	private String author;

	private String introduction;

	private String glossary;

	public Work(String author, String introduction, String glossary) {
		this.author = author;
		this.introduction = introduction;
		this.glossary = glossary;
	}

	public Work addSection(Section section) {
		if (section != null) {
			if (this.sections == null) {
				this.sections = new ArrayList<Section>();
			}

			this.sections.add(section.setWork(this));
		}

		return this;

	}

}
