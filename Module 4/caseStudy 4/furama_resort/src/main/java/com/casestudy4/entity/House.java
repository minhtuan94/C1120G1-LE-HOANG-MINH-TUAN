package com.casestudy4.entity;

import javax.persistence.*;

@Entity
@Table(name = "house")
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "house_id")
    private Integer id;

    @Column(name = "standard_room",length = 45)
    private String standardRoom;

    @Column(name = "description_other_convenience", length = 45)
    private String description;

    @Column(name = "number_of_floors")
    private Integer numberOfFloors;

}
