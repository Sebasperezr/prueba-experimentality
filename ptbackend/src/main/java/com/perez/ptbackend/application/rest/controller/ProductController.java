package com.perez.ptbackend.application.rest.controller;


import java.util.UUID;
import com.perez.ptbackend.core.models.FilterModel;
import com.perez.ptbackend.core.models.ProductModel;
import com.perez.ptbackend.core.ports.inputs.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class ProductController {
    @Autowired
    private ProductService service;

    @PostMapping(path = "${app.api.version.v1}/products")
    public Page<ProductModel> list(@RequestBody FilterModel<ProductModel> model) {
        return service.list(model);
    }

    @PostMapping(path = "${app.api.version.v1}/products/most-wanted")
    public Page<ProductModel> mostWanted(@RequestBody FilterModel<ProductModel> model) {
        return service.listMostWanted(model);
    }

    @GetMapping(path = "${app.api.version.v1}/product/{idProduct}")
    public ProductModel find(@PathVariable("idProduct") UUID idProduct) {
        return service.findById(idProduct);
    }

}
