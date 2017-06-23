package ru.kraftlab.integration.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kraftlab.integration.dao.ADPersonDao;
import ru.kraftlab.integration.model.ADDepartment;
import ru.kraftlab.integration.model.ADPerson;
import ru.kraftlab.integration.model.ADPosition;
import ru.kraftlab.integration.service.PersonService;

import java.util.*;

/**
 * Created by Maria on 26.01.2017.
 */
@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    ADPersonDao personDao;

    @Override
    public List<ADPerson> getPersons() {
        return personDao.getAll();
    }

    @Override
    public List<ADDepartment> getDepartments() {
        return personDao.getDepartments();
    }

    @Override
    public List<ADPosition> getPositions() {
        return personDao.getPositions();
    }

    @Override
    public Map<String, List<ADPerson>> getDepartmentsWithPersons() {
        Map<String, List<ADPerson>> resultMap = new HashMap<>();
        final List<ADPerson> personList = getPersons();
        for (ADPerson adPerson : personList) {
            final String dptName = adPerson.getDepartment();
            if (!resultMap.containsKey(dptName)) {
                resultMap.put(dptName, new LinkedList<>(Arrays.asList(adPerson)));
            } else {
                resultMap.get(dptName).add(adPerson);
            }
        }
        return resultMap;
    }
}
