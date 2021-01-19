package com.ap.WebNotes.controller;


import com.ap.WebNotes.model.Nota;
import com.ap.WebNotes.service.implementations.NoteServiceImpl;
import com.ap.WebNotes.utils.enums.CodAzione;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import utils.UtilsClass;

import java.util.List;

@RestController
@RequestMapping(value = "/web-notes", produces = MediaType.APPLICATION_JSON_VALUE)
public class WebNotesController extends UtilsClass {

    @Autowired
    private NoteServiceImpl noteService;

    @GetMapping("/notes")
    public ModelAndView getNota(
            @RequestParam(value = "mock", required = false, defaultValue = "false") Boolean mock
    ) {

        if (Boolean.TRUE.equals(mock)) {
            logger.info("Fine chiamata servizio home mock -> {}", mock);
            mav.setViewName("mockPage");
            return mav;
        }

        logger.info("Inizio chiamata al servizio home");
        mav.setViewName("index");
        List<Nota> listaNote = noteService.getAll();
        mav.addObject("listaNote", listaNote);
        mav.addObject("nota", new Nota());
        return mav;
    }

    @RequestMapping(value = "/inserisci/notes", method = RequestMethod.POST)
    public ModelAndView postNota(
            @RequestParam("codAzione") CodAzione codAzione,
            @RequestParam(value = "mock", required = false, defaultValue = "false") Boolean mock,
            @Validated Nota nota,
            BindingResult bindingResult
    ) {
        if (Boolean.TRUE.equals(mock)) {
            logger.info("Fine chiamata servizio postNota, mock -> {}", mock);
        }
        logger.info("Inizio chiamata servizio postNota, codAzione -> {}", codAzione);
        ModelAndView mav = new ModelAndView();
        noteService.saveNota(nota);
        List<Nota> listaNote = noteService.getAll();
        mav.addObject("listaNote", listaNote);
        mav.addObject("nota", new Nota());
        mav.setViewName("index");
        return mav;
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
