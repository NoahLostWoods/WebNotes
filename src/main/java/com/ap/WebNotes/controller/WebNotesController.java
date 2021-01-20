package com.ap.WebNotes.controller;


import com.ap.WebNotes.model.Nota;
import com.ap.WebNotes.service.implementations.NoteServiceImpl;
import com.ap.WebNotes.utils.enums.CodAzioneEnum;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

    @ApiOperation("Api che restituisce una lista di note")
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

    @ApiOperation("Api che permette di inserire una nota")
    @RequestMapping(value = "/inserisci/notes", method = RequestMethod.POST)
    public ModelAndView postNota(
            @RequestParam("codAzione") CodAzioneEnum codAzione,
            @RequestParam(value = "mock", required = false, defaultValue = "false") Boolean mock,
            @Validated Nota nota,
            BindingResult bindingResult
    ) {
        if (Boolean.TRUE.equals(mock)) {
            logger.info("Fine chiamata servizio postNota, mock -> {}", mock);
        }
        logger.info("Inizio chiamata servizio postNota, codAzione -> {}", codAzione);
        noteService.saveNota(nota);
        List<Nota> listaNote = noteService.getAll();
        mav.addObject("listaNote", listaNote);
        mav.addObject("nota", new Nota());
        mav.setViewName("index");
        return mav;
    }

    @ApiOperation("Api che permette di ricercare una nota per ID")
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView update(
            @PathVariable("id") Integer id
    ){
        mav.addObject("nota", noteService.findById(id));
        mav.setViewName("edit_nota");
        return mav;
    }

    @ApiOperation("Api che permette di modificare una determinata nota")
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView doUpdate(
            @Validated Nota nota,
            BindingResult bindingResult
    ){
        noteService.saveNota(nota);
        mav.setViewName("redirect:/web-notes/notes");

        return mav;

    }

}
