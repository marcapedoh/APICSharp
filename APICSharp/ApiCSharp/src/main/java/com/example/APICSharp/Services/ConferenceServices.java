package com.example.APICSharp.Services;

import com.example.APICSharp.DAO.ConferenceDAO;

import java.util.List;

public interface ConferenceServices {
    ConferenceDAO save(ConferenceDAO conferenceDAO);
    ConferenceDAO findById(Integer id);
    ConferenceDAO findByNomConference(String nomConference);
    List<ConferenceDAO> findAll();
    void delete(Integer id);

}
