package  ma.zyn.easystock.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.zyn.easystock.zynerator.util.StringUtil;
import ma.zyn.easystock.zynerator.converter.AbstractConverter;
import ma.zyn.easystock.zynerator.util.DateUtil;
import ma.zyn.easystock.bean.history.ClientCategoryHistory;
import ma.zyn.easystock.bean.core.ClientCategory;
import ma.zyn.easystock.ws.dto.ClientCategoryDto;

@Component
public class ClientCategoryConverter extends AbstractConverter<ClientCategory, ClientCategoryDto, ClientCategoryHistory> {


    public  ClientCategoryConverter(){
        super(ClientCategory.class, ClientCategoryDto.class, ClientCategoryHistory.class);
    }

    @Override
    public ClientCategory toItem(ClientCategoryDto dto) {
        if (dto == null) {
            return null;
        } else {
        ClientCategory item = new ClientCategory();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getReference()))
                item.setReference(dto.getReference());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());


        return item;
        }
    }

    @Override
    public ClientCategoryDto toDto(ClientCategory item) {
        if (item == null) {
            return null;
        } else {
            ClientCategoryDto dto = new ClientCategoryDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getReference()))
                dto.setReference(item.getReference());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());


        return dto;
        }
    }


    public void initObject(boolean value) {
    }


}
