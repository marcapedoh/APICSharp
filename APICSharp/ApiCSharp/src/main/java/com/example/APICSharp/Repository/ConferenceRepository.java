package com.example.APICSharp.Repository;

import com.example.APICSharp.Models.Conference;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ConferenceRepository extends JpaRepository<Conference,Integer> {
    Optional<Conference>findConferenceByNomConference(String nomConference);
}
