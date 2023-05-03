package  ma.zyn.easystock.dao.specification.history;

import ma.zyn.easystock.zynerator.specification.AbstractHistorySpecification;
import ma.zyn.easystock.dao.criteria.history.PurchaseHistoryCriteria;
import ma.zyn.easystock.bean.history.PurchaseHistory;


public class PurchaseHistorySpecification extends AbstractHistorySpecification<PurchaseHistoryCriteria, PurchaseHistory> {

    public PurchaseHistorySpecification(PurchaseHistoryCriteria criteria) {
        super(criteria);
    }

    public PurchaseHistorySpecification(PurchaseHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
