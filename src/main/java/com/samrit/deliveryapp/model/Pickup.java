package com.samrit.deliveryapp.model;


import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;

@Data
@Entity
public class Pickup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Address;
    private String pickupRepresentative;
    private  String direction;
    private Date date;
    private String time;
    @OneToOne
    private Order order;

}
