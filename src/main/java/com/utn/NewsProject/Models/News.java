package com.utn.NewsProject.Models;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.AccessType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "typeNews", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = TextNews.class, name = "TEXT_NEWS"),
        @JsonSubTypes.Type(value = PictureNews.class, name = "PICTURE_NEWS")
})
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class News {

    @Id
    @GeneratedValue
    private Integer id;

    @NotNull(message = "The title can not be null")
    @Size(min = 5,max = 50,message = "The size of title must have between 5 and 50 characters")
    private String title;

    @NotNull(message = "The body can not be null")
    @Size(min = 10,max = 300,message = "The size of body must have between 10 and 300 characters")
    private String body;

    @AccessType(AccessType.Type.PROPERTY)
    public abstract TypeNews typeNews();


}
