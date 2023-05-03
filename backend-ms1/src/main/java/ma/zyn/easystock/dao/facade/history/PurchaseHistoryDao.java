package ma.zyn.easystock.dao.facade.history;

import ma.zyn.easystock.zynerator.repository.AbstractHistoryRepository;
import ma.zyn.easystock.bean.history.PurchaseHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseHistoryDao extends AbstractHistoryRepository<PurchaseHistory,Long> {

}
