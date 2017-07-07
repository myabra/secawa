package ru.kraftlab.web.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.kraftlab.app.service.PersonService;

@Controller
public class ReportMasterController {
    @Autowired
    PersonService personService;

    @RequestMapping(value = "/reportMaster", method = RequestMethod.GET)
    public ModelAndView buildPage() {
        ModelAndView model = new ModelAndView("reportMaster");
        model.addObject("positions", personService.getPositions());
        return model;
    }

}
