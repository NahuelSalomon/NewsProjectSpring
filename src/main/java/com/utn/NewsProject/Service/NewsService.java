package com.utn.NewsProject.Service;

import com.utn.NewsProject.Exceptions.NewsNotFoundException;
import com.utn.NewsProject.Models.News;
import com.utn.NewsProject.Repositories.NewsRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class NewsService {

    private NewsRepository newsRepository;

    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    public void addNews(News news) {
        newsRepository.save(news);
    }

    public List<News> getAll() {
        return newsRepository.findAll();
    }

    public News getById(Integer id) {
        return newsRepository.findById(id).orElseThrow(() -> new NewsNotFoundException("News not found with id" + id));
    }

    public void delete(News news) {
        newsRepository.delete(news);
    }

    public void deleteById(Integer id) {
        newsRepository.deleteById(id);
    }


}
