package com.ap.WebNotes.controller;


import com.ap.WebNotes.model.Nota;
import com.ap.WebNotes.service.implementations.NoteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import utils.UtilsClass;

import java.util.List;

@RestController
public class WebNotesController extends UtilsClass {

    @Autowired
    private NoteServiceImpl noteService;

    @GetMapping("/notes")
    public ResponseEntity<ModelAndView> getNota(
            @RequestParam(value = "mock", required = false, defaultValue = "false") Boolean mock
    ) {

        if (Boolean.TRUE.equals(mock)) {
            logger.info("Fine chiamata servizio home mock -> {}", mock);
            mav.setViewName("mockPage");
            return ResponseEntity.ok(mav);
        }

        logger.info("Inizio chiamata al servizio home");
        mav.setViewName("index");
        List<Nota> listaNote = noteService.getAll();
        mav.addObject("listaNote", listaNote);
        return ResponseEntity.ok(mav);
    }


    @DeleteMapping("/delete/{id}/notes")
    public ResponseEntity<String> deleteNota(
            @RequestParam(value = "mock", required = false, defaultValue = "false") Boolean mock,
            @PathVariable(value = "id", required = false) Integer id
    ) {
        if (Boolean.TRUE.equals(mock)) {
            logger.info("Fine chiamata servizio deleteNota. MOCK -> {}", mock);
            return ResponseEntity.ok("OK");
        }


        logger.info("Inizio chiamata servizio deleteNota");
        noteService.delete(new Nota().setId(id));
        return ResponseEntity.ok("OK");

    }


}
