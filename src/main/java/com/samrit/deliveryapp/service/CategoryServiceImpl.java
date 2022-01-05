package com.samrit.deliveryapp.service;

import com.samrit.deliveryapp.model.Category;
import com.samrit.deliveryapp.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Set<Category> listAllCategories() {
        return StreamSupport.stream(categoryRepository.findAll()
                .spliterator(), false)
                .collect(Collectors.toSet());
    }
}
