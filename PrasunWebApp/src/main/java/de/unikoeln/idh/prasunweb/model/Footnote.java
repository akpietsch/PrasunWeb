package de.unikoeln.idh.prasunweb.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "footnotes")
public class Footnote implements Serializable {

	private static final long serialVersionUID = -5590869234980268995L;

	@Id
	@GeneratedValue
	private Integer id;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Sentence sentence;

	private int postition;

	private String source;

	private String target;

}