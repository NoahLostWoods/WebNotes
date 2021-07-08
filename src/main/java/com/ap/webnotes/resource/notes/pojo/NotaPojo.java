package com.ap.webnotes.resource.notes.pojo;

import java.time.LocalDateTime;

public class NotaPojo {

    private Integer id;
    private String titolo;
    private String contenuto;
    private LocalDateTime tmsInserimento;
    private LocalDateTime tmsUltimoAggiornamento;

    public Integer getId() {
        return id;
    }

    public NotaPojo setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getTitolo() {
        return titolo;
    }

    public NotaPojo setTitolo(String titolo) {
        this.titolo = titolo;
        return this;
    }

    public String getContenuto() {
        return contenuto;
    }

    public NotaPojo setContenuto(String contenuto) {
        this.contenuto = contenuto;
        return this;
    }

    public LocalDateTime getTmsUltimoAggiornamento() {
        return tmsUltimoAggiornamento;
    }

    public NotaPojo setTmsUltimoAggiornamento(LocalDateTime tmsUltimoAggiornamento) {
        this.tmsUltimoAggiornamento = tmsUltimoAggiornamento;
        return this;
    }

    public LocalDateTime getTmsInserimento() {
        return tmsInserimento;
    }

    public NotaPojo setTmsInserimento(LocalDateTime tmsInserimento) {
        this.tmsInserimento = tmsInserimento;
        return this;
    }
}
