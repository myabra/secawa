package ru.kraftlab.web.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.kraftlab.integration.service.PersonService;
import ru.kraftlab.report.model.DefaultCampaign;
import ru.kraftlab.report.service.ReportMasterService;

import java.util.TreeSet;

@Controller
public class MainController {
    @Autowired
    PersonService personService;

    @Autowired
    ReportMasterService reportMasterService;

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public ModelAndView build() {
        ModelAndView model = new ModelAndView("main");
        model.addObject("overallReport", reportMasterService.getCompanyReport(new DefaultCampaign()));
        model.addObject("departmentReports", reportMasterService.getTopDepartmentsReports(new DefaultCampaign()));
        model.addObject("employees", personService.getPersons(10));
        model.addObject("departments", new TreeSet<>(personService.getDepartments()));
        return model;
    }
}
