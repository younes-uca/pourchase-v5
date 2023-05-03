package ma.zyn.easystock.service.facade.admin;

import java.util.List;
import ma.zyn.easystock.bean.core.PurchaseTag;
import ma.zyn.easystock.dao.criteria.core.PurchaseTagCriteria;
import ma.zyn.easystock.dao.criteria.history.PurchaseTagHistoryCriteria;
import ma.zyn.easystock.zynerator.service.IService;

public interface PurchaseTagAdminService extends  IService<PurchaseTag,PurchaseTagCriteria, PurchaseTagHistoryCriteria>  {

    List<PurchaseTag> findByPurchaseId(Long id);
    int deleteByPurchaseId(Long id);
    List<PurchaseTag> findByTagId(Long id);
    int deleteByTagId(Long id);
    Long getNextOrdre();



}
