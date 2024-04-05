package com.example.generationlego.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "playset")
public class Playset
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String nome;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "id_brand", referencedColumnName = "id")
    private Brand brand;

    @Column
    private String eta;

    @Column
    private int numero_pezzi;

    @Column
    private float prezzo;

    @Column
    private String descrizione;

    @Column
    private String immagine;

    @Column
    private int scorte;
    @ManyToMany(cascade = CascadeType.REFRESH,fetch = FetchType.EAGER)
   @JoinTable(name="ordini_playset",joinColumns = @JoinColumn(name ="id_playset", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="id_ordine", referencedColumnName = "id"))
    private List<Ordini> ordini = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public String getEta() {
        return eta;
    }

    public void setEta(String eta) {
        this.eta = eta;
    }

    public int getNumero_pezzi() {
        return numero_pezzi;
    }

    public void setNumero_pezzi(int numero_pezzi) {
        this.numero_pezzi = numero_pezzi;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getImmagine() {
        return immagine;
    }

    public void setImmagine(String immagine) {
        this.immagine = immagine;
    }

    public int getScorte() {
        return scorte;
    }

    public void setScorte(int scorte) {
        this.scorte = scorte;
    }

    public List<Ordini> getOrdini() {
        return ordini;
    }

    public void setOrdini(List<Ordini> ordini) {
        this.ordini = ordini;
    }
}
