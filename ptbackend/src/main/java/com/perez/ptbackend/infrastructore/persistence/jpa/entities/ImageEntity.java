package com.perez.ptbackend.infrastructore.persistence.jpa.entities;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "images")
public class ImageEntity {
    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "product", nullable = false)
    private ProductEntity product;

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductEntity getProduct() {
        return this.product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

}
