package ru.kraftlab.app.service;

import ru.kraftlab.app.model.Campaign;
import ru.kraftlab.app.model.CampaignReport;

import java.util.List;

/**
 * Created by Мария on 07.02.2017.
 */
public interface ReportMasterService {
    List<CampaignReport> getTopDepartmentsReports(Campaign campaign);

    CampaignReport getCompanyReport(Campaign campaign);
}
