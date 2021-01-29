package com.ap.webnotes.dto;

public class NotaDto {

    private Integer id;
    private String titolo;
    private String contenuto;

    public Integer getId() {
        return id;
    }

    public NotaDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getTitolo() {
        return titolo;
    }

    public NotaDto setTitolo(String titolo) {
        this.titolo = titolo;
        return this;
    }

    public String getContenuto() {
        return contenuto;
    }

    public NotaDto setContenuto(String contenuto) {
        this.contenuto = contenuto;
        return this;
    }
}
