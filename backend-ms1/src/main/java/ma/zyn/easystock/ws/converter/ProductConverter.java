package  ma.zyn.easystock.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.zyn.easystock.zynerator.util.StringUtil;
import ma.zyn.easystock.zynerator.converter.AbstractConverterEnhanced;
import ma.zyn.easystock.zynerator.util.DateUtil;
import ma.zyn.easystock.bean.history.ProductHistory;
import ma.zyn.easystock.bean.core.Product;
import ma.zyn.easystock.ws.dto.ProductDto;

@Component
public class ProductConverter extends AbstractConverterEnhanced<Product, ProductDto, ProductHistory> {


    public  ProductConverter(){
        super(Product.class, ProductDto.class, ProductHistory.class);
    }

    @Override
    public Product toItem(ProductDto dto) {
        if (dto == null) {
            return null;
        } else {
        Product item = new Product();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(StringUtil.isNotEmpty(dto.getReference()))
                item.setReference(dto.getReference());


        convertRefentielAttribute(dto, item);
        return item;
        }
    }

    @Override
    public ProductDto toDto(Product item) {
        if (item == null) {
            return null;
        } else {
            ProductDto dto = new ProductDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
            if(StringUtil.isNotEmpty(item.getReference()))
                dto.setReference(item.getReference());


        convertRefentielAttribute(item, dto);
        return dto;
        }
    }


    public void initObject(boolean value) {
    }


}
