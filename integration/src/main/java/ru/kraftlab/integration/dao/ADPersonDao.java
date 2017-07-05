package ru.kraftlab.integration.dao;

import ru.kraftlab.integration.model.ADPerson;

import java.util.List;
import java.util.Map;

/**
 * Created by Maria on 26.01.2017.
 */
public interface ADPersonDao {
    List<ADPerson> getAll();

    void clearAll();

    void saveAll(List<ADPerson> personList);

    Map<String, List<ADPerson>> getDepartmentsWithEmployees();

    List<String> getPositions();
}
