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

import java.util.List;

@Controller
@RequestMapping("/")
public class IndexController {
    @Autowired
    private OrdineService ordineService;
    @Autowired
    private PlaysetService playsetService;
    @GetMapping
    public String getPage(  HttpSession session,
                            Model model,
                            @RequestParam(name = "send", required = false) String send){
        List<Playset> playset = playsetService.findFirst6Playset();
        model.addAttribute("playsets",playset);
        model.addAttribute("carrello", playsetService.getCarrello(session));
        model.addAttribute("send", send);
        model.addAttribute("totale", playsetService.getTotaleCarrello(session));
        return "index";

    }
    @GetMapping("/aggiungi")
    public String add(@RequestParam("id") int id, HttpSession session) {
        if (!playsetService.aggiungiAlCarrello(id, session))
            return "redirect:/?add=n"; // Reindirizza alla stessa pagina con il parametro 'add=n'
        return "redirect:/?add=y"; // Reindirizza alla stessa pagina con il parametro 'add=y'
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
