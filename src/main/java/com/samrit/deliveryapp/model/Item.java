package com.samrit.deliveryapp.model;


import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Data
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String itemName;
    @Lob
    private String itemDescription;
    @OneToOne
    private Category  categories;
    @OneToOne(cascade = CascadeType.ALL)
    private UnitOfMeasurement uom;
    private   int size;

}
