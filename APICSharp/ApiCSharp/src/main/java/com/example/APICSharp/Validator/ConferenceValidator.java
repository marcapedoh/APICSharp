package com.example.APICSharp.Validator;

import com.example.APICSharp.DAO.ConferenceDAO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ConferenceValidator {
    public static List<String> Validate(ConferenceDAO conferenceDAO){
        List<String>errors=new ArrayList<>();
        if(conferenceDAO==null){
            errors.add("Le champs nom de conference ne doit op etre null");
            errors.add("le champs theme ne doit pas être null");
            errors.add("le champs sigle ne doit pas être null");
            errors.add("le champs date de soumission ne peut pas être null");
            errors.add("le champs date d'inscription de conference ne peut pas être null");
            errors.add("le champs date de retour des depots d'article");
        }
        if(!StringUtils.hasLength(conferenceDAO.getNomConference())){
            errors.add("Le champs nom de conference ne doit op etre null");
        }
        if(!StringUtils.hasLength(conferenceDAO.getTheme())){
            errors.add("le champs theme ne doit pas être null");
        }
        if(!StringUtils.hasLength(conferenceDAO.getSigle())){
            errors.add("le champs sigle ne doit pas être null");
        }
        if(conferenceDAO.getDataSoumissionArticle()==null){
            errors.add("le champs date de soumission ne peut pas être null");
        }
        if(conferenceDAO.getDateInscriptionConference()==null){
            errors.add("le champs date d'inscription de conference ne peut pas être null");
        }
        if(conferenceDAO.getDateRetourDesdepotDarticle()==null){
            errors.add("le champs date de retour des depots d'article");
        }
        return errors;
    }
}
