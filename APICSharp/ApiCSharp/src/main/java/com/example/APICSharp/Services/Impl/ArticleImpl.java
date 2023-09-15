package com.example.APICSharp.Services.Impl;

import com.example.APICSharp.DAO.ArticleDAO;
import com.example.APICSharp.DAO.ConferenceDAO;
import com.example.APICSharp.Exceptions.EntityNotFoundException;
import com.example.APICSharp.Exceptions.ErrorCodes;
import com.example.APICSharp.Exceptions.InvalidEntityException;
import com.example.APICSharp.Models.Article;
import com.example.APICSharp.Models.Conference;
import com.example.APICSharp.Repository.ArticleRepository;
import com.example.APICSharp.Services.ArticleServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@EnableWebMvc
@EnableAutoConfiguration
public class ArticleImpl implements ArticleServices {
    private final ArticleRepository articleRepository;
    @Autowired
    public ArticleImpl(ArticleRepository articleRepository){
        this.articleRepository=articleRepository;
    }
    @Override
    public ArticleDAO save(ArticleDAO articleDAO) {
        List<String>errors=new ArrayList<>();
        if(articleDAO==null){
            errors.add("Le champ titre est obligatoire");
            errors.add("le champ pdf est obligatoire");
            errors.add("le champ de description de l'article est importante donc ne peut pas être null");

        }
        if(!StringUtils.hasLength(articleDAO.getTitre())){
            errors.add("le champs titre est obligatoire");
        }
        if(!StringUtils.hasLength(articleDAO.getPdf())){
            errors.add("le champ pdf est obligatoire");
        }
        if(!StringUtils.hasLength(articleDAO.getDescription())){
            errors.add("le champ de description de l'article est importante donc ne peut pas être null");
        }
        if(!errors.isEmpty()){
            log.error("Article not valid{}",articleDAO);
            throw new InvalidEntityException("L'article passé n'est pas valid", ErrorCodes.ARTICLE_NOT_VALID,errors);
        }
        return ArticleDAO.fromEntity(
                articleRepository.save(
                        ArticleDAO.toEntity(articleDAO)
                ));
    }

    @Override
    public ArticleDAO findById(Integer id) {
        if(id==null){
            log.error("l'id de l'article est null");
        }
        Optional<Article> article=articleRepository.findById(id);
        return Optional.of(ArticleDAO.fromEntity(article.get())).orElseThrow(()->
                new EntityNotFoundException("Aucune article n'est trouvé pour cet ID "+id+" dans la base de donnée"));
    }

    @Override
    public ArticleDAO findByTitre(String titre) {
        if(!StringUtils.hasLength(titre)){
            log.error("le nom de l'article est null il ne faut que ça soit comme ça");
        }
        Optional<Article> article=articleRepository.findArticleByTitre(titre);
        return Optional.of(ArticleDAO.fromEntity(article.get())).orElseThrow(()->
                new EntityNotFoundException("Aucun article n'est trouvé pour ce nom dans notre base de donnée"));
    }

    @Override
    public List<ArticleDAO> findAll() {
        return articleRepository.findAll().stream()
                .map(ArticleDAO::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id==null){
            log.error("l'id de la conference est null");
        }
        articleRepository.deleteById(id);

    }
}
