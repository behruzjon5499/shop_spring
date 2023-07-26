package com.clean.code.springboot.repository;

import com.clean.code.springboot.model.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Categories, Long> {

    @Query("select c from Categories c where c.title_ru = :name  ")
    List<Categories> nameQuery(@Param("name") String name);
    @Query(value = "select * from categories c where c.title_ru = :name  ",nativeQuery = true)
    List<Categories> nameNativeQuery(@Param("name") String name);
}
