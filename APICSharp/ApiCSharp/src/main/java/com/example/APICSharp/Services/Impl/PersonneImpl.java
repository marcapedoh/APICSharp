package com.example.APICSharp.Services.Impl;

import com.example.APICSharp.DAO.PersonneDAO;
import com.example.APICSharp.Exceptions.EntityNotFoundException;
import com.example.APICSharp.Exceptions.ErrorCodes;
import com.example.APICSharp.Exceptions.InvalidEntityException;
import com.example.APICSharp.Models.Personne;
import com.example.APICSharp.Repository.PersonneRepository;
import com.example.APICSharp.Services.PersonneServices;
import com.example.APICSharp.Validator.PersonneValidator;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@EnableAutoConfiguration
@Slf4j
@EnableWebMvc
public class PersonneImpl implements PersonneServices {

    private  ArticleImpl article;
    private PersonneRepository personneRepository;
    @Autowired
    public PersonneImpl(PersonneRepository personneRepository){
        this.personneRepository=personneRepository;
    }

    @Override
    public PersonneDAO save(PersonneDAO personneDAO) {
        List<String> errors= PersonneValidator.Validate(personneDAO);
        if(!errors.isEmpty()){
            log.error("personne not valid {}",personneDAO);
            throw new InvalidEntityException("la personne n'est pas valide", ErrorCodes.PERSONNE_NOT_VALID,errors);
        }
        return PersonneDAO.fromEntity(
                personneRepository.save(
                        PersonneDAO.toEntity(personneDAO)
                )
        );
    }

    @Override
    public PersonneDAO findById(Integer id) {
        if(id==null){
            log.error("l'id de la personne est null");
            return null;
        }
        Optional<Personne> personne=personneRepository.findById(id);
        return Optional.of(PersonneDAO.fromEntity(personne.get())).orElseThrow(()->
                new EntityNotFoundException("Aucune personne n'est trouvé pour cet ID "+id+" dans la base de donnée"));
    }

    @Override
    public PersonneDAO findByNomPersonne(String nomPersonne) {
        if(!StringUtils.hasLength(nomPersonne)){
            log.error("le nom de la personne est null il ne faut que ça soit comme ça");
            return null;
        }
        Optional<Personne> personne=personneRepository.findPersonneByNomPersonne(nomPersonne);
        return Optional.of(PersonneDAO.fromEntity(personne.get())).orElseThrow(()->
                new EntityNotFoundException("Aucune personne n'est trouvé pour ce nom dans notre base de donnée"));
    }
    @Override
    public PersonneDAO findByMailAndPassword(String mail,String password) {
        if(!StringUtils.hasLength(mail) && !StringUtils.hasLength(password)){
            log.error("l'adresse mail et le mot de passe sont vide");
            return null;
        }
        Optional<Personne> personne1=personneRepository.findPersonneByMailAndMotDePasse(mail,password);
        return Optional.of(PersonneDAO.fromEntity(personne1.get())).orElseThrow(()->
                new EntityNotFoundException("Aucune personne n'est trouvé pour ce nom dans notre base de donnée"));

    }

    @Override
    public List<PersonneDAO> findAll() {
        return personneRepository.findAll().stream()
                .map(PersonneDAO::fromEntity)
                .collect(Collectors.toList());
    }



    @Override
    public void delete(Integer id){
        if(id==null){
            log.error("l'id de la personne est null");
        }
        personneRepository.deleteById(id);
    }
}
