package ru.kraftlab.web.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.kraftlab.integration.model.ADPosition;
import ru.kraftlab.integration.service.PersonService;

import java.util.HashMap;
import java.util.List;

@Controller
public class ReportMasterController {
    @Autowired
    PersonService personService;

    @RequestMapping(value = "/reportMaster", method = RequestMethod.GET)
    public ModelAndView buildPage() {
        HashMap<String, List<ADPosition>> positions = new HashMap<>();
        positions.put("positions", personService.getPositions());
        return new ModelAndView("reportMaster", positions);
    }

}
