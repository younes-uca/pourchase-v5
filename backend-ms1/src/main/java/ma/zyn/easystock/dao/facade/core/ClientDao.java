package ma.zyn.easystock.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.zyn.easystock.zynerator.repository.AbstractRepository;
import ma.zyn.easystock.bean.core.Client;
import org.springframework.stereotype.Repository;
import ma.zyn.easystock.bean.core.Client;
import java.util.List;


@Repository
public interface ClientDao extends AbstractRepository<Client,Long>  {
    Client findByEmail(String email);
    int deleteByEmail(String email);

    List<Client> findByClientCategoryId(Long id);
    int deleteByClientCategoryId(Long id);

    @Query("SELECT NEW Client(item.id,item.fullName) FROM Client item")
    List<Client> findAllOptimized();
}
