package com.utn.NewsProject.Controllers;

import com.utn.NewsProject.Models.News;
import com.utn.NewsProject.Service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {

    private NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("/")
    public List<News> getAll() {
        return newsService.getAll();
    }

    @PostMapping("/")
    public void addNews(@RequestBody News news) {
        newsService.addNews(news);
    }

    @GetMapping("/{id}")
    public News getById(@PathVariable Integer id) {
        return newsService.getById(id);
    }

    @DeleteMapping("/")
    public void delete(@RequestBody News news) {
        newsService.delete(news);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        newsService.deleteById(id);
    }

}
