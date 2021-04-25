package com.casestudy4.entity;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "contract")
public class Contract implements Validator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_id")
    private Integer id;

    @Column(name = "contract_start_date", columnDefinition = "DATETIME",nullable = false)
    private String startDate;

    @Column(name = "contract_end_date", columnDefinition = "DATETIME",nullable = false)
    private String endDate;

    @Column(name = "contract_deposit", nullable = false)
    private Double deposit;

    @Column(name = "contract_total_money", nullable = false)
    private Double totalMoney;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id", nullable = false)
    private Employee employee;

    @ManyToOne
        @JoinColumn(name = "customer_id", referencedColumnName = "customer_id",nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "service_id", referencedColumnName = "service_id",nullable = false)
    private Service service;

    @OneToMany(mappedBy = "contract", cascade = CascadeType.ALL)
    private Set<ContractDetail> contractDetailSet;

    public Contract() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Set<ContractDetail> getContractDetailSet() {
        return contractDetailSet;
    }

    public void setContractDetailSet(Set<ContractDetail> contractDetailSet) {
        this.contractDetailSet = contractDetailSet;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object object, Errors errors) {
        Contract contract = (Contract) object;
        try {
            Date start = new SimpleDateFormat("yyyy-MM-dd").parse(contract.getStartDate());
            Date end = new SimpleDateFormat("yyyy-MM-dd").parse(contract.getEndDate());
            Date currentDate = new Date();
            if (start.after(end)) {
                errors.rejectValue("startDate", "con.start.afterEnd");
            }
            if (end.before(start)) {
                errors.rejectValue("endDate", "con.end.beforeStart");
            }
            if (end.before(currentDate)){
                errors.rejectValue("endDate", "con.end.beforeCurrent");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
