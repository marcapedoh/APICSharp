package com.example.APICSharp.Controller;

import com.example.APICSharp.Controller.API.ConferenceAPI;
import com.example.APICSharp.DAO.ConferenceDAO;
import com.example.APICSharp.Services.ConferenceServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ConferenceController implements ConferenceAPI {
    private ConferenceServices conferenceServices;

    @Autowired
    public ConferenceController(ConferenceServices conferenceServices){
        this.conferenceServices=conferenceServices;
    }
    @Override
    public ConferenceDAO save(ConferenceDAO conferenceDAO) {
        return conferenceServices.save(conferenceDAO);
    }

    @Override
    public ConferenceDAO findById(Integer id) {
        return conferenceServices.findById(id);
    }

    @Override
    public ConferenceDAO findByNomConference(String nomConference) {
        return conferenceServices.findByNomConference(nomConference);
    }

    @Override
    public List<ConferenceDAO> findAll() {
        return conferenceServices.findAll();
    }

    @Override
    public void delete(Integer id) {
        conferenceServices.delete(id);
    }
}
