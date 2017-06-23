package ru.kraftlab.integration.dao;

import ru.kraftlab.integration.model.ADDepartment;
import ru.kraftlab.integration.model.ADPerson;
import ru.kraftlab.integration.model.ADPosition;

import java.util.List;

/**
 * Created by Maria on 26.01.2017.
 */
public interface ADPersonDao {
    List<ADPerson> getAll();

    void clearAll();

    void saveAll(List<ADPerson> personList);

    List<ADDepartment> getDepartments();

    List<ADPosition> getPositions();
}
