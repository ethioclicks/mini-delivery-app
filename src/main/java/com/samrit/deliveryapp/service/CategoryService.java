package com.samrit.deliveryapp.service;

import com.samrit.deliveryapp.model.Category;
import com.samrit.deliveryapp.model.UnitOfMeasurement;

import java.util.Set;

public interface CategoryService {
    Set<Category> listAllCategories();
}
