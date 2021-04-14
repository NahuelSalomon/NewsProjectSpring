package com.utn.NewsProject.Service;

import com.utn.NewsProject.Exceptions.OwerNotFoundException;
import com.utn.NewsProject.Models.News;
import com.utn.NewsProject.Models.OwnerNews;
import com.utn.NewsProject.Repositories.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Objects.isNull;

@Service
public class OwnerService {

    private OwnerRepository ownerRepository;
    private NewsService newsService;

    @Autowired
    public OwnerService(OwnerRepository ownerRepository, NewsService newsService) {
        this.ownerRepository = ownerRepository;
        this.newsService = newsService;
    }

    public void addOwner(OwnerNews owner) {
        this.ownerRepository.save(owner);
    }

    public List<OwnerNews> getAll(String name) {
        if(isNull(name)) {
            return ownerRepository.findAll();
        }
        return ownerRepository.findByFirstName(name);
    }

    public OwnerNews getById(String id) {
        return ownerRepository.findById(id).orElseThrow(() -> new OwerNotFoundException("Owner not found with id"+ id));
    }

    public void deleteById(String id) {
        ownerRepository.deleteById(id);
    }

    public void delete(OwnerNews ownerNews) {
        ownerRepository.delete(ownerNews);
    }

    public void addNewsToOwner(String idOwner, Integer idNews) {
        OwnerNews owner = getById(idOwner);
        News news = newsService.getById(idNews);
        owner.getNews().add(news);
        ownerRepository.save(owner);
    }


}
