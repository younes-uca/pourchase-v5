package  ma.zyn.easystock.dao.specification.history;

import ma.zyn.easystock.zynerator.specification.AbstractHistorySpecification;
import ma.zyn.easystock.dao.criteria.history.TagHistoryCriteria;
import ma.zyn.easystock.bean.history.TagHistory;


public class TagHistorySpecification extends AbstractHistorySpecification<TagHistoryCriteria, TagHistory> {

    public TagHistorySpecification(TagHistoryCriteria criteria) {
        super(criteria);
    }

    public TagHistorySpecification(TagHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
