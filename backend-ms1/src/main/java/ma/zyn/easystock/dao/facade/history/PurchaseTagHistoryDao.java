package ma.zyn.easystock.dao.facade.history;

import ma.zyn.easystock.zynerator.repository.AbstractHistoryRepository;
import ma.zyn.easystock.bean.history.PurchaseTagHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseTagHistoryDao extends AbstractHistoryRepository<PurchaseTagHistory,Long> {

}
