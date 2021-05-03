package com.exam4.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer id;


    @Column(name = "product_name",length = 45, nullable = false)
    private String name;

    @Column(name = "product_price", nullable = false)
    private Double price;

    @Column(name = "product_status", nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name = "product_type_id", referencedColumnName = "product_type_id", nullable = false)
    private ProductType productType;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<Bill> billSet;

    public Product() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public Set<Bill> getBillSet() {
        return billSet;
    }

    public void setBillSet(Set<Bill> billSet) {
        this.billSet = billSet;
    }
}
