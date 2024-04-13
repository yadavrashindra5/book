package com.book.services;

import com.book.dtos.CategoryDto;

public interface CategoryService {
    CategoryDto create(CategoryDto categoryDto);
    CategoryDto get(String category_id);
    CategoryDto update(String category_id,CategoryDto categoryDto);
    void delete(String category_id);
}
