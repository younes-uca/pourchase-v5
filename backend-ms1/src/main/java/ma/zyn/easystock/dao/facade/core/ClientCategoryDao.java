package ma.zyn.easystock.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.zyn.easystock.zynerator.repository.AbstractRepository;
import ma.zyn.easystock.bean.core.ClientCategory;
import org.springframework.stereotype.Repository;
import ma.zyn.easystock.bean.core.ClientCategory;
import java.util.List;


@Repository
public interface ClientCategoryDao extends AbstractRepository<ClientCategory,Long>  {
    ClientCategory findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW ClientCategory(item.id,item.reference) FROM ClientCategory item")
    List<ClientCategory> findAllOptimized();
}
