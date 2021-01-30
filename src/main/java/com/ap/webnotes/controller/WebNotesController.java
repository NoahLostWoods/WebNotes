package com.ap.webnotes.controller;


import com.ap.webnotes.assembler.GetNoteAssembler;
import com.ap.webnotes.dto.NotaDto;
import com.ap.webnotes.factory.PutNoteFactory;
import com.ap.webnotes.model.IDs;
import com.ap.webnotes.model.Nota;
import com.ap.webnotes.resource.NotaResource;
import com.ap.webnotes.resource.pojo.NotaPojo;
import com.ap.webnotes.service.implementations.NoteServiceImpl;
import com.ap.webnotes.utils.enums.CodAzioneEnum;
import com.ap.webnotes.utils.mocks.NoteMocks;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utils.UtilsClass;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value = "/web-notes", produces = MediaType.APPLICATION_JSON_VALUE)
public class WebNotesController extends UtilsClass {

    @Autowired
    private NoteServiceImpl noteService;

    @ApiOperation("Api che restituisce una lista di note")
    @GetMapping("/notes")
    public ResponseEntity<NotaResource> getNote(
            @RequestParam(value = "mock", required = false, defaultValue = "false") Boolean mock
    ) {

        if (Boolean.TRUE.equals(mock)) {
            logger.info("Fine chiamata servizio home mock -> {}", mock);
            return NoteMocks.getNotesMocks();
        }

        logger.info("Inizio chiamata al servizio home");
        List<Nota> listaNote = noteService.getAll();
        GetNoteAssembler assembler = new GetNoteAssembler();
        return ResponseEntity.ok(assembler.toResource(listaNote));
    }

    @ApiOperation("Api che permette di inserire una nota")
    @PostMapping("/notes")
    public ResponseEntity<String> postNota(
            @RequestParam("codAzione") CodAzioneEnum codAzione,
            @RequestParam(value = "mock", required = false, defaultValue = "false") Boolean mock,
            @RequestBody NotaDto dto
    ) {
        if (Boolean.TRUE.equals(mock)) {
            logger.info("Fine chiamata servizio postNota, mock -> {}", mock);
            return ResponseEntity.ok("OK");
        }

        //Move the elaboratio into a factory class.
        Nota nota = new Nota()
                .setId(dto.getId())
                .setTitolo(dto.getTitolo())
                .setContenuto(dto.getContenuto());
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
    @GetMapping("/notes/{id}")
    public ResponseEntity<NotaResource> getNota(
            @PathVariable("id") Integer id,
            @RequestParam(value = "mock", required = false, defaultValue = "false") Boolean mock
    ) {
        if (Boolean.TRUE.equals(mock)) {
            logger.info("Fine chiamata servizio getNota mock -> {}", mock);
            return NoteMocks.getNotesMocks();
        }
        logger.info("Inizio chiamata servizio getNota");
        if (id != null) {
            Optional<Nota> notaResult = noteService.findById(id);
            if (notaResult.isPresent()) {
                GetNoteAssembler assembler = new GetNoteAssembler();
                NotaResource resource = assembler.toResource(notaResult);
                return ResponseEntity.ok(resource);
            } else {
                ResponseEntity.ok(new NotaResource());
            }
        }
        return ResponseEntity.ok(new NotaResource());
    }


    @ApiOperation("Api che permette di modificare una determinata nota")
    @PutMapping("/notes/{id}")
    public ResponseEntity<String> putNote(
            @RequestBody NotaDto dto,
            @PathVariable("id") Integer id,
            @RequestParam(value = "mock", required = false, defaultValue = "false") Boolean mock
    ) {
        if (Boolean.TRUE.equals(mock))
            logger.info("Fine chiamata servizio putNote mock -> {}", mock);

        PutNoteFactory factory = new PutNoteFactory();
        logger.info("Inizio chiamata servizio putNote");
        String message = null;
        if (id != null &&
                noteService.findById(id).isPresent() &&
                dto != null) {
            noteService.saveNota(factory.putNota(dto));
            message = "OK";
            return ResponseEntity.ok(message);
        } else {
            message = "KO";
            return ResponseEntity.ok(message);
        }

    }

    @ApiOperation("Api che permette di eliminate una determinata nota")
    @DeleteMapping("/notes/{id}")
    public ResponseEntity<String> deleteNota(
            @PathVariable("id") Integer id,
            @RequestParam(value = "mock", required = false, defaultValue = "false") Boolean mock
    ) {
        if (Boolean.TRUE.equals(mock))
            logger.info("Fine chiamata servizio deleteNota mock -> {}", mock);

        logger.info("Inizio chiamata servizio deleteNota");
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

    @ApiOperation("Api che permette di eliminare n note")
    @DeleteMapping("/notes")
    public ResponseEntity<String> deleteNotes(
            @RequestBody IDs dto,
            @RequestParam(value = "mock", required = false, defaultValue = "false") Boolean mock
    ) {
        if (Boolean.TRUE.equals(mock))
            logger.info("Fine chiamata servizio deleteNotes mock -> {}", mock);

        logger.info("Inizio chiamata al servizio deleteNotes");
        if (dto != null) {
            for (Integer id : dto.getListIds()) {
                noteService.delete(id);
            }
        } else {
            return ResponseEntity.ok("KO");
        }
        return ResponseEntity.ok("OK");
    }
}