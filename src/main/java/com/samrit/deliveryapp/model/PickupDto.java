package com.samrit.deliveryapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.sql.Time;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class PickupDto {
    private Long id;
    private String Address;
    private String pickupRepresentative;
    private  String direction;
    private Date date;
    private String time;
    private Long orderId;
}
