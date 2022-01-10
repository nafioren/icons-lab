package com.alkemy.icons.icons.service;

import java.util.List;

import com.alkemy.icons.icons.dto.IconBasicDTO;
import com.alkemy.icons.icons.dto.IconDTO;
import com.alkemy.icons.icons.entity.IconEntity;


public interface IconService {

    void deleteIcon(Long id);

    List<IconBasicDTO> getAllIcons();

    List<IconDTO> getAllIconDetails();

    IconDTO editIcon(Long id, IconDTO iconToEdit);

    IconDTO saveIcon(IconDTO dto);

    IconEntity getIconEntityById(Long iconId);

    List<IconDTO> getByFilters(String name, String date, List<Long> paises, String order);

    IconDTO getIconDetailsById(Long id);

}