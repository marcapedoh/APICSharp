package com.example.APICSharp.Controller;

import com.example.APICSharp.Controller.API.ArticleAPI;
import com.example.APICSharp.DAO.ArticleDAO;
import com.example.APICSharp.Services.ArticleServices;
import com.example.APICSharp.Services.Impl.ArticleImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
public class ArticleController implements ArticleAPI {
    private ArticleServices articleServices;

    @Autowired
    public ArticleController(ArticleServices articleServices){
        this.articleServices=articleServices;
    }
    @Override
    public ArticleDAO save(ArticleDAO articleDAO) {
        return articleServices.save(articleDAO);
    }
    @Override
    public ArticleDAO findById(Integer id) {
        return articleServices.findById(id);
    }
    @Override
    public ArticleDAO findByTitre(String titre) {
        return articleServices.findByTitre(titre);
    }

    @Override
    public List<ArticleDAO> findAll() {
        return articleServices.findAll();
    }


    @Override
    public void delete(Integer id) {
        articleServices.delete(id);
    }
}
