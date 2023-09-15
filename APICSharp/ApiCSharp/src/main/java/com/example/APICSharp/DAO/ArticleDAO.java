package com.example.APICSharp.DAO;

import com.example.APICSharp.Models.Article;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDAO {
    private Integer id;
    private String titre;
    private String pdf;
    private String description;
    private PersonneDAO personneDAO;

    public static ArticleDAO fromEntity(Article article){
        if(article==null){
            return null;
        }
        return ArticleDAO.builder()
                .id(article.getId())
                .titre(article.getTitre())
                .pdf(article.getPdf())
                .description(article.getDescription())
                .personneDAO(PersonneDAO.fromEntity(article.getPersonne()))
                .build();
    }

    public static Article toEntity(ArticleDAO articleDAO){
        if(articleDAO==null){
            return null;
        }
        return Article.builder()
                .titre(articleDAO.getTitre())
                .pdf(articleDAO.getPdf())
                .description((articleDAO.getDescription()))
                .personne(PersonneDAO.toEntity(articleDAO.getPersonneDAO()))
                .build();

    }
}
