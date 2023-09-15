package com.example.APICSharp.Models;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
public class Conference extends AbstactEntity{

    @Column(name = "NomConference")
    private String nomConference;
    @Column(name = "Theme")
    private String theme;
    @Column(name = "SigleConference")
    private String sigle;

    @Column(name = "DateInscriptionConference")
    private Instant dateInscriptionConference;
    @Column(name = "DateConference")
    private Instant dateDeConference;
    @Column(name = "DateSoumissionArticle")
    private Instant dataSoumissionArticle;
    @Column(name = "DateResultatDesRetourdesArticles")
    private Instant dateRetourDesdepotDarticle;
    @ManyToOne
    @JoinColumn(name ="idPersonne")
    private Personne personne1;

}
