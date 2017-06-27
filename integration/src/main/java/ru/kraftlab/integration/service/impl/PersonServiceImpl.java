package ru.kraftlab.integration.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kraftlab.integration.dao.ADPersonDao;
import ru.kraftlab.integration.model.ADDepartment;
import ru.kraftlab.integration.model.ADPerson;
import ru.kraftlab.integration.model.ADPosition;
import ru.kraftlab.integration.service.PersonService;

import java.util.List;
import java.util.Map;

/**
 * Created by Maria on 26.01.2017.
 */
@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    ADPersonDao personDao;

    @Override
    public List<ADPerson> getPersons() {
        List<ADPerson> personList = personDao.getAll();
        return personList.subList(0, Math.min(personList.size(), 10));
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
    public Map<ADDepartment, List<ADPerson>> getDepartmentsWithEmployees() {
        return personDao.getDepartmentsWithEmployees();
    }
}
