package com.perez.ptbackend.core.ports.inputs;

import java.util.UUID;
import com.perez.ptbackend.core.models.FilterModel;
import com.perez.ptbackend.core.models.ProductModel;
import com.perez.ptbackend.core.ports.base.CRUDService;
import org.springframework.data.domain.Page;

public interface ProductService extends CRUDService<ProductModel, UUID> {

    Page<ProductModel> listMostWanted(FilterModel<ProductModel> model);

}
