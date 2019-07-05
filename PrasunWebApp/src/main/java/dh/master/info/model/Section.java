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
@Table(name = "sections")
public class Section implements Serializable {

	private static final long serialVersionUID = 8407720903534196950L;

	@Id
	@GeneratedValue
	private Integer id;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "work_id", nullable = false)
	private Work work;

	@OneToMany(mappedBy = "section", cascade = CascadeType.ALL)
	private List<Locale> locales;

	public Section(Integer id, List<Locale> locales) {
		this.id = id;
		this.locales = locales;
	}

	public Section addLocale(Locale locale) {
		if (locale != null) {
			if (this.locales == null) {
				this.locales = new ArrayList<Locale>();
			}

			this.locales.add(locale.setSection(this));
		}

		return this;
	
}
}
