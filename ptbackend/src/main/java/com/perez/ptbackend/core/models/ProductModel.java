package com.perez.ptbackend.core.models;

import java.util.Set;
import java.util.UUID;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import com.perez.ptbackend.core.constants.Message;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ProductModel extends UserDateAuditModel<UUID> {

    @NotEmpty(message = Message.NOT_EMPTY_MESSAGE)
    @Size(max = 100)
    private String name;
    private double price;
    private double priceDiscont;
    private int discount;
    private Set<ImageModel> images;
    private boolean mostWanted;



}
