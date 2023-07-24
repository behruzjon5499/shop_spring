package com.clean.code.springboot.model;

import javax.persistence.*;

@Entity
@Table(name = "categories")

public class Categories {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title_ru")
    public String title_ru;
    @Column(name = "title_uz")
    public String title_uz;
    @Column(name = "title_en")
    public String title_en;
    @Column(name = "parent_id")
    public Integer parent_id;
    @Column(name = "photo")
    public String photo;
    @Column(name = "description_ru")
    public String description_ru;
    @Column(name = "description_uz")
    public String description_uz;
    @Column(name = "description_en")
    public String description_en;

    @Column(name = "status")
    public Integer status;


    public Categories(long id, String title_ru, String title_uz, String title_en, Integer parent_id, String photo, String description_ru, String description_uz, String description_en, Integer status) {
        this.id = id;
        this.title_ru = title_ru;
        this.title_uz = title_uz;
        this.title_en = title_en;
        this.parent_id = parent_id;
        this.photo = photo;
        this.description_ru = description_ru;
        this.description_uz = description_uz;
        this.description_en = description_en;
        this.status = status;
    }

    public Categories() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle_ru() {
        return title_ru;
    }

    public void setTitle_ru(String title_ru) {
        this.title_ru = title_ru;
    }

    public String getTitle_uz() {
        return title_uz;
    }

    public void setTitle_uz(String title_uz) {
        this.title_uz = title_uz;
    }

    public String getTitle_en() {
        return title_en;
    }

    public void setTitle_en(String title_en) {
        this.title_en = title_en;
    }

    public Integer getParent_id() {
        return parent_id;
    }

    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDescription_ru() {
        return description_ru;
    }

    public void setDescription_ru(String description_ru) {
        this.description_ru = description_ru;
    }

    public String getDescription_uz() {
        return description_uz;
    }

    public void setDescription_uz(String description_uz) {
        this.description_uz = description_uz;
    }

    public String getDescription_en() {
        return description_en;
    }

    public void setDescription_en(String description_en) {
        this.description_en = description_en;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
