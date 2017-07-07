package ru.kraftlab.integration.dao;

import ru.kraftlab.integration.model.Campaign;

import java.util.List;

public interface CampaignDAO {
    void save(Campaign campaign);

    void update(Campaign campaign);

    Campaign get(int id);

    List<Campaign> getAll();

    void assignToPersons(int campaignId, List<String> personSIDs);

    //todo provide obtaining assigned campaigns
}
