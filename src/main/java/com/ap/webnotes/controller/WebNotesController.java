package com.ap.webnotes.controller;

import com.ap.webnotes.assembler.GetNoteAssembler;
import com.ap.webnotes.command.NoteCommand;
import com.ap.webnotes.dto.NotaDto;
import com.ap.webnotes.factory.PostNoteFactory;
import com.ap.webnotes.factory.PutNoteFactory;
import com.ap.webnotes.model.IDs;
import com.ap.webnotes.model.Nota;
import com.ap.webnotes.resource.NotaResource;
import com.ap.webnotes.service.implementations.NoteServiceImpl;
import com.ap.webnotes.utils.UtilsClass;
import com.ap.webnotes.utils.enums.CodAzioneEnum;
import com.ap.webnotes.utils.mocks.NoteMocks;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/web/notes", produces = MediaType.APPLICATION_JSON_VALUE)
public class WebNotesController extends UtilsClass {


    @Autowired
    private NoteCommand noteCommand;
    @Autowired
    private PostNoteFactory postNoteFactory;
    @Autowired
    private PutNoteFactory putNoteFactory;

    @ApiOperation("Api che restituisce una lista di note")
    @GetMapping("/notes")
    public ResponseEntity<NotaResource> getNote(
            @RequestParam(value = "mock", required = false, defaultValue = "false") Boolean mock
    ) {

        if (Boolean.TRUE.equals(mock)) {
            logger.info("Fine chiamata servizio getNote mock -> {}", mock);
            return NoteMocks.getNotesMocks();
        }

        logger.info("Inizio chiamata al servizio getNote");
        List<Nota> listaNote = noteCommand.getNotes();
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
        String message = null;
        List<Nota> checkNotes = noteCommand.getNotes();
        if (!checkNotaExisistence(checkNotes, dto)) {
            Nota nota = postNoteFactory.postNota(dto);
            logger.info("Inizio chiamata servizio postNota, codAzione -> {}", codAzione);
            noteCommand.postNote(nota);
            List<Nota> listaNote = noteCommand.getNotes();
            if (!listaNote.isEmpty()) {
                message = "OK";
            } else {
                message = "KO";
            }
            return ResponseEntity.ok(message);
        }
        return null;
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
            Nota notaResult = noteCommand.getSingleNote(id);
            if (notaResult != null) {
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

        logger.info("Inizio chiamata servizio putNote");
        String message = null;
        Nota singleNote = noteCommand.getSingleNote(id);

        if (id != null && singleNote != null && dto != null) {
            noteCommand.putNote(putNoteFactory.putNota(dto, id, singleNote.getTmsInserimento()));
            message = "OK";
        } else {
            message = "KO";
        }
        return ResponseEntity.ok(message);

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
            Nota foundId = noteCommand.getSingleNote(id);
            if (foundId != null) {
                noteCommand.deleteSingleNote(id);
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
    public ResponseEntity<List<String>> deleteNotes(
            @RequestBody @Validated IDs dto,
            @RequestParam(value = "mock", required = false, defaultValue = "false") Boolean mock
    ) {
        if (Boolean.TRUE.equals(mock))
            logger.info("Fine chiamata servizio deleteNotes mock -> {}", mock);

        logger.info("Inizio chiamata al servizio deleteNotes");

        return ResponseEntity.ok(noteCommand.deleteMultipleNote(dto));
    }
}