package com.perez.ptbackend.core.models;

import java.util.UUID;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ImageModel extends UserDateAuditModel<UUID> {


    private String name;
    private ProductModel product;



}
