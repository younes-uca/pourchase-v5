package ma.zyn.easystock.service.impl.admin;

import ma.zyn.easystock.bean.core.Purchase;
import ma.zyn.easystock.bean.history.PurchaseHistory;
import ma.zyn.easystock.dao.criteria.core.PurchaseCriteria;
import ma.zyn.easystock.dao.criteria.history.PurchaseHistoryCriteria;
import ma.zyn.easystock.dao.facade.core.PurchaseDao;
import ma.zyn.easystock.dao.facade.history.PurchaseHistoryDao;
import ma.zyn.easystock.dao.specification.core.PurchaseSpecification;
import ma.zyn.easystock.service.facade.admin.PurchaseAdminService;
import ma.zyn.easystock.zynerator.service.AbstractServiceImpl;
import ma.zyn.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.zyn.easystock.bean.core.PurchaseItem;
import ma.zyn.easystock.bean.core.PurchaseTag;

import ma.zyn.easystock.service.facade.admin.PurchaseTagAdminService ;
import ma.zyn.easystock.service.facade.admin.ClientAdminService ;
import ma.zyn.easystock.service.facade.admin.PurchaseItemAdminService ;


import java.util.List;
@Service
public class PurchaseAdminServiceImpl extends AbstractServiceImpl<Purchase,PurchaseHistory, PurchaseCriteria, PurchaseHistoryCriteria, PurchaseDao,
PurchaseHistoryDao> implements PurchaseAdminService {

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Purchase create(Purchase t) {
        super.create(t);
        if (t.getPurchaseItems() != null) {
                t.getPurchaseItems().forEach(element-> {
                    element.setPurchase(t);
                    purchaseItemService.create(element);
            });
        }
        if (t.getPurchaseTag() != null) {
                t.getPurchaseTag().forEach(element-> {
                    element.setPurchase(t);
                    purchaseTagService.create(element);
            });
        }
        return t;
    }

    public Purchase findWithAssociatedLists(Long id){
        Purchase result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setPurchaseItems(purchaseItemService.findByPurchaseId(id));
            result.setPurchaseTag(purchaseTagService.findByPurchaseId(id));
        }
        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {
        purchaseItemService.deleteByPurchaseId(id);
        purchaseTagService.deleteByPurchaseId(id);
    }


    public void updateWithAssociatedLists(Purchase purchase){
    if(purchase !=null && purchase.getId() != null){
            List<List<PurchaseItem>> resultPurchaseItems= purchaseItemService.getToBeSavedAndToBeDeleted(purchaseItemService.findByPurchaseId(purchase.getId()),purchase.getPurchaseItems());
            purchaseItemService.delete(resultPurchaseItems.get(1));
            ListUtil.emptyIfNull(resultPurchaseItems.get(0)).forEach(e -> e.setPurchase(purchase));
            purchaseItemService.update(resultPurchaseItems.get(0),true);
            List<List<PurchaseTag>> resultPurchaseTag= purchaseTagService.getToBeSavedAndToBeDeleted(purchaseTagService.findByPurchaseId(purchase.getId()),purchase.getPurchaseTag());
            purchaseTagService.delete(resultPurchaseTag.get(1));
            ListUtil.emptyIfNull(resultPurchaseTag.get(0)).forEach(e -> e.setPurchase(purchase));
            purchaseTagService.update(resultPurchaseTag.get(0),true);
    }
    }

    public Purchase findByReferenceEntity(Purchase t){
        return  dao.findByReference(t.getReference());
    }

    public List<Purchase> findByClientId(Long id){
        return dao.findByClientId(id);
    }
    public int deleteByClientId(Long id){
        return dao.deleteByClientId(id);
    }

    public void configure() {
        super.configure(Purchase.class,PurchaseHistory.class, PurchaseHistoryCriteria.class, PurchaseSpecification.class);
    }

    @Autowired
    private PurchaseTagAdminService purchaseTagService ;
    @Autowired
    private ClientAdminService clientService ;
    @Autowired
    private PurchaseItemAdminService purchaseItemService ;
    public PurchaseAdminServiceImpl(PurchaseDao dao, PurchaseHistoryDao historyDao) {
        super(dao, historyDao);
    }

}