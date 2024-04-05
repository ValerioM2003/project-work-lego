package com.example.generationlego.controller;
import com.example.generationlego.model.Playset;
import com.example.generationlego.service.OrdineService;
import com.example.generationlego.service.PlaysetService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

// localhost:8080/dettaglio?id=...
@Controller
@RequestMapping("/dettaglio")
public class DettaglioController {
    @Autowired
    private OrdineService ordineService;
    @Autowired
    private PlaysetService playsetService;

    @GetMapping
    public String getPage(
            @RequestParam("id") int id,
            Model model,HttpSession session,
            @RequestParam(name = "send", required = false) String send,
            @RequestParam(name = "add", required = false) String result

    ) {
        Playset playset = playsetService.getPlaysetById(id);
        model.addAttribute("playset", playset);
        model.addAttribute("result", result);
        model.addAttribute("totale", playsetService.getTotaleCarrello(session));
        model.addAttribute("carrello", playsetService.getCarrello(session));
        return "dettaglio";
    }

    @GetMapping("/aggiungi")
    public String add(
            @RequestParam("id") int id,
            HttpSession session,
            Model model
    ) {
        if (!playsetService.aggiungiAlCarrello(id, session)) {
            return "redirect:/dettaglio?id=" + id + "&add=n";
        } else {
            // Se il prodotto è stato aggiunto con successo al carrello, reindirizza alla pagina dettaglio con parametro 'add=y'
            return "redirect:/dettaglio?id=" + id + "&add=y";
        }

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
}