package ru.kraftlab.integration.dao;

import ru.kraftlab.integration.model.ADPerson;
import ru.kraftlab.integration.model.Campaign;

import java.util.List;

/**
 * Created by Мария on 27.06.2017.
 */
public interface CampaignDAO {
    void save(Campaign campaign);

    void update(Campaign campaign);

    Campaign get(int id);

    List<Campaign> getAll();

    //todo void vs boolean?
    boolean assignToPersons(int campaignId, List<ADPerson> persons);
}
