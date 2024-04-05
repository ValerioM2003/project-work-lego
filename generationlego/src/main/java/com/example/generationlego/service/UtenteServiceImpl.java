package com.example.generationlego.service;

import com.example.generationlego.dao.UtenteDao;
import com.example.generationlego.model.Playset;
import com.example.generationlego.model.Utenti;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class UtenteServiceImpl implements UtenteService {
    private LocalDate data2;
    @Autowired
    private UtenteDao utenteDao;


    @Override
    public String controlloLogin(String username, String password, HttpSession session) {
        Utenti utente = utenteDao.findByUsernameAndPassword(username, password);
        if (utente != null) {
            session.setAttribute("utente", utente);
            // Controlla il profilo dell'utente per decidere quale area riservata mostrare
            if ("admin".equals(utente.getProfilo())) {
                // Imposta un attributo di sessione per l'admin
                session.setAttribute("isAdmin", true);
                return "redirect:/riservataadmin"; // Oppure il path che preferisci per l'admin
            } else if ("user".equals(utente.getProfilo())) {
                // Imposta un attributo di sessione per l'utente
                session.setAttribute("isUser", true);
                return "redirect:/riservatautente"; // Oppure il path che preferisci per l'utente
            }
        }
        return "redirect:/loginutente?errore"; // Oppure il path/view che preferisci in caso di fallimento dell'autenticazione
    }

    @Override
    public void registraUtente(Utenti utente)
    {
        utenteDao.save(utente);
    }

    @Override
    public boolean controlloUsername(String username)
    {
        if(utenteDao.findByUsername(username) == null)
            return true;
        return false;
    }



    @Override
    public boolean controlloDifferenzaData(LocalDate data,  int anni) {
        LocalDate data2 = LocalDate.now();
        long differenzaAnni = ChronoUnit.YEARS.between(data, data2);
        if(Math.abs(differenzaAnni) >= anni) {
            return true;
        }else {
            return false;
        }


    }

    @Override
    public List<Utenti> getUtenti() {
        List<Utenti> utenti = (List<Utenti>) utenteDao.findAll();
        return utenti;
    }

    @Override
    public List<Utenti> getByProfilo(String profilo) {
        return (List<Utenti>) utenteDao.findByProfilo(profilo);
    }




}
