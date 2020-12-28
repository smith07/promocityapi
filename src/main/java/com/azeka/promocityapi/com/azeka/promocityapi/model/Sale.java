package com.azeka.promocityapi.com.azeka.promocityapi.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "promo")
public class Sale implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Integer id;

    @Column(name = "old_price")
    private double oldPrice;

    @Column(name = "new_price")
    private double newPrice;

    @Column(name = "end_date")
    private String endDate;

    @Column(name = "product")
    private String product;

    @Column(name = "shop")
    private String shop;

    @Column(name = "currency")
    private String currency;

    @OneToMany
    @JoinColumn(name = "promo_id")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<Image> images;


    public Integer getId() {
        return id;
    }

    public double getOldPrice() {
        return oldPrice;
    }

    public double getNewPrice() {
        return newPrice;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getProduct() {
        return product;
    }

    public String getShop() {
        return shop;
    }

    public String getCurrency() {
        return currency;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setOldPrice(double oldPrice) {
        this.oldPrice = oldPrice;
    }

    public void setNewPrice(double newPrice) {
        this.newPrice = newPrice;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Set<Image> getImages() {
        return images;
    }

    public void setImages(Set<Image> images) {
        this.images = images;
    }
}
