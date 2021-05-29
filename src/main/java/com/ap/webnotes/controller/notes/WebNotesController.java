package com.ap.webnotes.controller.notes;

import com.ap.webnotes.assembler.notes.GetNotaAssembler;
import com.ap.webnotes.assembler.notes.GetNoteAssembler;
import com.ap.webnotes.command.notes.NoteCommand;
import com.ap.webnotes.dto.notes.NotaDto;
import com.ap.webnotes.factory.notes.PostNoteFactory;
import com.ap.webnotes.factory.notes.PutNoteFactory;
import com.ap.webnotes.model.IDs;
import com.ap.webnotes.model.notes.Nota;
import com.ap.webnotes.resource.notes.NotaResource;
import com.ap.webnotes.utils.UtilsClass;
import com.ap.webnotes.utils.enums.CodAzioneEnum;
import com.ap.webnotes.utils.mocks.NoteMocks;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
            logger.info("Fine chiamata servizio getNotes mock -> {}", mock);
            return NoteMocks.getNotesMocks();
        }

        logger.info("Inizio chiamata al servizio getNotes");
        List<Nota> listaNote = noteCommand.getNotes();
        GetNoteAssembler assembler = new GetNoteAssembler();

        logger.info("Fine chiamata al servizio getNotes");
        return ResponseEntity.ok(assembler.toResource(listaNote));
    }

    @ApiOperation("Api che permette di inserire una nota")
    @PostMapping("/note")
    public ResponseEntity<String> postNota(
            @RequestParam("codAzione") CodAzioneEnum codAzione,
            @RequestParam(value = "mock", required = false, defaultValue = "false") Boolean mock,
            @RequestBody NotaDto dto
    ) {
        if (Boolean.TRUE.equals(mock)) {
            logger.info("Fine chiamata servizio postNota, mock -> {}", mock);
            return ResponseEntity.ok("OK");
        }
        logger.info("Inizio chiamata servizio postNota, codAzione -> {}", codAzione);
        Nota nota = postNoteFactory.postNota(dto);
        String message = noteCommand.postNote(nota, dto);

        logger.info("Fine chiamata servizio postNota");
        return ResponseEntity.ok(message);

    }

    @ApiOperation("Api che permette di ricercare una nota per ID")
    @GetMapping("/notes/{id}")
    public ResponseEntity<NotaResource> getNota(
            @PathVariable("id") Integer id,
            @RequestParam(value = "mock", required = false, defaultValue = "false") Boolean mock,
            @RequestParam("flg") Boolean flg
    ) {
        if (Boolean.TRUE.equals(mock)) {
            logger.info("Fine chiamata servizio getNota mock -> {}, flg -> {}", mock, flg);
            return NoteMocks.getNotesMocks();
        }
        logger.info("Inizio chiamata servizio getNota");
        Nota notaResult = noteCommand.getSingleNote(id, flg);
        GetNotaAssembler assembler = new GetNotaAssembler();

        logger.info("Fine chiamata servizio getNota");
        return ResponseEntity.ok(assembler.toResource(notaResult));

    }

    @ApiOperation("Api che permette di modificare una determinata nota")
    @PutMapping("/notes/{id}")
    public ResponseEntity<String> putNote(
            @RequestBody NotaDto dto,
            @PathVariable("id") @Validated Integer id,
            @RequestParam(value = "mock", required = false, defaultValue = "false") Boolean mock,
            @RequestParam("flg") Boolean flg
    ) {
        if (Boolean.TRUE.equals(mock))
            logger.info("Fine chiamata servizio putNote mock -> {}", mock);

        logger.info("Inizio chiamata servizio putNote");

        // put nota on database
        Nota nota = putNoteFactory.putNota(dto, id, flg);
        String message = (noteCommand.putNote(nota));
        logger.info("Fine chiamata servizio putNote");
        return ResponseEntity.ok(message);
    }

    @ApiOperation("Api che permette di eliminate una determinata nota")
    @DeleteMapping("/notes/{id}")
    public ResponseEntity<String> deleteNota(
            @PathVariable("id") @Validated Integer id,
            @RequestParam(value = "mock", required = false, defaultValue = "false") Boolean mock
    ) {
        if (Boolean.TRUE.equals(mock))
            logger.info("Fine chiamata servizio deleteNota mock -> {}", mock);

        logger.info("Inizio chiamata servizio deleteNota");

        String message = noteCommand.deleteSingleNote(id);

        logger.info("Fine chiamata servizio deleteNota");
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
        List<String> message = noteCommand.deleteMultipleNote(dto);
        logger.info("Fine chiamata al servizio deleteNotes");
        return ResponseEntity.ok(message);
    }
}