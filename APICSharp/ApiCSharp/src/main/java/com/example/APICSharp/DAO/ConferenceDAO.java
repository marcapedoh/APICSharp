package com.example.APICSharp.DAO;

import com.example.APICSharp.Models.Conference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConferenceDAO {
    private Integer id;
    private String nomConference;
    private String theme;
    private String sigle;
    private Instant dateInscriptionConference;
    private Instant dateDeConference;
    private Instant dataSoumissionArticle;
    private Instant dateRetourDesdepotDarticle;

    @JsonIgnore
    private List<PersonneDAO> personnesDAO;

    public static ConferenceDAO fromEntity(Conference conference){
        if(conference==null){
            return null;
        }
        return ConferenceDAO.builder()
                .id(conference.getId())
                .nomConference(conference.getNomConference())
                .theme(conference.getTheme())
                .sigle(conference.getSigle())
                .dateInscriptionConference(conference.getDateInscriptionConference())
                .dateDeConference(conference.getDateDeConference())
                .dataSoumissionArticle(conference.getDataSoumissionArticle())
                .dateRetourDesdepotDarticle(conference.getDateRetourDesdepotDarticle())
                .build();
    }
    public static Conference toEntity(ConferenceDAO conferenceDAO){
        if(conferenceDAO==null){
            return null;
        }
        return Conference.builder()
                .nomConference(conferenceDAO.getNomConference())
                .theme(conferenceDAO.getTheme())
                .sigle(conferenceDAO.getSigle())
                .dateInscriptionConference(conferenceDAO.getDateInscriptionConference())
                .dateDeConference(conferenceDAO.getDateDeConference())
                .dataSoumissionArticle(conferenceDAO.getDataSoumissionArticle())
                .dateRetourDesdepotDarticle(conferenceDAO.getDateRetourDesdepotDarticle())
                .build();
    }

}

