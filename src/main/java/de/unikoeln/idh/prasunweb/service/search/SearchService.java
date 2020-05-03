package de.unikoeln.idh.prasunweb.service.search;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import de.unikoeln.idh.prasunweb.model.Sentence;

public interface SearchService {
        public Page<Sentence> getAllSearchResultsByPage(String query, Pageable pageable);

}
