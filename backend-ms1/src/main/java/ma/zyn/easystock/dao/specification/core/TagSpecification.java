package  ma.zyn.easystock.dao.specification.core;

import ma.zyn.easystock.zynerator.specification.AbstractSpecificationEnhanced;
import ma.zyn.easystock.dao.criteria.core.TagCriteria;
import ma.zyn.easystock.bean.core.Tag;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class TagSpecification extends  AbstractSpecificationEnhanced<TagCriteria, Tag>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("reference", criteria.getReference(),criteria.getReferenceLike());
    }

    public TagSpecification(TagCriteria criteria) {
        super(criteria);
    }

    public TagSpecification(TagCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
