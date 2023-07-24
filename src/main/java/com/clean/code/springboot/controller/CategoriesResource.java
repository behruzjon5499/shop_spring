package com.clean.code.springboot.controller;

import com.clean.code.springboot.dto.CategoriesDto;
import com.clean.code.springboot.model.Categories;
import com.clean.code.springboot.repository.CategoryRepository;
import com.clean.code.springboot.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class CategoriesResource {
    @Autowired
    private CategoriesService categoriesService;

    @Autowired
    private CategoryRepository categoryRepository;
    @GetMapping("categories/index")
    public ResponseEntity getAllCategories() {
        Categories category = new Categories(1L, "Texnika", "Texnika", "Texnika", 1, "test.jpg", "TexnikaTexnikaTexnika", "TexnikaTexnikaTexnika", "TexnikaTexnikaTexnika", 1);

        List<Categories> categories = new ArrayList<>();
        categories.add(category);
        return ResponseEntity.ok(categories);

    }

    @GetMapping("categories")
    public  List<Categories> getAll() {
        return categoryRepository.findAll();


    }
    @GetMapping("categories/{id}")
    public Optional<Categories> getOne(@PathVariable Long id) {

        return categoryRepository.findById(id);

    }
    @PostMapping("categories/create")
    public ResponseEntity create(@RequestBody CategoriesDto categoriesDto) {

        categoriesService.createCategories(categoriesDto);
        return ResponseEntity.ok(categoriesDto);

    }


}
