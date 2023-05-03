package  ma.zyn.easystock.dao.specification.history;

import ma.zyn.easystock.zynerator.specification.AbstractHistorySpecification;
import ma.zyn.easystock.dao.criteria.history.ClientCategoryHistoryCriteria;
import ma.zyn.easystock.bean.history.ClientCategoryHistory;


public class ClientCategoryHistorySpecification extends AbstractHistorySpecification<ClientCategoryHistoryCriteria, ClientCategoryHistory> {

    public ClientCategoryHistorySpecification(ClientCategoryHistoryCriteria criteria) {
        super(criteria);
    }

    public ClientCategoryHistorySpecification(ClientCategoryHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
