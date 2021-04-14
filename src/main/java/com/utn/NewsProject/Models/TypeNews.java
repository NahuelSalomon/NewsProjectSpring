package com.utn.NewsProject.Models;

public enum TypeNews {

    PICTURE_NEWS("Picture news"),
    TEXT_NEWS("Text news");

    private String description;

    TypeNews(String description){
        this.description = description;
    }

    public static TypeNews find(final String value) {

        for (TypeNews n : values()) {
            if (n.toString().equalsIgnoreCase(value)) {
                return n;
            }
        }
        throw new IllegalArgumentException("Illegal type news: "+value);

    }

    public String getDescription() {
        return description;
    }
}
