package ru.kraftlab.integration.service;

import ru.kraftlab.integration.model.ADDepartment;
import ru.kraftlab.integration.model.ADPerson;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Maria on 26.01.2017.
 */
public interface PersonService {
    List<ADPerson> getPersons();

    List<ADPerson> getPersons(int count);

    Set<ADDepartment> getDepartments();

    List<String> getPositions();

    Map<String, List<ADPerson>> getDepartmentsWithEmployees();
}
