package ma.zyn.easystock.dao.facade.history;

import ma.zyn.easystock.zynerator.repository.AbstractHistoryRepository;
import ma.zyn.easystock.bean.history.ClientCategoryHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientCategoryHistoryDao extends AbstractHistoryRepository<ClientCategoryHistory,Long> {

}
