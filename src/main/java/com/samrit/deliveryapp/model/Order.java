package com.samrit.deliveryapp.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    @OneToOne
    private Category  categories;
    @Column(name = "item_name")
    private String itemName;
    @Column(name = "item_description")
    private String itemDescription;
    private int size;
    @OneToOne
    private UnitOfMeasurement unitOfMeasurement;
    @ManyToOne
    private User user;
    @OneToOne
    private Pickup pickup;
    @OneToOne
    private Destination destination;
}
