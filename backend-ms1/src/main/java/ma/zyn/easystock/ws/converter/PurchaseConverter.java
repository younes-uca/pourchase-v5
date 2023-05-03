package  ma.zyn.easystock.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zyn.easystock.zynerator.util.ListUtil;


import ma.zyn.easystock.zynerator.util.StringUtil;
import ma.zyn.easystock.zynerator.converter.AbstractConverter;
import ma.zyn.easystock.zynerator.util.DateUtil;
import ma.zyn.easystock.bean.history.PurchaseHistory;
import ma.zyn.easystock.bean.core.Purchase;
import ma.zyn.easystock.ws.dto.PurchaseDto;

@Component
public class PurchaseConverter extends AbstractConverter<Purchase, PurchaseDto, PurchaseHistory> {

    @Autowired
    private ProductConverter productConverter ;
    @Autowired
    private TagConverter tagConverter ;
    @Autowired
    private PurchaseTagConverter purchaseTagConverter ;
    @Autowired
    private ClientConverter clientConverter ;
    @Autowired
    private PurchaseItemConverter purchaseItemConverter ;
    private boolean client;
    private boolean purchaseItems;
    private boolean purchaseTag;

    public  PurchaseConverter(){
        super(Purchase.class, PurchaseDto.class, PurchaseHistory.class);
        init(true);
    }

    @Override
    public Purchase toItem(PurchaseDto dto) {
        if (dto == null) {
            return null;
        } else {
        Purchase item = new Purchase();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getReference()))
                item.setReference(dto.getReference());
            if(StringUtil.isNotEmpty(dto.getPurchaseDate()))
                item.setPurchaseDate(DateUtil.stringEnToDate(dto.getPurchaseDate()));
            if(StringUtil.isNotEmpty(dto.getImage()))
                item.setImage(dto.getImage());
            if(StringUtil.isNotEmpty(dto.getTotal()))
                item.setTotal(dto.getTotal());
            if(StringUtil.isNotEmpty(dto.getDescription()))
                item.setDescription(dto.getDescription());
            if(this.client && dto.getClient()!=null)
                item.setClient(clientConverter.toItem(dto.getClient())) ;


            if(this.purchaseItems && ListUtil.isNotEmpty(dto.getPurchaseItems()))
                item.setPurchaseItems(purchaseItemConverter.toItem(dto.getPurchaseItems()));
            if(this.purchaseTag && ListUtil.isNotEmpty(dto.getPurchaseTag()))
                item.setPurchaseTag(purchaseTagConverter.toItem(dto.getPurchaseTag()));

        return item;
        }
    }

    @Override
    public PurchaseDto toDto(Purchase item) {
        if (item == null) {
            return null;
        } else {
            PurchaseDto dto = new PurchaseDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getReference()))
                dto.setReference(item.getReference());
            if(item.getPurchaseDate()!=null)
                dto.setPurchaseDate(DateUtil.dateTimeToString(item.getPurchaseDate()));
            if(StringUtil.isNotEmpty(item.getImage()))
                dto.setImage(item.getImage());
            if(StringUtil.isNotEmpty(item.getTotal()))
                dto.setTotal(item.getTotal());
            if(StringUtil.isNotEmpty(item.getDescription()))
                dto.setDescription(item.getDescription());
        if(this.client && item.getClient()!=null) {
            dto.setClient(clientConverter.toDto(item.getClient())) ;
        }
        if(this.purchaseItems && ListUtil.isNotEmpty(item.getPurchaseItems())){
            purchaseItemConverter.init(true);
            purchaseItemConverter.setPurchase(false);
            dto.setPurchaseItems(purchaseItemConverter.toDto(item.getPurchaseItems()));
            purchaseItemConverter.setPurchase(true);

        }
        if(this.purchaseTag && ListUtil.isNotEmpty(item.getPurchaseTag())){
            purchaseTagConverter.init(true);
            purchaseTagConverter.setPurchase(false);
            dto.setPurchaseTag(purchaseTagConverter.toDto(item.getPurchaseTag()));
            purchaseTagConverter.setPurchase(true);

        }


        return dto;
        }
    }

    public void initList(boolean value) {
        this.purchaseItems = value;
        this.purchaseTag = value;
    }

    public void initObject(boolean value) {
        this.client = value;
    }


    public ProductConverter getProductConverter(){
        return this.productConverter;
    }
    public void setProductConverter(ProductConverter productConverter ){
        this.productConverter = productConverter;
    }
    public TagConverter getTagConverter(){
        return this.tagConverter;
    }
    public void setTagConverter(TagConverter tagConverter ){
        this.tagConverter = tagConverter;
    }
    public PurchaseTagConverter getPurchaseTagConverter(){
        return this.purchaseTagConverter;
    }
    public void setPurchaseTagConverter(PurchaseTagConverter purchaseTagConverter ){
        this.purchaseTagConverter = purchaseTagConverter;
    }
    public ClientConverter getClientConverter(){
        return this.clientConverter;
    }
    public void setClientConverter(ClientConverter clientConverter ){
        this.clientConverter = clientConverter;
    }
    public PurchaseItemConverter getPurchaseItemConverter(){
        return this.purchaseItemConverter;
    }
    public void setPurchaseItemConverter(PurchaseItemConverter purchaseItemConverter ){
        this.purchaseItemConverter = purchaseItemConverter;
    }
    public boolean  isClient(){
        return this.client;
    }
    public void  setClient(boolean client){
        this.client = client;
    }
    public boolean  isPurchaseItems(){
        return this.purchaseItems ;
    }
    public void  setPurchaseItems(boolean purchaseItems ){
        this.purchaseItems  = purchaseItems ;
    }
    public boolean  isPurchaseTag(){
        return this.purchaseTag ;
    }
    public void  setPurchaseTag(boolean purchaseTag ){
        this.purchaseTag  = purchaseTag ;
    }
}
