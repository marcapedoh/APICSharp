package com.example.APICSharp.Services.Impl;

import com.example.APICSharp.DAO.ConferenceDAO;
import com.example.APICSharp.DAO.PersonneDAO;
import com.example.APICSharp.Exceptions.EntityNotFoundException;
import com.example.APICSharp.Exceptions.ErrorCodes;
import com.example.APICSharp.Exceptions.InvalidEntityException;
import com.example.APICSharp.Models.Conference;
import com.example.APICSharp.Models.Personne;
import com.example.APICSharp.Repository.ConferenceRepository;
import com.example.APICSharp.Services.ConferenceServices;
import com.example.APICSharp.Validator.ConferenceValidator;
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
@Slf4j
@EnableWebMvc
@EnableAutoConfiguration
public class ConferenceImpl implements ConferenceServices {
    private final ConferenceRepository conferenceRepository;

    @Autowired
    public ConferenceImpl(ConferenceRepository conferenceRepository) {
        this.conferenceRepository = conferenceRepository;
    }

    @Override
    public ConferenceDAO save(ConferenceDAO conferenceDAO) {
        List<String>errors= ConferenceValidator.Validate(conferenceDAO);
        if(!errors.isEmpty()){
            log.error("conference not valid{}",conferenceDAO);
            throw new InvalidEntityException("La conference passé n'est pas valid", ErrorCodes.CONFERENCE_NOT_VALID,errors);
        }
        return ConferenceDAO.fromEntity(
                conferenceRepository.save(
                        ConferenceDAO.toEntity(conferenceDAO)
                ));
    }

    @Override
    public ConferenceDAO findById(Integer id) {
        if(id==null){
            log.error("l'id de la conference est null");
        }
        Optional<Conference> conference=conferenceRepository.findById(id);
        return Optional.of(ConferenceDAO.fromEntity(conference.get())).orElseThrow(()->
                new EntityNotFoundException("Aucune conference n'est trouvé pour cet ID "+id+" dans la base de donnée"));
    }

    @Override
    public ConferenceDAO findByNomConference(String nomConference) {
        if(!StringUtils.hasLength(nomConference)){
            log.error("le nom de la conference est null il ne faut que ça soit comme ça");
            return null;
        }
        Optional<Conference> conference=conferenceRepository.findConferenceByNomConference(nomConference);
        return Optional.of(ConferenceDAO.fromEntity(conference.get())).orElseThrow(()->
                new EntityNotFoundException("Aucune conference n'est trouvé pour ce nom dans notre base de donnée"));
    }

    @Override
    public List<ConferenceDAO> findAll() {
        return conferenceRepository.findAll().stream()
                .map(ConferenceDAO::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id==null){
            log.error("l'id de la conference est null");
        }
        conferenceRepository.deleteById(id);

    }
}
