package com.example.generationlego.service;

import com.example.generationlego.model.Ordini;
import jakarta.servlet.http.HttpSession;

import java.util.List;

public interface OrdineService {
    void inviaOrdine(HttpSession session);
    List<Ordini> getOrdini();
}
