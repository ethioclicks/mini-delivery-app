package com.samrit.deliveryapp.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

import java.util.Set;

@Data
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;


}
