package ru.kraftlab.integration.service.impl.mock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kraftlab.integration.dao.ADPersonDao;
import ru.kraftlab.integration.model.ADPerson;
import ru.kraftlab.integration.service.ADPersonDataLoader;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.lang.StringUtils.isNotBlank;

/**
 * Created by Maria on 27.01.2017.
 */
@Service
public class ADPersonDataLoaderMock implements ADPersonDataLoader {
    public static final String OUT_DIR = "integration" + System.getProperty("file.separator") + "out";
    public static final String CSV_SEPARATOR = ";";

    @Autowired
    private ADPersonDao adPersonDao;

    @PostConstruct
    @Override
    public void loadData() {
        checkOutDir();
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
                String manager = adRecordArr[managerIndex];
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

    private static void checkOutDir() {
        String directoryToCreatePath = new File("").getAbsolutePath() + System.getProperty("file.separator") + OUT_DIR;
        Path dirPath = Paths.get(directoryToCreatePath);
        if (!Files.exists(dirPath)) {
            try {
                Files.createDirectories(dirPath);
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("Failed to create directory " + directoryToCreatePath);
            }
        }
    }
}

