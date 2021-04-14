package com.utn.NewsProject.Repositories;

import com.utn.NewsProject.Models.News;
import com.utn.NewsProject.Models.OwnerNews;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News,Integer> {

}
