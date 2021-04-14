package com.utn.NewsProject.Repositories;

import com.utn.NewsProject.Models.OwnerNews;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OwnerRepository extends JpaRepository<OwnerNews,String> {
    List<OwnerNews> findByFirstName(String name);
}
