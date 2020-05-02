package de.unikoeln.idh.prasunweb.lucene;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.lucene.search.Query;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import de.unikoeln.idh.prasunweb.model.Book;
import de.unikoeln.idh.prasunweb.model.Footnote;
import de.unikoeln.idh.prasunweb.model.Section;
import de.unikoeln.idh.prasunweb.model.Sentence;

@SpringBootTest
@Transactional
@RunWith(SpringRunner.class)
public class LuceneIndexTest {

    @Autowired
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
	@Test
    public void testQueryIndex() {
        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);

        QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory()
                                                         .buildQueryBuilder()
                                                         .forEntity(Book.class)                                                        
                                                         .get();

        Query query = queryBuilder.keyword().onField("title").matching("1970").createQuery();

        FullTextQuery fullTextQuery = fullTextEntityManager.createFullTextQuery(query, Book.class, Section.class, Sentence.class, Footnote.class);

        List<Book> books = fullTextQuery.getResultList();
        for (Book book : books) {
            System.out.println(book.getTitle());

        }

    }
}
