package ma.zyn.easystock.service.impl.admin;

import ma.zyn.easystock.bean.core.Tag;
import ma.zyn.easystock.bean.history.TagHistory;
import ma.zyn.easystock.dao.criteria.core.TagCriteria;
import ma.zyn.easystock.dao.criteria.history.TagHistoryCriteria;
import ma.zyn.easystock.dao.facade.core.TagDao;
import ma.zyn.easystock.dao.facade.history.TagHistoryDao;
import ma.zyn.easystock.dao.specification.core.TagSpecification;
import ma.zyn.easystock.service.facade.admin.TagAdminService;
import ma.zyn.easystock.zynerator.service.AbstractServiceImpl;
import ma.zyn.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;





import java.util.List;
@Service
public class TagAdminServiceImpl extends AbstractServiceImpl<Tag,TagHistory, TagCriteria, TagHistoryCriteria, TagDao,
TagHistoryDao> implements TagAdminService {

    public Long getNextOrdre() {
    Long max = dao.findMaxOrdreByEtablissementIdOrder(getEtablissementId());
    return max != null ? max + 1 : 1;
    }

    @Cacheable(cacheNames = "tags")
    public List<Tag> findAll() {
        return super.findAll();
    }

    @CachePut(cacheNames = "tags", key = "#t.id")
    public Tag create(Tag t) {
        return super.create(t);
    }

    @CachePut(cacheNames = "tags", key = "#t.id")
    public Tag update(Tag t) {
        return super.update(t);
    }

    @Cacheable(cacheNames = "tags", key = "#id")
    public Tag findById(Long id) {
        return super.findById(id);
    }

    @CacheEvict(cacheNames = "tags", key = "#id")
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    public Tag findByReferenceEntity(Tag t){
        return  dao.findByCode(t.getCode());
    }


    public void configure() {
        super.configure(Tag.class,TagHistory.class, TagHistoryCriteria.class, TagSpecification.class);
    }

    public TagAdminServiceImpl(TagDao dao, TagHistoryDao historyDao) {
        super(dao, historyDao);
    }

}