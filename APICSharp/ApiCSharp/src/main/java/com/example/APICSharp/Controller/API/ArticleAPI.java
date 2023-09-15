package com.example.APICSharp.Controller.API;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import com.example.APICSharp.DAO.ArticleDAO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.APICSharp.Utils.Constants.APP_ROOT;

@Api(APP_ROOT + "/article/")
public interface ArticleAPI {
    @PostMapping(value = APP_ROOT+ "/article/create",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "enregistrer un article",notes = "cette methode permet d'enregistrer et modifier un article",response = ArticleDAO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "l'object article a ete bien crée ou modifer")
    })
    ArticleDAO save(@RequestBody ArticleDAO articleDAO);
    @GetMapping(value = APP_ROOT + "/article/findById/{idArticle}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher un article", notes=" cette methode permet de rechercher un article par son ID",response = ArticleDAO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "l'article a ete trouvé dans la base de donnée"),
            @ApiResponse(code=404,message = "aucun article n'est trouvé dans la base de donnée")
    })
    ArticleDAO findById(@PathVariable("idArticle") Integer id);
    @GetMapping(value = APP_ROOT + "/article/findByTitre/{titre}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher un article", notes=" cette methode permet de rechercher un article par son code",response = ArticleDAO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "l'article a ete trouvé dans la base de donnée"),
            @ApiResponse(code=400,message = "aucun article n'est trouvé dans la base de donnée")
    })
    ArticleDAO findByTitre(@PathVariable("titre") String titre);
    @GetMapping(value = APP_ROOT+ "/article/all",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des article", notes=" cette methode permet de rechercher un article avec tous ses attributs",responseContainer = "List<ArticleDAO>")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "liste des articles/liste vide")
    })
    List<ArticleDAO> findAll();
    @ApiOperation(value = "Supprimer un article", notes=" cette methode permet de supprimer un article avec tous ses attributs",response = ArticleDAO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "supprimer un article")
    })
    @DeleteMapping(value =APP_ROOT +"/article/delete/{idArticle}")
    void delete(@PathVariable("idArticle") Integer id);
}
