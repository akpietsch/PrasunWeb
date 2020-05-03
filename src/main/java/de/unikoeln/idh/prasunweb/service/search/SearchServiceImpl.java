package de.unikoeln.idh.prasunweb.service.search;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

import org.apache.lucene.search.Query;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.FatalBeanException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.orm.jpa.EntityManagerProxy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import de.unikoeln.idh.prasunweb.model.Sentence;

@Component
@Transactional
public class SearchServiceImpl implements SearchService {

    @Autowired
    private EntityManager entityManager;

    private EntityManagerProxy proxy;

    private FullTextEntityManager getFullTextEntityManager() {
        return Search.getFullTextEntityManager(proxy.getTargetEntityManager());
    }

    public Page<Sentence> searchTexts(String query, Pageable pageable) {
        FullTextEntityManager manager = this.getFullTextEntityManager();
        QueryBuilder builder = manager.getSearchFactory().buildQueryBuilder().forEntity(Sentence.class).get();

        Query luceneQuery = builder.keyword().fuzzy().onField("content").matching(query).createQuery();

        FullTextQuery fullTextQuery = manager.createFullTextQuery(luceneQuery, Sentence.class);
        fullTextQuery.setProjection(FullTextQuery.THIS, FullTextQuery.SCORE);

        long total = fullTextQuery.getResultSize();
        fullTextQuery.setFirstResult((int) pageable.getOffset()).setMaxResults(pageable.getPageSize());

        @SuppressWarnings("unchecked")
        List<Object[]> result = fullTextQuery.getResultList();
        List<Sentence> searchresult = new LinkedList<>();
        for (Object[] i : result) {
            searchresult.add((Sentence) i[0]);
        }
        return new PageImpl<Sentence>(searchresult, pageable, total);

    }

    @PostConstruct
    public void init() {
        if (!(this.entityManager instanceof EntityManagerProxy)) {
            throw new FatalBeanException("Entity Manager" + this.entityManager + " is not a proxy");
        }
        this.proxy = (EntityManagerProxy) this.entityManager;
    }


    @Override
    public Page<Sentence> getAllSearchResultsByPage(String query, Pageable pageable) {
        return this.searchTexts(query, pageable);
    }




}
