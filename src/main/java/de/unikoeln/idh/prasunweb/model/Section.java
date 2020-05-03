package de.unikoeln.idh.prasunweb.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)

@Entity
@Indexed
@Table(name = "sections")
public class Section implements Serializable {

    private static final long serialVersionUID = 2L;

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(nullable = false)
    private Book book;

    @Field// ISO 639-3 Language Code ("prn"/"deu")
    private String locale;

    @ManyToMany()
    @JoinTable()
    private List<Section> sections = new ArrayList<Section>();

    @OneToOne(cascade = CascadeType.ALL)
    private Sentence title;

    @OneToMany(mappedBy = "section", cascade = CascadeType.ALL)
    private List<Sentence> sentences = new ArrayList<Sentence>();

    public Section addSentences(Sentence... sentences) {
        for (Sentence sentence : sentences) {
            this.sentences.add(sentence.setSection(this));
        }

        return this;
    }

}