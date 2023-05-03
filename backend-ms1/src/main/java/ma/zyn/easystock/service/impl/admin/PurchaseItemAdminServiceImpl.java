package ma.zyn.easystock.service.impl.admin;

import ma.zyn.easystock.bean.core.PurchaseItem;
import ma.zyn.easystock.bean.history.PurchaseItemHistory;
import ma.zyn.easystock.dao.criteria.core.PurchaseItemCriteria;
import ma.zyn.easystock.dao.criteria.history.PurchaseItemHistoryCriteria;
import ma.zyn.easystock.dao.facade.core.PurchaseItemDao;
import ma.zyn.easystock.dao.facade.history.PurchaseItemHistoryDao;
import ma.zyn.easystock.dao.specification.core.PurchaseItemSpecification;
import ma.zyn.easystock.service.facade.admin.PurchaseItemAdminService;
import ma.zyn.easystock.zynerator.service.AbstractServiceImpl;
import ma.zyn.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;


import ma.zyn.easystock.service.facade.admin.ProductAdminService ;
import ma.zyn.easystock.service.facade.admin.PurchaseAdminService ;


import java.util.List;
@Service
public class PurchaseItemAdminServiceImpl extends AbstractServiceImpl<PurchaseItem,PurchaseItemHistory, PurchaseItemCriteria, PurchaseItemHistoryCriteria, PurchaseItemDao,
PurchaseItemHistoryDao> implements PurchaseItemAdminService {



    public List<PurchaseItem> findByProductId(Long id){
        return dao.findByProductId(id);
    }
    public int deleteByProductId(Long id){
        return dao.deleteByProductId(id);
    }
    public List<PurchaseItem> findByPurchaseId(Long id){
        return dao.findByPurchaseId(id);
    }
    public int deleteByPurchaseId(Long id){
        return dao.deleteByPurchaseId(id);
    }

    public void configure() {
        super.configure(PurchaseItem.class,PurchaseItemHistory.class, PurchaseItemHistoryCriteria.class, PurchaseItemSpecification.class);
    }

    @Autowired
    private ProductAdminService productService ;
    @Autowired
    private PurchaseAdminService purchaseService ;
    public PurchaseItemAdminServiceImpl(PurchaseItemDao dao, PurchaseItemHistoryDao historyDao) {
        super(dao, historyDao);
    }

}