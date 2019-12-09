package de.unikoeln.idh.prasunweb.model;

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
@Table(name = "books")
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Integer id;

    private String author;

    private String introduction;

    private String glossary;

    private String title;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Section> sections = new ArrayList<Section>();

    public Book(String author, String introduction, String glossary, String title) {
        this.author = author;
        this.introduction = introduction;
        this.glossary = glossary;
        this.title = title;
    }

    public Book addSections(Section... sections) {
        for (Section section : sections) {
            this.sections.add(section.setBook(this));
        }

        return this;
    }

}
