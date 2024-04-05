package com.example.generationlego.service;

import com.example.generationlego.dao.PlaysetDao;
import com.example.generationlego.model.Playset;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
@Service
public class PlaysetServiceImpl implements PlaysetService{

    @Autowired
    private PlaysetDao playsetDao;
    @Autowired
    private BrandService brandService;
    @Override
    public List<Playset> getPlayset() {
        List<Playset> playset = (List<Playset>) playsetDao.findAll();
        return playset;
    }

    @Override
    public Playset getPlaysetById(int id) {
        Optional<Playset> playsetOptional = playsetDao.findById(id);
        if(playsetOptional.isPresent())
            return playsetOptional.get();
        return null;
    }

    @Override
    public boolean aggiungiAlCarrello(int id, HttpSession session) {
        Playset playset = getPlaysetById(id);
        List<Playset> carrello;
        if(session.getAttribute("carrello") != null)
        {
            carrello = (List<Playset>) session.getAttribute("carrello");
            for(Playset p : carrello)
                if(p.getId() == id)
                    return false;
            carrello.add(playset);
            session.setAttribute("carrello", carrello);
            return true;
        } else {
            carrello = new ArrayList<>();
            carrello.add(playset);
            session.setAttribute("carrello", carrello);
            return true;
        }
    }

    @Override
    public List<Playset> getCarrello(HttpSession session) {
        if(session.getAttribute("carrello") != null)
            return (List<Playset>) session.getAttribute("carrello");
        return null;
    }

    @Override
    public void rimuoviDalCarrello(int id, HttpSession session) {
        List<Playset> carrello = (List<Playset>) session.getAttribute("carrello");
        for(Playset p : carrello)
            if(p.getId() == id)
            {
                carrello.remove(p);
                break;
            }
        carrello = carrello
                .stream()
                .filter(p -> p.getId() != id)
                .collect(Collectors.toList());
        if(carrello.size() > 0)
            session.setAttribute("carrello", carrello);
        else
            session.removeAttribute("carrello");

    }

    @Override
    public double getTotaleCarrello(HttpSession session) {
        List<Playset> carrello = (List<Playset>) session.getAttribute("carrello");
        if(carrello != null)
            return carrello
                    .stream()
                    .mapToDouble(Playset::getPrezzo)
                    .reduce(0.0, (p1,p2) -> p1 + p2);
        return 0;
    }

    @Override
    public void registraPlayset(Playset playset, String nome, int id_brand, String eta, int numero_pezzi,
                                float prezzo, String descrizione, MultipartFile immagine, int scorte) {
        playset.setNome(nome);
        playset.setBrand(brandService.getBrandById(id_brand));
        playset.setEta(eta);
        playset.setNumero_pezzi(numero_pezzi);
        playset.setPrezzo(prezzo);
        playset.setDescrizione(descrizione);
        playset.setScorte(scorte);
        if(immagine != null && !immagine.isEmpty())
        {
            try
            {
                String formato = immagine.getContentType();
                String immagineCodificata = "data:" + formato + ";base64," +
                        Base64.getEncoder().encodeToString(immagine.getBytes());
                playset.setImmagine(immagineCodificata);
            } catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
        }
        playsetDao.save(playset);
    }

    @Override
    public void cancellaPlayset(int id) {
        playsetDao.deleteById(id);
    }

    @Override
    public Object validaPlayset(Playset playset, String nome, int id_brand,
                                String eta, int numero_pezzi, float prezzo, String descrizione) {
        playset.setBrand(brandService.getBrandById(id_brand));
        playset.setNome(nome);
        Map<String, String> errori = new HashMap<>();
        if(!Pattern.matches("[a-zA-Z0-9\\sàèìòù,.-]{1,50}", nome))
            errori.put("nome", "Caratteri non ammessi");
        try {
            playset.setPrezzo(prezzo);
        } catch (Exception e)
        {
            errori.put("prezzo", "Il prezzo indicato non è corretto");
        }
        if(errori.size() > 0)
            return new Object[]{playset,errori};
        else
            return null;
    }

    @Override
    public List<Playset> findFirst6Playset() {
        Pageable first6 = PageRequest.of(0, 6);

        // Usa il metodo findAll del repository con l'oggetto Pageable creato
        Page<Playset> playsetPage = playsetDao.findAll(first6);

        // Restituisce la lista degli utenti
        return playsetPage.getContent();
    }

    @Override
    public List<Playset> getByBrand(String nome) {
        List<Playset> playsetList = playsetDao.findByBrandNome(nome);
        return playsetList;
    }

    @Override
    public List<Playset> getByEta(String eta) {
       List<Playset> playset = (List<Playset>) playsetDao.findByEta(eta);
       return  playset;
    }

    @Override
    public List<Playset> getByBrandAndEta(String nome, String eta) {
        List<Playset> playset = playsetDao.findByBrandNomeAndEta(nome, eta);
        return playset;
    }

    @Override
    public List<Playset> getByPrice(float prezzo) {
        List<Playset> playsetList =  playsetDao.findByPrezzoLessThan(prezzo);
        return playsetList;
    }

    @Override
    public List<Playset> getByBrandAndEtaAndPrezzo(String nome, String eta, float prezzo) {
        List<Playset> playsetList = playsetDao.findByBrandNomeAndEtaAndPrezzoLessThan(nome, eta, prezzo);
        return playsetList;
    }

    @Override
    public List<Playset> getByEtaAndPrezzo(String eta, float prezzo) {
        List<Playset> playsetList = playsetDao.findByEtaAndPrezzoLessThan(eta, prezzo);
        return playsetList;
    }

    @Override
    public List<Playset> getByBrandAndPrezzo(String nome, float prezzo) {
        List<Playset> playsetList = playsetDao.findByBrandNomeAndPrezzoLessThan(nome, prezzo);
        return playsetList;
    }

}
