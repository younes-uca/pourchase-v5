package  ma.zyn.easystock.dao.criteria.core;


import ma.zyn.easystock.zynerator.criteria.BaseCriteria;
import java.util.List;

public class ClientCategoryCriteria extends  BaseCriteria  {

    private String reference;
    private String referenceLike;
    private String code;
    private String codeLike;



    public ClientCategoryCriteria(){}

    public String getReference(){
        return this.reference;
    }
    public void setReference(String reference){
        this.reference = reference;
    }
    public String getReferenceLike(){
        return this.referenceLike;
    }
    public void setReferenceLike(String referenceLike){
        this.referenceLike = referenceLike;
    }

    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }
    public String getCodeLike(){
        return this.codeLike;
    }
    public void setCodeLike(String codeLike){
        this.codeLike = codeLike;
    }


}
