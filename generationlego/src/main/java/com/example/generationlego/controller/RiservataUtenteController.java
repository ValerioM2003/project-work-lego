package com.example.generationlego.controller;
import com.example.generationlego.model.Utenti;
import com.example.generationlego.service.PlaysetService;
import com.example.generationlego.service.OrdineService;
import com.example.generationlego.service.UtenteService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

// localhost:8080/riservatautente
@Controller
@RequestMapping("/riservatautente")
public class RiservataUtenteController
{
    @Autowired
    private PlaysetService playsetService;

    @Autowired
    private OrdineService ordineService;

    @Autowired
    private UtenteService utenteService;

    @GetMapping
    public String getPage(
            HttpSession session,
            Model model,
            @RequestParam(name = "send", required = false) String send
    )
    {
        if(session.getAttribute("utente") == null)
            return "redirect:/loginutente";
        if(session.getAttribute("isAdmin") != null)
            return "redirect:/riservataadmin";
        if(session.getAttribute("isUser") ==null)
            return "redirect:/";
        Utenti utenti = (Utenti) session.getAttribute("utente");
        model.addAttribute("user", utenti);
        model.addAttribute("carrello", playsetService.getCarrello(session));
        model.addAttribute("totale", playsetService.getTotaleCarrello(session));
        model.addAttribute("send", send);
        return "riservatautente";
    }

    @GetMapping("/logout")
    public String userLogout(HttpSession session)
    {
        session.removeAttribute("isUser");
        session.removeAttribute("utente");
        return "redirect:/";
    }

    @GetMapping("/rimuovi")
    public String remove(
            @RequestParam("id") int id,
            HttpSession session
    )
    {
        playsetService.rimuoviDalCarrello(id, session);
        return "redirect:/riservatautente";
    }

    @GetMapping("/invia")
    public String send(HttpSession session)
    {
        ordineService.inviaOrdine(session);
        return "redirect:/riservatautente?send";
    }

    @PostMapping
    public String formManager(
            @Valid @ModelAttribute("user") Utenti utenti,
            BindingResult result,
            HttpSession session
    )
    {
        if(result.hasErrors())
            return "riservatautente";
        utenteService.registraUtente(utenti);
        session.setAttribute("utente", utenti);
        return "redirect:/riservatautente";
    }
}