package ma.zyn.easystock.service.facade.admin;

import java.util.List;
import ma.zyn.easystock.bean.core.Client;
import ma.zyn.easystock.dao.criteria.core.ClientCriteria;
import ma.zyn.easystock.dao.criteria.history.ClientHistoryCriteria;
import ma.zyn.easystock.zynerator.service.IService;

public interface ClientAdminService extends  IService<Client,ClientCriteria, ClientHistoryCriteria>  {

    List<Client> findByClientCategoryId(Long id);
    int deleteByClientCategoryId(Long id);



}
