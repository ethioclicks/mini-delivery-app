package com.samrit.deliveryapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DestinationDto {
    private  long id;
    private Date date;
    private  String time;
    private String address;
    private String destinationRepresentative;
    private String instruction;
    private Long orderId;


}
