package ru.kraftlab.integration.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kraftlab.integration.dao.ADPersonDao;
import ru.kraftlab.integration.model.ADDepartment;
import ru.kraftlab.integration.model.ADPerson;
import ru.kraftlab.integration.service.PersonService;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Maria on 26.01.2017.
 */
@Service
public class PersonServiceImpl implements PersonService {
    private ADPersonDao personDao;

    @Autowired
    public PersonServiceImpl(ADPersonDao personDao) {
        this.personDao = personDao;
    }

    @Override
    public List<ADPerson> getPersons() {
        return personDao.getAll();
    }

    @Override
    public List<ADPerson> getPersons(int count) {
        List<ADPerson> personList = personDao.getAll();
        return personList.subList(0, Math.min(personList.size(), count));
    }

    @Override
    public Set<ADDepartment> getDepartments() {
        Map<String, List<ADPerson>> departmentsWithEmployees = personDao.getDepartmentsWithEmployees();
        Set<ADDepartment> departmentSet = new TreeSet<>();

        for (String deptName : departmentsWithEmployees.keySet()) {
            int employeesCount = departmentsWithEmployees.get(deptName).size();
            departmentSet.add(new ADDepartment(deptName, employeesCount));
        }

        return departmentSet;
    }

    @Override
    public List<String> getPositions() {
        return personDao.getPositions();
    }

    @Override
    public Map<String, List<ADPerson>> getDepartmentsWithEmployees() {
        return personDao.getDepartmentsWithEmployees();
    }
}
