package com.example.generationlego.service;

import com.example.generationlego.model.Playset;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PlaysetService
{
    List<Playset> getPlayset();
    Playset getPlaysetById(int id);
    boolean aggiungiAlCarrello(int id, HttpSession session);
    List<Playset> getCarrello(HttpSession session);
    void rimuoviDalCarrello(int id, HttpSession session);
    double getTotaleCarrello(HttpSession session);
    void registraPlayset(Playset playset, String nome, int id_brand, String eta, int numero_pezzi,
                         float prezzo, String descrizione, MultipartFile immagine, int scorte);
    void cancellaPlayset(int id);

    Object validaPlayset(Playset playset, String nome, int id_brand, String eta, int numero_pezzi,
                         float prezzo, String descrizione);
    List<Playset> findFirst6Playset();

    List<Playset> getByBrand(String nome);
    List<Playset> getByEta(String eta);

    List<Playset> getByBrandAndEta(String nome, String eta);

    List<Playset> getByPrice(float prezzo);

    List<Playset> getByBrandAndEtaAndPrezzo(String nome, String eta, float prezzo);

    List<Playset> getByEtaAndPrezzo(String eta, float prezzo);

    List<Playset> getByBrandAndPrezzo(String nome,float prezzo);

}
