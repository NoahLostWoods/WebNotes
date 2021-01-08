package utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;

public class UtilsClass {

    // ==LOGGER==
    public Logger logger = LoggerFactory.getLogger(this.getClass());

    // ==MODELANDVIEW==
    public ModelAndView mav = new ModelAndView();
}
