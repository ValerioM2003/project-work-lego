package com.example.generationlego.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="ordini")
public class Ordini {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private LocalDate data;
    @Column
    private double importo;
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name="id_utente",referencedColumnName = "id")
    private  Utenti utenti ;
    @ManyToMany(cascade = CascadeType.REFRESH,fetch = FetchType.EAGER)
    @JoinTable(name="ordini_playset",joinColumns = @JoinColumn(name ="id_ordine", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name="id_playset", referencedColumnName = "id"))
    private List<Playset> playset = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public double getImporto() {
        return importo;
    }

    public void setImporto(double importo) {
        this.importo = importo;
    }

    public Utenti getUtenti() {
        return utenti;
    }

    public void setUtenti(Utenti utenti) {
        this.utenti = utenti;
    }

    public List<Playset> getPlayset() {
        return playset;
    }

    public void setPlayset(List<Playset> playset) {
        this.playset = playset;
    }
}
