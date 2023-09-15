package com.example.APICSharp.Models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
public class Personne extends AbstactEntity{

    @Column(name = "Role",nullable = false)
    private String role;

    @Column(name = "Nom",nullable = false)
    private String nomPersonne;
    @Column(name = "Prenom",nullable = false)
    private String prenomPersonne;
    @Column(name = "numeroTel",nullable = false)
    private String numeroTel;
    @Column(name = "Adresse",nullable = false)
    private String adresse;
    @Column(name = "Provenance")
    private String provenance;

    @Column(name = "motDePasse")
    private String motDePasse;
    @Column(name = "mail")
    private String mail;
    @OneToMany(mappedBy = "personne")
    private List<Article> articles;
    @OneToMany(mappedBy = "personne1")
    private List<Conference> conference;
}
