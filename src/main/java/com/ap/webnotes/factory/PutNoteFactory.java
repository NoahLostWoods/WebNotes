package com.ap.webnotes.factory;

import com.ap.webnotes.command.businesslogic.PutNoteBusinessLogic;
import com.ap.webnotes.dto.NotaDto;
import com.ap.webnotes.model.Nota;
import com.ap.webnotes.utils.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PutNoteFactory {

    @Autowired
    private PutNoteBusinessLogic putNoteBusinessLogic;

    public Nota putNota(NotaDto dto, Integer id) {
        List<Nota> checkNotes = putNoteBusinessLogic.retrieveNotes();
        LocalDateTime retrieveTms = putNoteBusinessLogic.retrieveData(id);

        if (dto != null && id != null && !checkNotes.isEmpty() && retrieveTms != null) {
            if (!Utility.checkNotaExisistence(checkNotes, dto)) {
                return new Nota()
                        .setId(id)
                        .setTitolo(dto.getTitolo() != null ? dto.getTitolo() : null)
                        .setContenuto(dto.getContenuto() != null ? dto.getContenuto() : null)
                        .setTmsInserimento(retrieveTms)
                        .setTmsUltimoAggiornamento(LocalDateTime.now());
            } else {
                return new Nota();
            }
        } else {
            return null;
        }

    }

}
