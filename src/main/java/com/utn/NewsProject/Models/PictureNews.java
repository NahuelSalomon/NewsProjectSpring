package com.utn.NewsProject.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class PictureNews extends News {

    private String urlImage;

    @Override
    public TypeNews typeNews() {
        return TypeNews.PICTURE_NEWS;
    }

}
