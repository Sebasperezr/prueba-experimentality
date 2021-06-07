package com.perez.ptbackend.core.mappers;

import java.util.ArrayList;
import java.util.List;
import com.perez.ptbackend.core.models.UserModel;
import com.perez.ptbackend.infrastructore.persistence.jpa.entities.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {


    @Autowired
    private ModelMapper modelMapper;

    public List<UserModel> convert(List<UserEntity> listEntity) {

        var listModel = new ArrayList<UserModel>();
        UserModel role;
        for (UserEntity entity : listEntity) {
            role = modelMapper.map(entity, UserModel.class);
            listModel.add(role);
        }

        return listModel;
    }

    public Page<UserModel> convert(Page<UserEntity> page) {
        var list = convert(page.getContent());
        return new PageImpl<>(list, page.getPageable(), page.getTotalElements());
    }

    public UserEntity convert(UserModel userModel) {
        return modelMapper.map(userModel, UserEntity.class);
    }

    public UserModel convert(UserEntity userEntity) {
        return modelMapper.map(userEntity, UserModel.class);
    }

}
