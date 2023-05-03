package ma.zyn.easystock.dao.facade.core;

import ma.zyn.easystock.zynerator.repository.AbstractRepository;
import ma.zyn.easystock.bean.core.PurchaseTag;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;


@Repository
public interface PurchaseTagDao extends AbstractRepository<PurchaseTag,Long>  {

    List<PurchaseTag> findByPurchaseId(Long id);
    int deleteByPurchaseId(Long id);
    List<PurchaseTag> findByTagId(Long id);
    int deleteByTagId(Long id);

    @Query(value = "SELECT MAX(item.ordre) FROM PurchaseTag item where item.etablissementId = :etablissementId")
    Long findMaxOrdreByEtablissementIdOrder(@Param("etablissementId") Long etablissementId);
}
