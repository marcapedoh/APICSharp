package com.example.APICSharp.Validator;

import com.example.APICSharp.DAO.PersonneDAO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class PersonneValidator {

    public static List<String> Validate(PersonneDAO personneDAO){
        List<String> errors=new ArrayList<>();
        if(personneDAO==null){
            errors.add("le nom ne peut pas être null");
            errors.add("le prenom de la personne ne peut pas être null");
            errors.add("le role de la personne ne doit pas être null");
            errors.add("l'adresse de la personne ne peut pas être null");
            errors.add("la pronance de la personne ne peut pas être null");
            errors.add("vous devenez fournir le numero de telephone");
        }
        if(!StringUtils.hasLength(personneDAO.getNomPersonne())){
            errors.add("le nom ne peut pas être null");
        }
        if(!StringUtils.hasLength(personneDAO.getPrenomPersonne())){
            errors.add("le prenom de la personne ne peut pas être null");
        }
        if(!StringUtils.hasLength(personneDAO.getRole())){
            errors.add("le role de la personne ne doit pas être null");
        }
        if (!StringUtils.hasLength(personneDAO.getAdresse())) {
            errors.add("l'adresse de la personne ne peut pas être null");
        }
        if(!StringUtils.hasLength(personneDAO.getProvenance())){
            errors.add("la pronance de la personne ne peut pas être null");
        }
        if(!StringUtils.hasLength(personneDAO.getNumeroTel())){
            errors.add("vous devenez fournir le numero de telephone");
        }
        return errors;
    }
}
