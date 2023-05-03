package ma.zyn.easystock.service.impl.admin;

import ma.zyn.easystock.bean.core.Product;
import ma.zyn.easystock.bean.history.ProductHistory;
import ma.zyn.easystock.dao.criteria.core.ProductCriteria;
import ma.zyn.easystock.dao.criteria.history.ProductHistoryCriteria;
import ma.zyn.easystock.dao.facade.core.ProductDao;
import ma.zyn.easystock.dao.facade.history.ProductHistoryDao;
import ma.zyn.easystock.dao.specification.core.ProductSpecification;
import ma.zyn.easystock.service.facade.admin.ProductAdminService;
import ma.zyn.easystock.zynerator.service.AbstractServiceImpl;
import ma.zyn.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;





import java.util.List;
@Service
public class ProductAdminServiceImpl extends AbstractServiceImpl<Product,ProductHistory, ProductCriteria, ProductHistoryCriteria, ProductDao,
ProductHistoryDao> implements ProductAdminService {

    public Long getNextOrdre() {
    Long max = dao.findMaxOrdreByEtablissementIdOrder(getEtablissementId());
    return max != null ? max + 1 : 1;
    }

    @Cacheable(cacheNames = "products")
    public List<Product> findAll() {
        return super.findAll();
    }

    @CachePut(cacheNames = "products", key = "#t.id")
    public Product create(Product t) {
        return super.create(t);
    }

    @CachePut(cacheNames = "products", key = "#t.id")
    public Product update(Product t) {
        return super.update(t);
    }

    @Cacheable(cacheNames = "products", key = "#id")
    public Product findById(Long id) {
        return super.findById(id);
    }

    @CacheEvict(cacheNames = "products", key = "#id")
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    public Product findByReferenceEntity(Product t){
        return  dao.findByCode(t.getCode());
    }


    public void configure() {
        super.configure(Product.class,ProductHistory.class, ProductHistoryCriteria.class, ProductSpecification.class);
    }

    public ProductAdminServiceImpl(ProductDao dao, ProductHistoryDao historyDao) {
        super(dao, historyDao);
    }

}