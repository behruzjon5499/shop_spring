package com.clean.code.springboot.dto;

import lombok.Data;

@Data
public class CategoriesDto {

    Long id;
    String title_ru;
    String title_uz;
    String title_en;
    Integer parent_id;
    String photo;
    Integer status;
    String description_ru;
    String description_uz;
    String description_en;

}
