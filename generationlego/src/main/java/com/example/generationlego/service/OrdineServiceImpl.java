package com.example.generationlego.service;

import com.example.generationlego.dao.OrdiniDao;
import com.example.generationlego.model.Ordini;
import com.example.generationlego.model.Playset;
import com.example.generationlego.model.Utenti;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class OrdineServiceImpl implements OrdineService{
    @Autowired
    private OrdiniDao ordiniDao;
    @Autowired
    private PlaysetService playsetService;
    @Override
    public void inviaOrdine(HttpSession session) {
        List<Playset> carrello = (List<Playset>) session.getAttribute("carrello");
        Utenti utente = (Utenti) session.getAttribute("utente");
        if(carrello!= null && utente!=null)
        {
            Ordini ordine = new Ordini();
            ordine.setData(LocalDate.now());
            ordine.setUtenti(utente);
            ordine.setPlayset(carrello);
            ordine.setImporto(playsetService.getTotaleCarrello(session));
            ordiniDao.save(ordine);
            utente.getOrdini().add(ordine);
            session.setAttribute("utente", utente);
            session.removeAttribute("carrello");
        }
    }

    @Override
    public List<Ordini> getOrdini() {
        List<Ordini> ordini = (List<Ordini>) ordiniDao.findAll();
        return ordini;
    }
}
