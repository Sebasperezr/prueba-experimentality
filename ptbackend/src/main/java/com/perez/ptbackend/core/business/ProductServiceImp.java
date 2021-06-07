package com.perez.ptbackend.core.business;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.persistence.criteria.Predicate;
import com.perez.ptbackend.core.constants.Constant;
import com.perez.ptbackend.core.mappers.ProductMapper;
import com.perez.ptbackend.core.models.FilterModel;
import com.perez.ptbackend.core.models.ProductModel;
import com.perez.ptbackend.core.ports.inputs.ProductService;
import com.perez.ptbackend.infrastructore.persistence.jpa.respositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImp extends BaseService<ProductModel> implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper modelMapper;

    @Override
    public ProductModel save(ProductModel model) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ProductModel update(ProductModel model) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Page<ProductModel> list(FilterModel<ProductModel> model) {
        var pageable = PageRequest.of(model.getPage(), model.getSize(), getSort(model));

        return modelMapper.convert(productRepository.findAll((root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            var value = model.getFilters();
            if (value != null) {

                if (value.isMostWanted()) {
                    predicates.add(cb.equal(root.get("mostWanted"), true));
                }
                if (value.getName() != null) {
                    var like = "%" + value.getName() + "%";
                    predicates.add(cb.like(root.get("name"), like));
                }
            }


            return cb.and(predicates.toArray(new Predicate[0]));

        }, pageable));
    }

    @Override
    public ProductModel findById(UUID id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ProductModel deleteById(UUID id) {
        // TODO Auto-generated method stub
        return null;
    }


    private Sort getSort(FilterModel<ProductModel> model) {
        if (model.getSort() != null) {
            if (model.getDirection() != null && model.getDirection().equalsIgnoreCase("desc")) {
                return Sort.by(Sort.Direction.DESC, model.getSort());
            }
            return Sort.by(Sort.Direction.ASC, model.getSort());
        } else {

            return Sort.by(Sort.Direction.ASC, Constant.CREATED_AT);
        }

    }

    @Override
    public Page<ProductModel> listMostWanted(FilterModel<ProductModel> model) {
        var pageable = PageRequest.of(model.getPage(), model.getSize(), getSort(model));

        return modelMapper.convert(productRepository.findAll((root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            var value = model.getFilters();
            if (value != null) {

                predicates.add(cb.equal(root.get("mostWanted"), true));

            }

            return cb.and(predicates.toArray(new Predicate[0]));

        }, pageable));
    }

}
