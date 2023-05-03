package  ma.zyn.easystock.dao.criteria.core;


import ma.zyn.easystock.zynerator.criteria.BaseCriteriaEnhanced;
import java.util.List;

public class PurchaseTagCriteria extends  BaseCriteriaEnhanced  {


    private PurchaseCriteria purchase ;
    private List<PurchaseCriteria> purchases ;
    private TagCriteria tag ;
    private List<TagCriteria> tags ;


    public PurchaseTagCriteria(){}


    public PurchaseCriteria getPurchase(){
        return this.purchase;
    }

    public void setPurchase(PurchaseCriteria purchase){
        this.purchase = purchase;
    }
    public List<PurchaseCriteria> getPurchases(){
        return this.purchases;
    }

    public void setPurchases(List<PurchaseCriteria> purchases){
        this.purchases = purchases;
    }
    public TagCriteria getTag(){
        return this.tag;
    }

    public void setTag(TagCriteria tag){
        this.tag = tag;
    }
    public List<TagCriteria> getTags(){
        return this.tags;
    }

    public void setTags(List<TagCriteria> tags){
        this.tags = tags;
    }
}
