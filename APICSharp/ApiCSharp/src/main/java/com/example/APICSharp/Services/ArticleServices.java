package com.example.APICSharp.Services;

import com.example.APICSharp.DAO.ArticleDAO;

import java.util.List;

public interface ArticleServices {
    ArticleDAO save(ArticleDAO ArticleDAO);
    ArticleDAO findById(Integer id);
    ArticleDAO findByTitre(String titre);
    List<ArticleDAO> findAll();
    void delete(Integer id);
}
