package com.perez.ptbackend.infrastructore.persistence.jpa.entities;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.perez.ptbackend.infrastructore.persistence.jpa.base.UserDateAuditEntity;

@Entity
@Table(name = "Products")
public class ProductEntity extends UserDateAuditEntity implements Serializable {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private double price;

    private double priceDiscont;
    private int discount;

    private boolean mostWanted;

    @OneToMany(mappedBy = "product")
    private Set<ImageEntity> images;


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

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPriceDiscont() {
        return this.priceDiscont;
    }

    public void setPriceDiscont(double priceDiscont) {
        this.priceDiscont = priceDiscont;
    }

    public int getDiscount() {
        return this.discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }


    public boolean isMostWanted() {
        return this.mostWanted;
    }

    public boolean getMostWanted() {
        return this.mostWanted;
    }

    public void setMostWanted(boolean mostWanted) {
        this.mostWanted = mostWanted;
    }


    public Set<ImageEntity> getImages() {
        return this.images;
    }

    public void setImages(Set<ImageEntity> images) {
        this.images = images;
    }



}
