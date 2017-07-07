package ru.kraftlab.app.dao.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.kraftlab.app.config.TestConfig;
import ru.kraftlab.app.dao.ADPersonDao;
import ru.kraftlab.app.model.ADPerson;

import java.util.*;

import static org.apache.commons.lang3.RandomUtils.nextInt;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@ContextConfiguration(classes = TestConfig.class)
public class ADPersonDaoTest extends AbstractTestNGSpringContextTests {
    private static final int GENERATED_TEST_ENTITIES_COUNT = 10;

    @Autowired
    private ADPersonDao adPersonDao;

    @BeforeMethod
    public void setUp() throws Exception {
        adPersonDao.clearAll();
    }

    @DataProvider(name = "getPersonLists")
    public static Object[][] getPersonLists() {
        return new Object[][]{{generatePersonList()}, {Arrays.asList(generatePerson())}};
    }

    @Test(dataProvider = "getPersonLists")
    public void testSaveAll(List<ADPerson> expectedPersons) throws Exception {
        adPersonDao.saveAll(expectedPersons);
        List<ADPerson> actualPersons = adPersonDao.getAll();

        assertTrue(actualPersons.size() == expectedPersons.size());
        assertTrue(actualPersons.containsAll(expectedPersons));
    }

    @Test(dataProvider = "getPersonLists")
    public void testGetAll(List<ADPerson> expectedPersons) throws Exception {
        adPersonDao.saveAll(expectedPersons);
        final List<ADPerson> actualPersons = adPersonDao.getAll();

        assertEquals(actualPersons.size(), expectedPersons.size());
        assertTrue(actualPersons.containsAll(expectedPersons));
    }

    @Test
    public void testGetAllFieldsMapping() throws Exception {
        final ADPerson expectedPerson = generatePerson();
        adPersonDao.saveAll(Arrays.asList(expectedPerson));
        final ADPerson actualPerson = adPersonDao.getAll().get(0);

        assertEquals(actualPerson.getSid(), expectedPerson.getSid());
        assertEquals(actualPerson.getDisplayName(), expectedPerson.getDisplayName());
        assertEquals(actualPerson.getDepartment(), expectedPerson.getDepartment());
        assertEquals(actualPerson.getMail(), expectedPerson.getMail());
        assertEquals(actualPerson.getManager(), expectedPerson.getManager());
        assertEquals(actualPerson.getPosition(), expectedPerson.getPosition());
    }

    @Test
    public void testClearAll() throws Exception {
        adPersonDao.saveAll(generatePersonList());
        adPersonDao.clearAll();
        assertTrue(adPersonDao.getAll().isEmpty());
    }

    @Test
    public void testGetDepartmentsWithEmployees() throws Exception {
        final Map<String, List<ADPerson>> expectedDeptsWithEmployees = generatedDepartmentsWithEmployees();
        List<ADPerson> dbPersons = new ArrayList<>();
        expectedDeptsWithEmployees.values().forEach(dbPersons::addAll);
        adPersonDao.saveAll(dbPersons);

        final Map<String, List<ADPerson>> actualDeptsWithEmployees = adPersonDao.getDepartmentsWithEmployees();

        assertEquals(actualDeptsWithEmployees.size(), expectedDeptsWithEmployees.size());
        assertTrue(actualDeptsWithEmployees.keySet().containsAll(expectedDeptsWithEmployees.keySet()));
        assertTrue(actualDeptsWithEmployees.values().containsAll(expectedDeptsWithEmployees.values()));

        //test department employees count
        for (String deptName : actualDeptsWithEmployees.keySet()) {
            int actualEmployeesCount = actualDeptsWithEmployees.get(deptName).size();
            int expectedEmployeesCount = expectedDeptsWithEmployees.get(deptName).size();
            assertEquals(actualEmployeesCount, expectedEmployeesCount);
        }
    }

    @Test
    public void testGetPositions() throws Exception {
        final List<ADPerson> expectedPersons = generatePersonList();
        List<String> expectedPositions = new ArrayList<>();
        expectedPersons.forEach(person -> {
            if (StringUtils.isNotEmpty(person.getPosition())) {
                expectedPositions.add(person.getPosition());
            }
        });

        adPersonDao.saveAll(expectedPersons);

        final List<String> actualPositions = adPersonDao.getPositions();
        assertEquals(actualPositions.size(), expectedPositions.size());
        assertTrue(actualPositions.containsAll(expectedPositions));
    }

    private static List<ADPerson> generatePersonList() {
        List<ADPerson> persons = new ArrayList<>();
        for (int i = 0; i < GENERATED_TEST_ENTITIES_COUNT; i++) {
            persons.add(generatePerson());
        }
        return persons;
    }

    private static ADPerson generatePerson() {
        return new ADPerson.Builder()
                .department("department" + nextInt())
                .displayName("displayName" + nextInt())
                .mail("mail" + nextInt())
                .manager("manager" + nextInt())
                .position("position" + nextInt())
                .sid("sid" + nextInt())
                .build();
    }

    private static Map<String, List<ADPerson>> generatedDepartmentsWithEmployees() {
        Map<String, List<ADPerson>> resultDepartments = new HashMap<>();

        for (int deptCounter = 0; deptCounter < GENERATED_TEST_ENTITIES_COUNT; deptCounter++) {
            int employeesCount = nextInt(1, 5);
            final String deptName = "department NamE" + employeesCount;
            List<ADPerson> persons = new ArrayList<>();

            for (int i = 0; i < employeesCount; i++) {
                ADPerson person = new ADPerson.Builder()
                        .department(deptName)
                        .displayName("displayName")
                        .mail("mail")
                        .sid("sid")
                        .build();
                persons.add(person);
            }
            resultDepartments.put(deptName, persons);
        }

        return resultDepartments;
    }
}