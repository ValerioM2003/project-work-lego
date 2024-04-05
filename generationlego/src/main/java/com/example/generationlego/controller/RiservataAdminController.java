package com.example.generationlego.controller;
import com.example.generationlego.model.Brand;
import com.example.generationlego.model.Ordini;
import com.example.generationlego.model.Playset;
import com.example.generationlego.model.Utenti;
import com.example.generationlego.service.BrandService;
import com.example.generationlego.service.OrdineService;
import com.example.generationlego.service.PlaysetService;
import com.example.generationlego.service.UtenteService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/riservataadmin")
public class RiservataAdminController
{
    @Autowired
    private UtenteService utenteService;
    @Autowired
    private OrdineService ordineService;
    @Autowired
    private PlaysetService playsetService;

    @Autowired
    private BrandService brandService;

    private Playset playset1;

    private Map<String, String> errori;

    @GetMapping
    public String getPage(
            Model model,
            HttpSession session,
            @RequestParam(name = "id", required = false) Integer id)
           // @RequestParam(name = "id_brand", required = false) Integer idBrand)
    {   if(session.getAttribute("utente") == null)
            return "redirect:/loginutente";
        if(session.getAttribute("isAdmin") == null){
            session.removeAttribute("utente");
            return "redirect:/loginutente";
           }
        else{
            List<Utenti> utenti = utenteService.getUtenti();
            model.addAttribute("utenti", utenti);
            List<Utenti> utenti2 = utenteService.getByProfilo("user");
            model.addAttribute("utenti2", utenti2);
            List<Ordini> ordini = ordineService.getOrdini();
            model.addAttribute("ordini", ordini);
        List<Playset> playset = playsetService.getPlayset();
        List<Brand> brands = brandService.getBrand();
            //Brand brand = id == null ? new Brand() : brandService.getBrandById(idBrand);
        if(errori == null)

            model.addAttribute("brands", brands);
           playset1 =  id == null ? new Playset() : playsetService.getPlaysetById(id);
        model.addAttribute("playset", playset);
       // model.addAttribute("brand", brand);
        model.addAttribute("playset1", playset1);
        model.addAttribute("errori", errori);
        return "riservataadmin";
        }
    }

    @SuppressWarnings("unchecked")
    @PostMapping
    public String formManager(
            @RequestParam("nome") String nome,
            @RequestParam("prezzo") float prezzo,
            @RequestParam("brand") int id_brand,
            @RequestParam("eta") String eta,
            @RequestParam("numero_pezzi") int numero_pezzi,
            @RequestParam("descrizione") String descrizione,
            @RequestParam(name = "immagine", required = false) MultipartFile immagine,
            @RequestParam("scorte") int scorte
    )
    {
        Object risultatoValidazione = playsetService.validaPlayset(playset1, nome, id_brand, eta, numero_pezzi, prezzo, descrizione);
        // se abbiamo errori di validazione
        if(risultatoValidazione != null)
        {
            playset1 = (Playset) ((Object[])risultatoValidazione)[0];
            errori = (Map<String, String>) ((Object[])risultatoValidazione)[1];
            return "redirect:/riservataadmin";
        }



        playsetService.registraPlayset(playset1, nome, id_brand, eta, numero_pezzi, prezzo, descrizione, immagine, scorte);
        return "redirect:/riservataadmin";
    }

    @GetMapping("/elimina")
    public String eliminaLibro(@RequestParam("id") int id)
    {
        playsetService.cancellaPlayset(id);
        return "redirect:/riservataadmin";
    }
    @GetMapping("/logout")
    public String userLogout(HttpSession session)
    {
        session.removeAttribute("isAdmin");
        session.removeAttribute("utente");
        return "redirect:/";
    }
}
