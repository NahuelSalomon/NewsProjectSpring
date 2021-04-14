package com.utn.NewsProject.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@AllArgsConstructor
@Data
@Entity
public class TextNews extends News{

    @Override
    public TypeNews typeNews() {
        return TypeNews.TEXT_NEWS;
    }
}
