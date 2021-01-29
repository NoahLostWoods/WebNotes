package com.ap.webnotes.model;

import javax.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "note")
public class Nota implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String titolo;
    private String contenuto;

    public Integer getId() {
        return id;
    }

    public Nota setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getTitolo() {
        return titolo;
    }

    public Nota setTitolo(String titolo) {
        this.titolo = titolo;
        return this;
    }

    public String getContenuto() {
        return contenuto;
    }

    public Nota setContenuto(String contenuto) {
        this.contenuto = contenuto;
        return this;
    }
}
