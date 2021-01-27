package com.ap.WebNotes.controller;


import com.ap.WebNotes.model.Nota;
import com.ap.WebNotes.service.implementations.NoteServiceImpl;
import com.ap.WebNotes.utils.enums.CodAzioneEnum;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utils.UtilsClass;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/web-notes", produces = MediaType.APPLICATION_JSON_VALUE)
public class WebNotesController extends UtilsClass {

    @Autowired
    private NoteServiceImpl noteService;

    @ApiOperation("Api che restituisce una lista di note")
    @GetMapping("/notes")
    public ResponseEntity<List<Nota>> getNote(
            @RequestParam(value = "mock", required = false, defaultValue = "false") Boolean mock
    ) {

        if (Boolean.TRUE.equals(mock)) {
            logger.info("Fine chiamata servizio home mock -> {}", mock);
            //SETTING MOCK TO DO
            return ResponseEntity.ok(Arrays.asList(new Nota()));
        }
        logger.info("Inizio chiamata al servizio home");
        List<Nota> listaNote = noteService.getAll();
        return ResponseEntity.ok(listaNote);
    }

    @ApiOperation("Api che permette di inserire una nota")
    @PostMapping("/inserisci/notes")
    public ResponseEntity<String> postNota(
            @RequestParam("codAzione") CodAzioneEnum codAzione,
            @RequestParam(value = "mock", required = false, defaultValue = "false") Boolean mock,
            @RequestBody Nota nota
    ) {
        if (Boolean.TRUE.equals(mock)) {
            logger.info("Fine chiamata servizio postNota, mock -> {}", mock);
        }
        String message = null;
        logger.info("Inizio chiamata servizio postNota, codAzione -> {}", codAzione);
        if (!nota.getContenuto().isEmpty() &&
                !nota.getTitolo().isEmpty()) {
            noteService.saveNota(nota);
            List<Nota> listaNote = noteService.getAll();
            if (!listaNote.isEmpty()) {
                message = "OK";
                return ResponseEntity.ok(message);
            } else {
                message = "KO";
                return ResponseEntity.ok(message);
            }
        } else {
            message = "KO";
            return ResponseEntity.ok(message);
        }
    }

    @ApiOperation("Api che permette di ricercare una nota per ID")
    @GetMapping("/nota/{id}")
    public ResponseEntity<Nota> getNota(
            @PathVariable("id") Integer id
    ) {
        if (id != null) {
            Optional<Nota> notaResult = noteService.findById(id);
            return ResponseEntity.ok(notaResult.get());
        }
        return ResponseEntity.ok(new Nota());
    }


    @ApiOperation("Api che permette di modificare una determinata nota")
    @PutMapping("/edit/{id}")
    public ResponseEntity<String> doUpdate(
            @RequestBody Nota nota,
            @PathVariable("id") Integer id
    ) {
        String message = null;
        if (id != null &&
                noteService.findById(id).isPresent() &&
                nota != null) {
            noteService.saveNota(nota);
            message = "OK";
            return ResponseEntity.ok(message);
        } else {
            message = "KO";
            return ResponseEntity.ok(message);
        }

    }

    @ApiOperation("Api che permette di eliminate una determinata nota")
    @DeleteMapping("/nota/{id}")
    public ResponseEntity<String> delete(
            @PathVariable("id") Integer id
    ) {
        String message = null;
        if (id != null) {
            Optional<Nota> foundId = noteService.findById(id);
            if (foundId.isPresent()) {
                noteService.delete(id);
                message = "OK";
            } else {
                message = "KO";
            }
            return ResponseEntity.ok(message);
        }
        message = "ID is null";
        return ResponseEntity.ok(message);
    }
}
