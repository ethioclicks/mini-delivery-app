package com.samrit.deliveryapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter


public class OrderDto {

    private Long id;
    private Date date;
    private Category  categories;
    private String itemName;
    private String itemDescription;
    private int size;
    private UnitOfMeasurement unitOfMeasurement;
    private Long userId;
    private String pickup;
    private String destination;


}
