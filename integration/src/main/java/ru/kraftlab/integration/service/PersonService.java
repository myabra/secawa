package ru.kraftlab.integration.service;

import ru.kraftlab.integration.model.ADDepartment;
import ru.kraftlab.integration.model.ADPerson;
import ru.kraftlab.integration.model.ADPosition;

import java.util.List;
import java.util.Map;

/**
 * Created by Maria on 26.01.2017.
 */
public interface PersonService {
    List<ADPerson> getPersons();

    List<ADDepartment> getDepartments();

    List<ADPosition> getPositions();

    Map<ADDepartment, List<ADPerson>> getDepartmentsWithEmployees();
}
