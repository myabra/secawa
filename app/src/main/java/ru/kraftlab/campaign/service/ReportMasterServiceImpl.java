package ru.kraftlab.campaign.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kraftlab.campaign.model.Campaign;
import ru.kraftlab.campaign.model.CampaignReport;
import ru.kraftlab.person.model.ADDepartment;
import ru.kraftlab.person.service.PersonService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReportMasterServiceImpl implements ReportMasterService {
    private final PersonService personService;

    @Autowired
    public ReportMasterServiceImpl(PersonService personService) {
        this.personService = personService;
    }

    @Override
    public List<CampaignReport> getDepartmentsReports(Campaign campaign) {
        List<ADDepartment> departments = new ArrayList<>(personService.getDepartments());

        List<CampaignReport> reports = new ArrayList<>();
        for (ADDepartment department : departments) {
            reports.add(new CampaignReport.Builder(campaign, department).buildRandomScores());
        }
        return reports;
    }

    @Override
    public CampaignReport getCompanyReport(Campaign campaign) {
        double sumInformedPercent = 0d;
        double sumTestedPercent = 0d;
        double sumControlPercent = 0d;
        double sumAverageScore = 0d;
        int sumEmployeeCount = 0;

        List<CampaignReport> allDepartmentReports = getDepartmentsReports(campaign);
        int reportsCount = allDepartmentReports.size();

        for (CampaignReport departmentReport : allDepartmentReports) {
            sumInformedPercent += Math.round(departmentReport.getInformedPercent() * 100 / reportsCount) / 100;
            sumTestedPercent += Math.round(departmentReport.getTestedPercent() * 100 / reportsCount) / 100;
            sumControlPercent += Math.round(departmentReport.getControlPercent() * 100 / reportsCount) / 100;
            sumAverageScore += Math.round(departmentReport.getAverageScore() * 100 / reportsCount) / 100;
            sumEmployeeCount += departmentReport.getEmployeeCount();
        }

        return new CampaignReport.Builder(campaign, new ADDepartment("Компания", sumEmployeeCount))
                .averageScore(sumAverageScore)
                .controlPercent(sumControlPercent)
                .informedPercent(sumInformedPercent)
                .testedPercent(sumTestedPercent)
                .build();
    }
}
