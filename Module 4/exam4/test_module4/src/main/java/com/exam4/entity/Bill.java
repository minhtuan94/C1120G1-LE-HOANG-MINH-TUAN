package com.exam4.entity;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "bill")
public class Bill implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bill_id")
    private Integer id;

    @Column(name = "dateBuy", columnDefinition = "datetime", nullable = false)
    private String dateBuy;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "total")
    private Double total;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id", nullable = false)
    private Product product;

    public Bill() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDateBuy() {
        return dateBuy;
    }

    public void setDateBuy(String dateBuy) {
        this.dateBuy = dateBuy;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object object, Errors errors) {
        Bill bill = (Bill) object;
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(bill.getDateBuy());
            Date currentDate = new Date();

            if (date.after(currentDate)) {
                errors.rejectValue("dateBuy", "con.end.before.date");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}