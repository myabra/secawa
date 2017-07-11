package ru.kraftlab.campaign.service;

import ru.kraftlab.campaign.model.Campaign;
import ru.kraftlab.campaign.model.CampaignReport;

import java.util.List;

public interface ReportMasterService {
    List<CampaignReport> getDepartmentsReports(Campaign campaign);

    CampaignReport getCompanyReport(Campaign campaign);
}
