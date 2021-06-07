package com.perez.ptbackend.core.mappers;

import java.util.ArrayList;
import java.util.List;
import com.perez.ptbackend.core.models.ProductModel;
import com.perez.ptbackend.infrastructore.persistence.jpa.entities.ProductEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {


    @Autowired
    private ModelMapper modelMapper;

    public List<ProductModel> convert(List<ProductEntity> listEntity) {

        var listModel = new ArrayList<ProductModel>();
        ProductModel role;
        for (ProductEntity entity : listEntity) {
            role = modelMapper.map(entity, ProductModel.class);
            listModel.add(role);
        }

        return listModel;
    }

    public Page<ProductModel> convert(Page<ProductEntity> page) {
        var list = convert(page.getContent());
        return new PageImpl<>(list, page.getPageable(), page.getTotalElements());
    }

    public ProductEntity convert(ProductModel model) {
        return modelMapper.map(model, ProductEntity.class);
    }

    public ProductModel convert(ProductEntity entity) {
        return modelMapper.map(entity, ProductModel.class);
    }

}
