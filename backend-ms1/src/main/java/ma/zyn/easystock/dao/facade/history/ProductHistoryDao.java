package ma.zyn.easystock.dao.facade.history;

import ma.zyn.easystock.zynerator.repository.AbstractHistoryRepository;
import ma.zyn.easystock.bean.history.ProductHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductHistoryDao extends AbstractHistoryRepository<ProductHistory,Long> {

}
