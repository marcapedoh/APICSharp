package com.example.APICSharp.Repository;

import com.example.APICSharp.Models.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface PersonneRepository extends JpaRepository<Personne,Integer> {
    Optional<Personne> findPersonneByNomPersonne(String nomPersonne);
    Optional<Personne> findPersonneByMailAndMotDePasse(String mail,String password);
}
