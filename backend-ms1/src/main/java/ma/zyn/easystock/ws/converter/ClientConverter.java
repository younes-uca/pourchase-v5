package  ma.zyn.easystock.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.zyn.easystock.zynerator.util.StringUtil;
import ma.zyn.easystock.zynerator.converter.AbstractConverter;
import ma.zyn.easystock.zynerator.util.DateUtil;
import ma.zyn.easystock.bean.history.ClientHistory;
import ma.zyn.easystock.bean.core.Client;
import ma.zyn.easystock.ws.dto.ClientDto;

@Component
public class ClientConverter extends AbstractConverter<Client, ClientDto, ClientHistory> {

    @Autowired
    private ClientCategoryConverter clientCategoryConverter ;
    private boolean clientCategory;

    public  ClientConverter(){
        super(Client.class, ClientDto.class, ClientHistory.class);
    }

    @Override
    public Client toItem(ClientDto dto) {
        if (dto == null) {
            return null;
        } else {
        Client item = new Client();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getFullName()))
                item.setFullName(dto.getFullName());
            if(StringUtil.isNotEmpty(dto.getEmail()))
                item.setEmail(dto.getEmail());
            if(this.clientCategory && dto.getClientCategory()!=null)
                item.setClientCategory(clientCategoryConverter.toItem(dto.getClientCategory())) ;



        return item;
        }
    }

    @Override
    public ClientDto toDto(Client item) {
        if (item == null) {
            return null;
        } else {
            ClientDto dto = new ClientDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getFullName()))
                dto.setFullName(item.getFullName());
            if(StringUtil.isNotEmpty(item.getEmail()))
                dto.setEmail(item.getEmail());
        if(this.clientCategory && item.getClientCategory()!=null) {
            dto.setClientCategory(clientCategoryConverter.toDto(item.getClientCategory())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.clientCategory = value;
    }


    public ClientCategoryConverter getClientCategoryConverter(){
        return this.clientCategoryConverter;
    }
    public void setClientCategoryConverter(ClientCategoryConverter clientCategoryConverter ){
        this.clientCategoryConverter = clientCategoryConverter;
    }
    public boolean  isClientCategory(){
        return this.clientCategory;
    }
    public void  setClientCategory(boolean clientCategory){
        this.clientCategory = clientCategory;
    }
}
