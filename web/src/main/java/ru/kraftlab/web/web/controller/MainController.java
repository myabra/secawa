package ru.kraftlab.web.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.kraftlab.campaign.model.CampaignReport;
import ru.kraftlab.campaign.service.ReportMasterService;
import ru.kraftlab.person.service.PersonService;

import java.util.Collections;
import java.util.List;

@Controller
public class MainController {
    private static final int MAX_REPORTS_COUNT = 3;
    @Autowired
    private PersonService personService;

    @Autowired
    private ReportMasterService reportMasterService;

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public ModelAndView build() {
        ModelAndView model = new ModelAndView("main");
        model.addObject("overallReport", reportMasterService.getCompanyReport(null));
        model.addObject("departmentReports", getDepartmentsReports());
        model.addObject("employees", personService.getPersons());
        model.addObject("departments", personService.getDepartments());
        return model;
    }

    private List<CampaignReport> getDepartmentsReports() {
        List<CampaignReport> departmentsReports = reportMasterService.getDepartmentsReports(null);
        departmentsReports.sort(((o1, o2) -> o2.getEmployeeCount().compareTo(o1.getEmployeeCount())));
        // выводим отчеты для нескольких произвольных департаментов с максимальным количеством сотрудников
        departmentsReports = departmentsReports.subList(0, Math.min(departmentsReports.size(), 10));
        Collections.shuffle(departmentsReports);
        return departmentsReports.subList(0, Math.min(departmentsReports.size(), MAX_REPORTS_COUNT));
    }
}
