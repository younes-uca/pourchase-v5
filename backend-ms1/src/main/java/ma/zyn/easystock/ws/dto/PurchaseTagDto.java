package  ma.zyn.easystock.ws.dto;

import ma.zyn.easystock.zynerator.audit.Log;
import ma.zyn.easystock.zynerator.dto.AuditBaseDtoEnhanced;
import com.fasterxml.jackson.annotation.JsonInclude;



@JsonInclude(JsonInclude.Include.NON_NULL)
public class PurchaseTagDto  extends AuditBaseDtoEnhanced {


    private PurchaseDto purchase ;
    private TagDto tag ;



    public PurchaseTagDto(){
        super();
    }




    public PurchaseDto getPurchase(){
        return this.purchase;
    }

    public void setPurchase(PurchaseDto purchase){
        this.purchase = purchase;
    }
    public TagDto getTag(){
        return this.tag;
    }

    public void setTag(TagDto tag){
        this.tag = tag;
    }




}
