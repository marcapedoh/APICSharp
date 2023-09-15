package com.example.APICSharp.Repository;

import com.example.APICSharp.Models.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article,Integer> {
    Optional<Article> findArticleByTitre(String titre);
}
