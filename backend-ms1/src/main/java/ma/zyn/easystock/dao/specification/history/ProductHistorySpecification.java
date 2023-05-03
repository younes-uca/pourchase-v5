package  ma.zyn.easystock.dao.specification.history;

import ma.zyn.easystock.zynerator.specification.AbstractHistorySpecification;
import ma.zyn.easystock.dao.criteria.history.ProductHistoryCriteria;
import ma.zyn.easystock.bean.history.ProductHistory;


public class ProductHistorySpecification extends AbstractHistorySpecification<ProductHistoryCriteria, ProductHistory> {

    public ProductHistorySpecification(ProductHistoryCriteria criteria) {
        super(criteria);
    }

    public ProductHistorySpecification(ProductHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
