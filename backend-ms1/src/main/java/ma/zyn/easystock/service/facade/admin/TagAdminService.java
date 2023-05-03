package ma.zyn.easystock.service.facade.admin;

import java.util.List;
import ma.zyn.easystock.bean.core.Tag;
import ma.zyn.easystock.dao.criteria.core.TagCriteria;
import ma.zyn.easystock.dao.criteria.history.TagHistoryCriteria;
import ma.zyn.easystock.zynerator.service.IService;

public interface TagAdminService extends  IService<Tag,TagCriteria, TagHistoryCriteria>  {

    Long getNextOrdre();



}
