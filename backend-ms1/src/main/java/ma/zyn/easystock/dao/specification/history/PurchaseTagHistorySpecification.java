package  ma.zyn.easystock.dao.specification.history;

import ma.zyn.easystock.zynerator.specification.AbstractHistorySpecification;
import ma.zyn.easystock.dao.criteria.history.PurchaseTagHistoryCriteria;
import ma.zyn.easystock.bean.history.PurchaseTagHistory;


public class PurchaseTagHistorySpecification extends AbstractHistorySpecification<PurchaseTagHistoryCriteria, PurchaseTagHistory> {

    public PurchaseTagHistorySpecification(PurchaseTagHistoryCriteria criteria) {
        super(criteria);
    }

    public PurchaseTagHistorySpecification(PurchaseTagHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
