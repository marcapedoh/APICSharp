package com.example.APICSharp.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
public class Article extends AbstactEntity{

    @Column(name = "TitreArticle")
    private String titre;

    @Column(name = "FichierJoint")
    private String pdf;
    @Column(name = "Description")
    private String description;
    @ManyToOne
    @JoinColumn(name ="idPersonne")
    private Personne personne;

}
