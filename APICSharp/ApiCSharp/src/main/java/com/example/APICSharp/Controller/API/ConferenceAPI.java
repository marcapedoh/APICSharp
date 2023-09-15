package com.example.APICSharp.Controller.API;

import com.example.APICSharp.DAO.ConferenceDAO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.APICSharp.Utils.Constants.APP_ROOT;

@Api(APP_ROOT + "/conference/")
public interface ConferenceAPI {
    @PostMapping(value = APP_ROOT +"/conference/create",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "enregistrer un article",notes = "cette methode permet d'enregistrer et modifier une conference",response = ConferenceDAO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "l'object conference a été bien crée ou modifer")
    })
    ConferenceDAO save(@RequestBody ConferenceDAO conferenceDAO);
    @GetMapping(value =APP_ROOT+"/conference/findById/{idConference}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher une conference", notes=" cette methode permet de rechercher une conference par son ID",response = ConferenceDAO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "la conference a ete trouvé dans la base de donnée"),
            @ApiResponse(code=404,message = "aucune conference n'est trouvé dans la base de donnée")
    })
    ConferenceDAO findById(@PathVariable("idConference") Integer id);
    @GetMapping(value =APP_ROOT + "/conference/findByNomConference/{nomConference}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher une conference", notes=" cette methode permet de rechercher une conference par son code",response = ConferenceDAO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "la conference a ete trouvé dans la base de donnée"),
            @ApiResponse(code=400,message = "aucune conference n'est trouvé dans la base de donnée")
    })
    ConferenceDAO findByNomConference(@PathVariable("nomConferernce") String nomConference);
    @GetMapping(value = APP_ROOT +"/conference/all",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des conference", notes=" cette methode permet de rechercher une conference avec tous ses attributs",responseContainer = "List<ConferenceDAO>")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "liste des Conference/liste vide")
    })
    List<ConferenceDAO> findAll();
    @ApiOperation(value = "Supprimer une conference", notes=" cette methode permet de supprimer une conference avec tous ses attributs",response = ConferenceDAO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "supprimer une conference")
    })
    @DeleteMapping(value =APP_ROOT +"/conference/delete/{idConference}")
    void delete(@PathVariable("idConference") Integer id);
}
