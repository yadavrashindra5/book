package com.book.controllers;

import com.book.dtos.CategoryDto;
import com.book.services.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private Logger logger= LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    private CategoryService categoryService;
    @PostMapping
    public ResponseEntity<CategoryDto>create(@RequestBody CategoryDto categoryDto){
        CategoryDto categoryDto1 = categoryService.create(categoryDto);
        return new ResponseEntity<>(categoryDto1, HttpStatus.CREATED);
    }


    @GetMapping("/{category_id}")
    public ResponseEntity<CategoryDto>get(@PathVariable(value = "category_id") String category_id){
        CategoryDto categoryDto = categoryService.get(category_id);
        return new ResponseEntity<>(categoryDto,HttpStatus.OK);
    }

    @PutMapping("/{category_id}")
    public ResponseEntity<CategoryDto>update(@PathVariable(value = "category_id") String category_id,@RequestBody CategoryDto categoryDto){
        CategoryDto update = categoryService.update(category_id, categoryDto);
        return new ResponseEntity<>(update,HttpStatus.OK);
    }

    @DeleteMapping("/{category_id}")
    public void delete(@PathVariable(value = "category_id") String category_id){
        categoryService.delete(category_id);
    }
}
