package com.alkemy.icons.icons.mapper;

import com.alkemy.icons.icons.dto.IconDTO;
import com.alkemy.icons.icons.entity.Icon;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class IconMapper {
    public Icon iconDTO2Entity (IconDTO dto){
        Icon icon = new Icon();
        icon.setImagen(dto.getImagen());
        icon.setDenominacion(dto.getDenominacion());
        icon.setHistoria(dto.getHistoria());
        icon.setAltura(dto.getAltura());
        icon.setFechaCreacion(dto.getFechaCreacion());
        icon.setPaises(dto.getPaises());
        return icon;
    }

    public IconDTO iconEntity2DTO (Icon entity){
        IconDTO dto = new IconDTO();
        dto.setId(entity.getId());
        dto.setImagen(entity.getImagen());
        dto.setDenominacion(entity.getDenominacion());
        dto.setHistoria(entity.getHistoria());
        dto.setAltura(entity.getAltura());
        dto.setFechaCreacion(entity.getFechaCreacion());
        dto.setPaises(entity.getPaises());
        return dto;
    }

    public List<IconDTO> iconList2DTOList(List<Icon> entities){
        List<IconDTO> dtos = new ArrayList<>();
        for (Icon entity : entities){
            dtos.add(this.iconEntity2DTO(entity));
        }
        return dtos;
    }

}
