package com.ap.webnotes.resource.pojo;

public class NotaPojo {

    private Integer id;
    private String titolo;
    private String contenuto;

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
}
