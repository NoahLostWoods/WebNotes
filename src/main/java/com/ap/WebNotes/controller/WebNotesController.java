package com.ap.WebNotes.controller;


import com.ap.WebNotes.model.Nota;
import com.ap.WebNotes.service.implementations.NoteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import utils.UtilsClass;

import java.util.List;

@Controller
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

        try {
            logger.info("Inizio chiamata servizio deleteNota");
            noteService.delete(new Nota().setId(id));
            return ResponseEntity.ok("OK");
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.ok("KO");
        }
    }


}
