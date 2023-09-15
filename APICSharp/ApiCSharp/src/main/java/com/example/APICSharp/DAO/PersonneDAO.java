package com.example.APICSharp.DAO;

import com.example.APICSharp.Models.Conference;
import com.example.APICSharp.Models.Personne;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonneDAO {
    private Integer id;
    private String role;
    private String nomPersonne;
    private String prenomPersonne;
    private String numeroTel;
    private String adresse;
    private String motDePasse;
    private String mail;
    private String provenance;
    @JsonIgnore
    private List<ArticleDAO> articles;
    @JsonIgnore
    private List<ConferenceDAO> conference;

    public static PersonneDAO fromEntity(Personne personne){
        if(personne==null){
            return null;
        }
        return PersonneDAO.builder()
                .id(personne.getId())
                .role(personne.getRole())
                .nomPersonne(personne.getNomPersonne())
                .prenomPersonne(personne.getPrenomPersonne())
                .numeroTel(personne.getNumeroTel())
                .adresse(personne.getAdresse())
                .motDePasse(personne.getMotDePasse())
                .mail(personne.getMail())
                .build();
    }
    public static Personne toEntity(PersonneDAO personneDAO){
        if(personneDAO==null){
            return null;
        }
        return Personne.builder()
                .role(personneDAO.getRole())
                .nomPersonne(personneDAO.getNomPersonne())
                .prenomPersonne(personneDAO.getPrenomPersonne())
                .numeroTel(personneDAO.getNumeroTel())
                .adresse(personneDAO.getAdresse())
                .provenance(personneDAO.getProvenance())
                .mail(personneDAO.getMail())
                .motDePasse(personneDAO.getMotDePasse())
                //.conference(ConferenceDAO.toEntity(personneDAO.getConference()))
                .build();
    }
}
