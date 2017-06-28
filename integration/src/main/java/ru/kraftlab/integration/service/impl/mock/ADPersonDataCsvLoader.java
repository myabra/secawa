package ru.kraftlab.integration.service.impl.mock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kraftlab.integration.dao.ADPersonDao;
import ru.kraftlab.integration.model.ADPerson;
import ru.kraftlab.integration.service.ADPersonDataLoader;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.apache.commons.lang.StringUtils.isNotBlank;

/**
 * Created by Maria on 27.01.2017.
 */
public class ADPersonDataCsvLoader implements ADPersonDataLoader {
    public static final String CSV_SEPARATOR = ";";
    public static final Pattern MANAGER_NAME_PATTERN = Pattern.compile("([а-яА-Я\\s])+");//todo check and fix

    @Autowired
    private ADPersonDao adPersonDao;

    @PostConstruct
    @Override
    public void loadData() {
        clearPersonData();
        loadPersonData();
    }

    @Override
    public void clearPersonData() {
        adPersonDao.clearAll();
    }

    private void loadPersonData() {
        List<ADPerson> loadedPersonList = new ArrayList<>();
        String csvFileName = "ad_data_users.csv";
        int idIndex = 0;
        int displayNameIndex = 0;
        int departmentIndex = 0;
        int titleIndex = 0;
        int managerIndex = 0;
        int mailIndex = 0;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                getClass().getClassLoader().getResourceAsStream((csvFileName))))) {
            String line = "";
            if ((line = br.readLine()) == null) {
                //todo clear data
                return;
            }

            //init param indexes
            String[] headRecordArr = line.split(CSV_SEPARATOR);
            for (int i = 0; i < headRecordArr.length; i++) {
                String currentColumnName = headRecordArr[i].trim();
                if ("displayName".equals(currentColumnName)) {
                    displayNameIndex = i;
                }
                if ("department".equals(currentColumnName)) {
                    departmentIndex = i;
                }
                if ("objectSid".equals(currentColumnName)) {
                    idIndex = i;
                }
                if ("manager".equals(currentColumnName)) {
                    managerIndex = i;
                }
                if ("title".equals(currentColumnName)) {
                    titleIndex = i;
                }
                if ("mail".equals(currentColumnName)) {
                    mailIndex = i;
                }
            }

            //load data
            while ((line = br.readLine()) != null) {
                String[] adRecordArr = line.split(CSV_SEPARATOR);

                String id = adRecordArr[idIndex];
                String displayName = adRecordArr[displayNameIndex];
                String department = adRecordArr[departmentIndex];
                String title = adRecordArr[titleIndex];
                String mail = adRecordArr[mailIndex];
                Matcher matcher = MANAGER_NAME_PATTERN.matcher(adRecordArr[managerIndex]);
                String manager = matcher.find() ? matcher.group(0) : null;

                if (isNotBlank(id) && isNotBlank(displayName) && isNotBlank(department) && isNotBlank(mail)) {
                    loadedPersonList.add(new ADPerson(id, displayName, department, title, mail, manager));
                }
            }
            adPersonDao.saveAll(loadedPersonList);

            if (loadedPersonList.isEmpty()) {
                clearPersonData();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

