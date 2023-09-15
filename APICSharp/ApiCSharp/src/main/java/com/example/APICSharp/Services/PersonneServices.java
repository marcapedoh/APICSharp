package com.example.APICSharp.Services;

import com.example.APICSharp.DAO.ArticleDAO;
import com.example.APICSharp.DAO.PersonneDAO;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public interface PersonneServices {
    PersonneDAO save(PersonneDAO personneDAO);
    PersonneDAO findById(Integer id);
    PersonneDAO findByNomPersonne(String nomPersonne);
    PersonneDAO findByMailAndPassword(String mail,String password);
    List<PersonneDAO> findAll();
    void delete(Integer id);
}
