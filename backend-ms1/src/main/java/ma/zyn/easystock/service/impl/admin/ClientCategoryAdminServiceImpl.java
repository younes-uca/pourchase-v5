package ma.zyn.easystock.service.impl.admin;

import ma.zyn.easystock.bean.core.ClientCategory;
import ma.zyn.easystock.bean.history.ClientCategoryHistory;
import ma.zyn.easystock.dao.criteria.core.ClientCategoryCriteria;
import ma.zyn.easystock.dao.criteria.history.ClientCategoryHistoryCriteria;
import ma.zyn.easystock.dao.facade.core.ClientCategoryDao;
import ma.zyn.easystock.dao.facade.history.ClientCategoryHistoryDao;
import ma.zyn.easystock.dao.specification.core.ClientCategorySpecification;
import ma.zyn.easystock.service.facade.admin.ClientCategoryAdminService;
import ma.zyn.easystock.zynerator.service.AbstractServiceImpl;
import ma.zyn.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;






import java.util.List;
@Service
public class ClientCategoryAdminServiceImpl extends AbstractServiceImpl<ClientCategory,ClientCategoryHistory, ClientCategoryCriteria, ClientCategoryHistoryCriteria, ClientCategoryDao,
ClientCategoryHistoryDao> implements ClientCategoryAdminService {


    public ClientCategory findByReferenceEntity(ClientCategory t){
        return  dao.findByCode(t.getCode());
    }


    public void configure() {
        super.configure(ClientCategory.class,ClientCategoryHistory.class, ClientCategoryHistoryCriteria.class, ClientCategorySpecification.class);
    }

    public ClientCategoryAdminServiceImpl(ClientCategoryDao dao, ClientCategoryHistoryDao historyDao) {
        super(dao, historyDao);
    }

}