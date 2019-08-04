package de.unikoeln.idh.prasunweb.elasticsearch;
//package de.unikoeln.idh.prasunweb.elasticsearch;
//
//import org.elasticsearch.common.inject.Inject;
//import org.springframework.data.domain.Page;
//import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
//
//class ElasticsearchTemplateProducer {
//
//    @Produces
//    @ApplicationScoped
//    public ElasticsearchOperations createElasticsearchTemplate() {
//        return new ElasticsearchTemplate(nodeBuilder().local(true).node().client());
//    }
//}
//
//class ProductService {
//
//    private ProductRepository repository;
//
//    public Page<Product> findAvailableBookByName(String name, Pageable pageable) {
//        return repository.findByAvailableTrueAndNameStartingWith(name, pageable);
//    }
//
//    @Inject
//    public void setRepository(ProductRepository repository) {
//        this.repository = repository;
//    }
//}
//
