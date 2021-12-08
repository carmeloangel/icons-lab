package com.alkemy.icons.icons.mapper;

import com.alkemy.icons.icons.dto.PaisDTO;
import com.alkemy.icons.icons.entity.Pais;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PaisMapper {

    public Pais paisDTO2Entity (PaisDTO dto) {
        Pais pais = new Pais();
        pais.setImagen(dto.getImagen());
        pais.setDenominacion(dto.getDenominacion());
        pais.setCantidadHabitantes(dto.getCantidadHabitantes());
        pais.setSuperficie(dto.getSuperficie());
        pais.setContinente(dto.getContinente());
        pais.setIcons(dto.getIcons());

        return pais;
    }

    public PaisDTO paisEntity2DTO (Pais  entity) {

        PaisDTO dto = new PaisDTO();
        dto.setId(entity.getId());
        dto.setImagen(entity.getImagen());
        dto.setDenominacion(entity.getDenominacion());
        dto.setCantidadHabitantes(entity.getCantidadHabitantes());
        dto.setSuperficie(entity.getSuperficie());
        dto.setContinente(entity.getContinente());
        dto.setIcons(entity.getIcons());

        return dto;
    }

    public List<PaisDTO> paisList2DTOList (List<Pais> entities) {
        List<PaisDTO> dtos = new ArrayList<>();
        for (Pais entity : entities) {
            dtos.add(this.paisEntity2DTO(entity));
        }
        return dtos;
    }
}
