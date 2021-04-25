package com.casestudy4.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Set;

@Entity
@Table(name = "service")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_id")
    private Integer id;

    @NotEmpty(message = "Mã dịch vụ không được trống")
    @Pattern(regexp = "(DV-)[0-9]{4}", message = "Mã dịch vụ có định dạng là DV-XXXX (X là số từ 0-9)")
    @Column(name = "service_code")
    private String code;

    @Column(name = "service_name",length = 45, nullable = false)
    private String name;

    @Column(name = "service_area")
    private Integer area;

    @Column(name = "service_cost", nullable = false)
    private Double cost;

    @Column(name = "service_max_people")
    private Integer maxPeople;

    @ManyToOne
    @JoinColumn(name = "rent_type_id",referencedColumnName = "rent_type_id")
    private RentType rentType;

    @ManyToOne
    @JoinColumn(name = "service_type_id", referencedColumnName = "service_type_id")
    private ServiceType serviceType;

    @Column(name = "standard_room",length = 45)
    private String standardRoom;

    @Column(name = "description_other_convenience", length = 45)
    private String description;

    @Column(name = "pool_area")
    private Double poolArea;

    @Column(name = "number_of_floors")
    private Integer numberOfFloors;

    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL)
    private Set<Contract> contractSet;

    public Service() {
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

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Integer getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(Integer maxPeople) {
        this.maxPeople = maxPeople;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    public Integer getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(Integer numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public Set<Contract> getContractSet() {
        return contractSet;
    }

    public void setContractSet(Set<Contract> contractSet) {
        this.contractSet = contractSet;
    }
}
