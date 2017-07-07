package ru.kraftlab.app.service;

import ru.kraftlab.app.model.Campaign;

import java.util.List;
import java.util.Set;

/**
 * Created by Мария on 04.07.2017.
 */
public interface CampaignService {
    void save(Campaign campaign);

    void update(Campaign campaign);

    Campaign get(int id);

    List<Campaign> getAll();

    void assignToDepartments(int campaignId, Set<String> departmentsNames);
}
