package com.example.APICSharp.Controller.API;

import com.example.APICSharp.DAO.ConferenceDAO;
import com.example.APICSharp.DAO.PersonneDAO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.APICSharp.Utils.Constants.APP_ROOT;

@Api(APP_ROOT + "/personne")
public interface PersonneAPI {
    @PostMapping(value = APP_ROOT + "/personne/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
    @ApiOperation(value = "enregistrer une Personne",notes = "cette methode permet d'enregistrer et modifier une Personne",response = PersonneDAO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "l'object Personne a été bien crée ou modifer")
    })
    PersonneDAO save(@RequestBody PersonneDAO personneDAO);
    @GetMapping(value = APP_ROOT + "/personne/findById/{idPersonne}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher une Personne", notes=" cette methode permet de rechercher une Personne par son ID",response = PersonneDAO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "la Personne a ete trouvé dans la base de donnée"),
            @ApiResponse(code=404,message = "aucune personne n'est trouvé dans la base de donnée")
    })
    PersonneDAO findById(@PathVariable("idPersonne") Integer id);
    @GetMapping(value = APP_ROOT + "/personne/findByNomPersonne/{nomPersonne}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher une Personnee", notes=" cette methode permet de rechercher une Personne par son code",response = PersonneDAO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "la Personne a ete trouvé dans la base de donnée"),
            @ApiResponse(code=400,message = "aucune Personne n'est trouvé dans la base de donnée")
    })
    PersonneDAO findByNomPersonne(@PathVariable("nomPersonne") String nomPersonne);

    @GetMapping(value = APP_ROOT + "/personne/findByMailAndPassword/{mail}/{password}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher une Personnee", notes=" cette methode permet de rechercher une Personne par son mail et son mot de passe",response = PersonneDAO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "la Personne a ete trouvé dans la base de donnée"),
            @ApiResponse(code=400,message = "aucune Personne n'est trouvé dans la base de donnée")
    })
    PersonneDAO findByMailAndPassword(@PathVariable("mail") String mail,@PathVariable("password") String password);
    @GetMapping(value = APP_ROOT + "/personne/all",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des Personnes", notes=" cette methode permet de rechercher une Personne avec tous ses attributs",responseContainer = "List<PersonneDAO>")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "liste des Personne/liste vide")
    })
    List<PersonneDAO> findAll();
    @ApiOperation(value = "Supprimer une Personne", notes=" cette methode permet de supprimer une Personne avec tous ses attributs",response = PersonneDAO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "supprimer une Personne")
    })
    @DeleteMapping(value =APP_ROOT + "/personne/delete/{idPersonne}")
    void delete(@PathVariable("idPersonne") Integer id);
}
