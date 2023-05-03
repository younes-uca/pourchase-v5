package ma.zyn.easystock.service.facade.admin;

import java.util.List;
import ma.zyn.easystock.bean.core.PurchaseItem;
import ma.zyn.easystock.dao.criteria.core.PurchaseItemCriteria;
import ma.zyn.easystock.dao.criteria.history.PurchaseItemHistoryCriteria;
import ma.zyn.easystock.zynerator.service.IService;

public interface PurchaseItemAdminService extends  IService<PurchaseItem,PurchaseItemCriteria, PurchaseItemHistoryCriteria>  {

    List<PurchaseItem> findByProductId(Long id);
    int deleteByProductId(Long id);
    List<PurchaseItem> findByPurchaseId(Long id);
    int deleteByPurchaseId(Long id);



}
