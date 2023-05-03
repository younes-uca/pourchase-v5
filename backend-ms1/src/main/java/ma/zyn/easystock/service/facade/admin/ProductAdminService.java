package ma.zyn.easystock.service.facade.admin;

import java.util.List;
import ma.zyn.easystock.bean.core.Product;
import ma.zyn.easystock.dao.criteria.core.ProductCriteria;
import ma.zyn.easystock.dao.criteria.history.ProductHistoryCriteria;
import ma.zyn.easystock.zynerator.service.IService;

public interface ProductAdminService extends  IService<Product,ProductCriteria, ProductHistoryCriteria>  {

    Long getNextOrdre();



}
