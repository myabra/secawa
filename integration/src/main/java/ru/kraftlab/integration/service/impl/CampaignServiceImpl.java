package ru.kraftlab.integration.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kraftlab.integration.dao.ADPersonDao;
import ru.kraftlab.integration.dao.CampaignDAO;
import ru.kraftlab.integration.model.ADPerson;
import ru.kraftlab.integration.model.Campaign;
import ru.kraftlab.integration.service.CampaignService;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Мария on 04.07.2017.
 */
@Service
public class CampaignServiceImpl implements CampaignService {
    @Autowired
    CampaignDAO campaignDAO;

    @Autowired
    ADPersonDao personDao;

    @Override
    public void save(Campaign campaign) {
        campaignDAO.save(campaign);
    }

    @Override
    public void update(Campaign campaign) {
        campaignDAO.update(campaign);
    }

    @Override
    public Campaign get(int id) {
        return campaignDAO.get(id);
    }

    @Override
    public List<Campaign> getAll() {
        return campaignDAO.getAll();
    }

    @Override
    public void assignToDepartments(int campaignId, Set<String> departmentsNames) {
        Map<String, List<ADPerson>> departmentsWithEmployees = personDao.getDepartmentsWithEmployees();
        for (String departmentName : departmentsNames) {
            List<ADPerson> personsForAssignCampaign = departmentsWithEmployees.get(departmentName);
            if (personsForAssignCampaign == null) {
                throw new IllegalArgumentException(String.format("Department %s does not exist", departmentName));
            }
            campaignDAO.assignToPersons(campaignId, personsForAssignCampaign);
        }
    }
}