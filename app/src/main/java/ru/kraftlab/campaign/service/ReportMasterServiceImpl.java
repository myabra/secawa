package ru.kraftlab.campaign.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kraftlab.person.model.ADDepartment;
import ru.kraftlab.campaign.model.Campaign;
import ru.kraftlab.campaign.model.CampaignReport;
import ru.kraftlab.person.service.PersonService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Мария on 07.02.2017.
 */
@Service
public class ReportMasterServiceImpl implements ReportMasterService {
    public static int MAX_REPORTS_COUNT = 3;
    @Autowired
    PersonService personService;

    @Override
    public List<CampaignReport> getTopDepartmentsReports(Campaign campaign) {
        List<ADDepartment> departments = new ArrayList<>(personService.getDepartments());
        //todo param departments count?
        departments = departments.subList(0, Math.min(departments.size(), 10));

        List<CampaignReport> reports = new ArrayList<>();
        for (ADDepartment department : departments) {
            reports.add(new CampaignReport.Builder(campaign, department).buildRandomScores());
        }
        Collections.shuffle(reports);
        return reports.subList(0, MAX_REPORTS_COUNT);
    }

    @Override
    public CampaignReport getCompanyReport(Campaign campaign) {
        double sumInformedPercent = 0d;
        double sumTestedPercent = 0d;
        double sumControlPercent = 0d;
        double sumAverageScore = 0d;
        int sumEmployeeCount = 0;

        List<CampaignReport> allDepartmentReports = getTopDepartmentsReports(campaign);
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
