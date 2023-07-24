package com.clean.code.springboot.service;

import com.clean.code.springboot.dto.CategoriesDto;
import com.clean.code.springboot.model.Categories;
import com.clean.code.springboot.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriesService{
         @Autowired
        private  CategoryRepository categoryRepository;

    public Categories createCategories(CategoriesDto categoriesDto){

            Categories categories = new Categories();
            categories.setTitle_ru(categoriesDto.getTitle_ru());
            categories.setTitle_uz(categoriesDto.getTitle_uz());
            categories.setTitle_en(categoriesDto.getTitle_en());
            categories.setParent_id(categoriesDto.getParent_id());
            categories.setPhoto(categoriesDto.getPhoto());
            categories.setStatus(categoriesDto.getStatus());
            categories.setDescription_ru(categoriesDto.getDescription_ru());
            categories.setDescription_uz(categoriesDto.getDescription_uz());
            categories.setDescription_en(categoriesDto.getDescription_en());
            categoryRepository.save(categories);
          return  categories;
    }

}
