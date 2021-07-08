package com.ap.webnotes.resource.notes;

import com.ap.webnotes.resource.notes.pojo.NotaPojo;

import java.util.List;

public class NotaResource {

    private List<NotaPojo> listaNoteResource;

    public List<NotaPojo> getListaNoteResource() {
        return listaNoteResource;
    }

    public NotaResource setListaNoteResource(List<NotaPojo> listaNoteResource) {
        this.listaNoteResource = listaNoteResource;
        return this;
    }
}
