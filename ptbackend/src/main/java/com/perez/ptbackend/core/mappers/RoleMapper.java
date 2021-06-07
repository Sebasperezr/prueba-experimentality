package com.perez.ptbackend.core.mappers;

import java.util.ArrayList;
import java.util.List;
import com.perez.ptbackend.core.models.RoleModel;
import com.perez.ptbackend.infrastructore.persistence.jpa.entities.RoleEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper {

    @Autowired
    private ModelMapper modelMapper;

    public List<RoleModel> convert(List<RoleEntity> listEntity) {

        var listModel = new ArrayList<RoleModel>();
        RoleModel role;
        for (RoleEntity entity : listEntity) {
            role = modelMapper.map(entity, RoleModel.class);
            listModel.add(role);
        }

        return listModel;
    }


    public Page<RoleModel> convert(Page<RoleEntity> page) {
        var list = convert(page.getContent());
        return new PageImpl<>(list, page.getPageable(), page.getTotalElements());
    }

}
