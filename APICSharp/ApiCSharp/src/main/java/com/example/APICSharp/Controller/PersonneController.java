package com.example.APICSharp.Controller;

import com.example.APICSharp.Controller.API.PersonneAPI;
import com.example.APICSharp.DAO.PersonneDAO;
import com.example.APICSharp.Services.PersonneServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@CrossOrigin("*")
public class PersonneController implements PersonneAPI {
    private final PersonneServices personneServices;
    @Autowired
    public PersonneController(PersonneServices personneServices){
        this.personneServices=personneServices;
    }
    @Override
    public PersonneDAO save(PersonneDAO personneDAO) {
        return personneServices.save(personneDAO);
    }

    @Override
    public PersonneDAO findById(Integer id) {
        return personneServices.findById(id);
    }

    @Override
    public PersonneDAO findByNomPersonne(String nomPersonne) {
        return personneServices.findByNomPersonne(nomPersonne);
    }

    @Override
    public PersonneDAO findByMailAndPassword(String mail, String password) {
        return personneServices.findByMailAndPassword(mail,password);
    }

    @Override
    public List<PersonneDAO> findAll() {
        return personneServices.findAll();
    }

    @Override
    public void delete(Integer id) {
        personneServices.delete(id);
    }
}
