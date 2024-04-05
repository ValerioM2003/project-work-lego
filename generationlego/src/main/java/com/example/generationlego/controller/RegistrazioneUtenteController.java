package com.example.generationlego.controller;
import com.example.generationlego.model.Utenti;
import com.example.generationlego.service.UtenteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//localhost:8080/registrazioneutente
@Controller
@RequestMapping("/registrazioneutente")
public class RegistrazioneUtenteController {
    @Autowired
    private UtenteService utenteService;

    @GetMapping
    public String getPage(Model model){
        Utenti utente = new Utenti();
        model.addAttribute("utente", utente);
        return "registrazioneutente";

    }
    @PostMapping
    public String formManager(@Valid @ModelAttribute("utente")Utenti utente,
                              BindingResult result,
                              Model model){
        if(result.hasErrors())
            return "registrazioneutente";
        if(!utenteService.controlloUsername(utente.getUsername())){
            model.addAttribute("duplicato", "Username non disponibile");
            return "registrazioneutente";
        }if(!utenteService.controlloDifferenzaData(utente.getData(),16)){
            model.addAttribute("dataError","Per iscriverti devi avere almeno 16 anni");
            return "registrazioneutente";
        }
        utente.setProfilo("user");
        utenteService.registraUtente(utente);
        return "redirect:/loginutente";
    }

}

