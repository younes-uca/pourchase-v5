package ma.zyn.easystock.service.facade.admin;

import java.util.List;
import ma.zyn.easystock.bean.core.Purchase;
import ma.zyn.easystock.dao.criteria.core.PurchaseCriteria;
import ma.zyn.easystock.dao.criteria.history.PurchaseHistoryCriteria;
import ma.zyn.easystock.zynerator.service.IService;

public interface PurchaseAdminService extends  IService<Purchase,PurchaseCriteria, PurchaseHistoryCriteria>  {

    List<Purchase> findByClientId(Long id);
    int deleteByClientId(Long id);



}
