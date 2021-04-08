package com.form_register.model;

import org.hibernate.annotations.Parent;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer id;

    @NotEmpty(message = "không được để trống")
    @Size(min = 5, max = 45)
    @Column(name = "first_name",nullable = false,length = 45)
    private String firstName;

    @NotEmpty(message = "không được để trống")
    @Size(min = 5, max = 45)
    @Column(name ="last_name",nullable = false,length = 45)
    private String lastName;

    @NotEmpty(message = "không được để trống")
    @Pattern(regexp = "(09)(0|1)[0-9]{7}|(84\\+)(09)(0|1)[0-9]{7}")
    @Column(name = "phone",nullable = false,length = 45)
    private String phone;

    @NotNull(message = "không được để trống")
    @Min(value = 18,message = "tuổi phải lớn hơn 18")
    @Column(name = "age",nullable = false,length = 45)
    private Integer age;

    @NotEmpty(message = "không được để trống")
    @Email(message = "Địa chỉ email phải đúng định dạng email")
    @Column(name = "email",nullable = false,length = 45)
    private String email;

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
