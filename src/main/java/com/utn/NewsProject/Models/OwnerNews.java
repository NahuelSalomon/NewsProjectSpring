package com.utn.NewsProject.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class OwnerNews {

    @Id
    private String dni;

    @NotNull(message = "The title can not be null")
    @Size(min = 5,max = 15,message = "The first name must have between 5 and 15 characters")
    private String firstName;

    @NotNull(message = "The title can not be null")
    @Size(min = 5,max = 15,message = "The last name must have between 5 and 15 characters")
    private String lastName;

    @ManyToMany
    @JoinTable(
    name = "news_per_owners",
    joinColumns = {@JoinColumn(name = "owner_id")},
    inverseJoinColumns = {@JoinColumn (name = "news_id")})
    private List<News> news;

}
