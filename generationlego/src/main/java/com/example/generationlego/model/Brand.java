package com.example.generationlego.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "brand")
public class Brand
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String nome;
    @OneToMany (mappedBy = "brand",cascade = CascadeType.REMOVE,fetch = FetchType.EAGER, orphanRemoval = true)

    private List<Playset> playset = new ArrayList<>();

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

    public List<Playset> getPlayset() {
        return playset;
    }

    public void setPlayset(List<Playset> playset) {
        this.playset = playset;
    }
}
