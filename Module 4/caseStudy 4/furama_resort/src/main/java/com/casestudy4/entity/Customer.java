package com.casestudy4.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Set;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Integer id;

    @Column(name = "customer_code",length = 45, nullable = false)
    @NotNull(message = "mã khách hàng không được trống ")
    @Pattern(regexp = "(KH-)[0-9]{4}", message = "Mã Khách hàng có định dạng là KH-XXXX (X là số từ 0-9)")
    private String code;

    @ManyToOne
    @JoinColumn(name = "customer_type_id",referencedColumnName = "customer_type_id",nullable = false)
    private CustomerType customerType;

    @Column(name = "customer_name",length = 45, nullable = false)
    private String name;

    @Column(name = "customer_birthday",columnDefinition = "date", nullable = false)
    private String birthday;

    @NotEmpty(message ="Giới tinh không được trống")
    @Column(name = "customer_gender",nullable = false)
    private String gender;

    @NotEmpty(message = "CMND không được trống")
    @Pattern(regexp = "[0-9]{9}|[0-9]{12}", message = "Số CMND phải đúng định dạng XXXXXXXXX hoặc XXXXXXXXXXXX (X là số 0-9)")
    @Column(name = "customer_id_card",nullable = false,length = 45)
    private String idCard;

    @NotEmpty(message = "Số điện thoại không được trống")
    @Pattern(regexp = "(09)(0|1)[0-9]{7}|(84\\+)(09)(0|1)[0-9]{7}", message = "Số điện thoại phải đúng định dạng 090xxxxxxx,091xxxxxxx,(84)+90xxxxxxx,(84)+91xxxxxxx")
    @Column(name = "customer_phone",nullable = false,length = 45)
    private String phone;

    @NotEmpty(message = "email không được trống")
    @Email(message = "Địa chỉ email phải đúng định dạng email")
    @Column(name = "customer_email", length = 45)
    private String email;

    @Column(name = "customer_address",length = 45)
    private String address;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<Contract> contractSet;

    public Customer() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customer_type) {
        this.customerType = customer_type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Contract> getContractSet() {
        return contractSet;
    }

    public void setContractSet(Set<Contract> contractSet) {
        this.contractSet = contractSet;
    }
}
