package com.casestudy4.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Set;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Integer id;

    @Column(name = "employee_code",length = 45)
    private String code;

    @Column(name = "employee_name",length = 45)
    private String name;

    @Column(name = "employee_birthday",columnDefinition = "date",length = 45)
    private String birthday;

    @NotEmpty(message = "CMND không được trống")
    @Pattern(regexp = "[0-9]{9}|[0-9]{12}", message = "Số CMND phải đúng định dạng XXXXXXXXX hoặc XXXXXXXXXXXX (X là số 0-9)")
    @Column(name = "employee_id_card",length = 45)
    private String idCard;

    @Column(name = "employee_salary")
    private Double salary;

    @NotEmpty(message = "Số điện thoại không được trống")
    @Pattern(regexp = "(09)(0|1)[0-9]{7}|(84\\+)(09)(0|1)[0-9]{7}", message = "Số điện thoại phải đúng định dạng 090xxxxxxx,091xxxxxxx,(84)+90xxxxxxx,(84)+91xxxxxxx")
    @Column(name = "employee_phone",length = 45)
    private String phone;

    @NotEmpty(message = "không được để trống")
    @Email(message = "emai phải đúng định dạng")
    @Column(name = "employee_email",length = 45)
    private String email;

    @Column(name = "employee_address",length = 45)
    private String address;

    @ManyToOne
    @JoinColumn(name = "position_id", referencedColumnName = "position_id", nullable = false)
    private Position position;

    @ManyToOne
    @JoinColumn(name = "education_degree_id", referencedColumnName = "education_degree_id", nullable = false)
    private EducationDegree educationDegree;

    @ManyToOne
    @JoinColumn(name = "division_id", referencedColumnName = "division_id", nullable = false)
    private Division division;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private Set<Contract> contractSet;

    public Employee() {
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

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public Set<Contract> getContractSet() {
        return contractSet;
    }

    public void setContractSet(Set<Contract> contractSet) {
        this.contractSet = contractSet;
    }
}
