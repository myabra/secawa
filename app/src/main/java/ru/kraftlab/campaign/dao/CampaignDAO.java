package ru.kraftlab.campaign.dao;

import ru.kraftlab.campaign.model.Campaign;

import java.util.List;

public interface CampaignDAO {
    void save(Campaign campaign);

    void update(Campaign campaign);

    Campaign get(int id);

    List<Campaign> getAll();

    void assignToPersons(int campaignId, List<String> personSIDs);

    //todo provide obtaining assigned campaigns
}
