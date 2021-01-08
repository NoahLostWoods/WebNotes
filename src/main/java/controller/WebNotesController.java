package controller;


import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import utils.UtilsClass;


@Controller(value = "/webnotes")
public class WebNotesController extends UtilsClass {



    @GetMapping(value = "/home")
    public ModelAndView home(
            @RequestParam(value = "mock", required = false, defaultValue = "false") Boolean mock
    ) {

        if (Boolean.TRUE.equals(mock)){
            logger.info("Fine chiamata servizio home mock -> {}", mock);
            ModelAndView mav = new ModelAndView();
            mav.setViewName("mock");
            return mav;
        }

        logger.info("Inizio chiamata al servizio home");
        ModelAndView model = new ModelAndView();
        model.setViewName("index");

        return model;
    }
}
