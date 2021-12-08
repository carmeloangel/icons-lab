package com.alkemy.icons.icons.service.impl;

import com.alkemy.icons.icons.dto.IconDTO;
import com.alkemy.icons.icons.entity.Icon;
import com.alkemy.icons.icons.mapper.IconMapper;
import com.alkemy.icons.icons.repository.IconRepository;
import com.alkemy.icons.icons.service.IconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IconServiceImpl implements IconService {

    @Autowired
    private IconMapper iconMapper;

    @Autowired
    private IconRepository iconRepository;

    @Override
    public IconDTO save(IconDTO dto) {

        Icon entity = iconMapper.iconDTO2Entity(dto);
        Icon entitySaved = iconRepository.save(entity);
        IconDTO result = iconMapper.iconEntity2DTO(entitySaved);

        return result;
    }

    @Override
    public List<IconDTO> getAllIcons() {
        List<Icon> entities = iconRepository.findAll();
        List<IconDTO> result = iconMapper.iconList2DTOList(entities);
        return result;
    }
}
