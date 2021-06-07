package com.perez.ptbackend.core.mappers;

import java.util.ArrayList;
import java.util.List;
import com.perez.ptbackend.core.models.ImageModel;
import com.perez.ptbackend.infrastructore.persistence.jpa.entities.ImageEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Component;

@Component
public class ImageMapper {


    @Autowired
    private ModelMapper modelMapper;

    public List<ImageModel> convert(List<ImageEntity> listEntity) {

        var listModel = new ArrayList<ImageModel>();
        ImageModel role;
        for (ImageEntity entity : listEntity) {
            role = modelMapper.map(entity, ImageModel.class);
            listModel.add(role);
        }

        return listModel;
    }

    public Page<ImageModel> convert(Page<ImageEntity> page) {
        var list = convert(page.getContent());
        return new PageImpl<>(list, page.getPageable(), page.getTotalElements());
    }

    public ImageEntity convert(ImageModel model) {
        return modelMapper.map(model, ImageEntity.class);
    }

    public ImageModel convert(ImageEntity entity) {
        return modelMapper.map(entity, ImageModel.class);
    }

}
