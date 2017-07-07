package ru.kraftlab.campaign.service;

import ru.kraftlab.campaign.model.Campaign;
import ru.kraftlab.campaign.model.CampaignReport;

import java.util.List;

/**
 * Created by Мария on 07.02.2017.
 */
public interface ReportMasterService {
    List<CampaignReport> getTopDepartmentsReports(Campaign campaign);

    CampaignReport getCompanyReport(Campaign campaign);
}
