package ma.zyn.easystock.dao.facade.history;

import ma.zyn.easystock.zynerator.repository.AbstractHistoryRepository;
import ma.zyn.easystock.bean.history.TagHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface TagHistoryDao extends AbstractHistoryRepository<TagHistory,Long> {

}
