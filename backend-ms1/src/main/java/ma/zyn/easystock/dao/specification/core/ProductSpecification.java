package  ma.zyn.easystock.dao.specification.core;

import ma.zyn.easystock.zynerator.specification.AbstractSpecificationEnhanced;
import ma.zyn.easystock.dao.criteria.core.ProductCriteria;
import ma.zyn.easystock.bean.core.Product;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ProductSpecification extends  AbstractSpecificationEnhanced<ProductCriteria, Product>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("reference", criteria.getReference(),criteria.getReferenceLike());
    }

    public ProductSpecification(ProductCriteria criteria) {
        super(criteria);
    }

    public ProductSpecification(ProductCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
