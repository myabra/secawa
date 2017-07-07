package ru.kraftlab.web.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.kraftlab.app.service.PersonService;
import ru.kraftlab.app.service.ReportMasterService;

@Controller
public class MainController {
    @Autowired
    PersonService personService;

    @Autowired
    ReportMasterService reportMasterService;

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public ModelAndView build() {
        ModelAndView model = new ModelAndView("main");
        model.addObject("overallReport", reportMasterService.getCompanyReport(null));
        model.addObject("departmentReports", reportMasterService.getTopDepartmentsReports(null));
        model.addObject("employees", personService.getPersons(10));
        model.addObject("departments", personService.getDepartments());
        return model;
    }
}
