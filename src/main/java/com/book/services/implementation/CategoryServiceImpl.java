package com.book.services.implementation;

import com.book.dtos.CategoryDto;
import com.book.entities.Category;
import com.book.repositories.CategoryRepository;
import com.book.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ModelMapper mapper;
    @Override
    public CategoryDto create(CategoryDto categoryDto) {
        String id= UUID.randomUUID().toString();
        categoryDto.setId(id);
        Category category = mapper.map(categoryDto, Category.class);
        Category saveCategory = categoryRepository.save(category);
        return mapper.map(saveCategory,CategoryDto.class);
    }

    @Override
    public CategoryDto get(String category_id) {
        Category category = categoryRepository.findById(category_id).orElseThrow(() -> new RuntimeException("provided id not found"));
        return mapper.map(category, CategoryDto.class);
    }

    @Override
    public CategoryDto update(String category_id, CategoryDto categoryDto) {
        Category category = categoryRepository.findById(category_id).orElseThrow(() -> new RuntimeException("provided id not found"));
        category.setTitle(categoryDto.getTitle());
        category.setImage(categoryDto.getImage());
        return mapper.map(category, CategoryDto.class);
    }

    @Override
    public void delete(String category_id) {
        Category category = categoryRepository.findById(category_id).orElseThrow(() -> new RuntimeException("provided id not found"));
        categoryRepository.delete(category);
    }
}
