package  ma.zyn.easystock.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.zyn.easystock.zynerator.util.StringUtil;
import ma.zyn.easystock.zynerator.converter.AbstractConverterEnhanced;
import ma.zyn.easystock.zynerator.util.DateUtil;
import ma.zyn.easystock.bean.history.TagHistory;
import ma.zyn.easystock.bean.core.Tag;
import ma.zyn.easystock.ws.dto.TagDto;

@Component
public class TagConverter extends AbstractConverterEnhanced<Tag, TagDto, TagHistory> {


    public  TagConverter(){
        super(Tag.class, TagDto.class, TagHistory.class);
    }

    @Override
    public Tag toItem(TagDto dto) {
        if (dto == null) {
            return null;
        } else {
        Tag item = new Tag();
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
    public TagDto toDto(Tag item) {
        if (item == null) {
            return null;
        } else {
            TagDto dto = new TagDto();
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
