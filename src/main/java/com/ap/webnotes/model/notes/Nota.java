package com.ap.webnotes.model.notes;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "note")
public class Nota implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String titolo;
    private String contenuto;
    private LocalDateTime tmsUltimoAggiornamento;
    private LocalDateTime tmsInserimento;

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

    public LocalDateTime getTmsUltimoAggiornamento() {
        return tmsUltimoAggiornamento;
    }

    public Nota setTmsUltimoAggiornamento(LocalDateTime tmsUltimoAggiornamento) {
        this.tmsUltimoAggiornamento = tmsUltimoAggiornamento;
        return this;
    }

    public LocalDateTime getTmsInserimento() {
        return tmsInserimento;
    }

    public Nota setTmsInserimento(LocalDateTime tmsInserimento) {
        this.tmsInserimento = tmsInserimento;
        return this;
    }
}
