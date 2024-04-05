package com.example.generationlego.dao;

import com.example.generationlego.model.Playset;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlaysetDao extends CrudRepository<Playset, Integer>{
    Page<Playset> findAll(Pageable pageable);

    List<Playset> findByBrandNome(String nome);

    List<Playset> findByEta(String eta);

    List<Playset> findByBrandNomeAndEta(String nome, String eta);

    List<Playset> findByPrezzoLessThan(float prezzo);

    List<Playset> findByBrandNomeAndEtaAndPrezzoLessThan(String nome, String eta, float prezzo);

    List<Playset> findByEtaAndPrezzoLessThan(String eta, float prezzo);

    List<Playset> findByBrandNomeAndPrezzoLessThan(String nome, float prezzo);
}
