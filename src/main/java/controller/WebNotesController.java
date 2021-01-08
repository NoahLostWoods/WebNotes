package controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



@Controller(value = "/webnotes")
public class WebNotesController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

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
