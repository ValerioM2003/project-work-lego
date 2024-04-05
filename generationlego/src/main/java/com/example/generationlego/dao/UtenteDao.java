package com.example.generationlego.dao;

import com.example.generationlego.model.Utenti;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UtenteDao extends CrudRepository<Utenti, Integer> {
    Utenti findByUsernameAndPassword(String username, String password);

    Utenti findByUsername(String username);

    List<Utenti> findByProfilo(String profilo);
}
