package ru.kraftlab.app.dao.impl;

import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.kraftlab.app.config.TestConfig;
import ru.kraftlab.app.dao.CampaignDAO;
import ru.kraftlab.app.model.Campaign;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.*;

@ContextConfiguration(classes = TestConfig.class)
public class CampaignDAOTest extends AbstractTestNGSpringContextTests {
    private static final int GENERATED_TEST_ENTITIES_COUNT = 10;
    @Autowired
    private CampaignDAO campaignDAO;
    @Autowired
    private DataSource dataSource;

    @BeforeMethod
    public void setUp() throws Exception {
        clearCampaignTablesDB();
    }

    @Test
    public void testSave() throws Exception {
        final Campaign expectedCampaign = generateCampaign();
        campaignDAO.save(expectedCampaign);

        List<Campaign> savedCampaigns = campaignDAO.getAll();
        assertEquals(savedCampaigns.size(), 1);
        assertNotNull(savedCampaigns.get(0).getId());
        assertNotNull(savedCampaigns.get(0).getCreationDate());
    }

    @Test
    public void testUpdate() throws Exception {
        campaignDAO.save(generateCampaign());
        final int campaignId = campaignDAO.getAll().get(0).getId();

        Campaign expectedCampaign = new Campaign.Builder()
                .id(campaignId)
                .isActive(false)
                .name("new name")
                .fileName("new file name")
                .build();
        campaignDAO.update(expectedCampaign);

        Campaign actualCampaign = campaignDAO.get(campaignId);
        assertEquals(actualCampaign.getFileName(), expectedCampaign.getFileName());
        assertEquals(actualCampaign.getName(), expectedCampaign.getName());
        assertEquals(actualCampaign.getIsActive(), expectedCampaign.getIsActive());
    }

    @Test
    public void testGet() throws Exception {
        final Campaign expectedCampaign = generateCampaign();
        campaignDAO.save(expectedCampaign);
        final Campaign actualCampaign = campaignDAO.getAll().get(0);

        assertEquals(actualCampaign.getCreatedBy(), expectedCampaign.getCreatedBy());
        assertEquals(actualCampaign.getFileName(), expectedCampaign.getFileName());
        assertEquals(actualCampaign.getName(), expectedCampaign.getName());
        assertEquals(actualCampaign.getIsActive(), expectedCampaign.getIsActive());
    }

    @DataProvider(name = "getCampaignList")
    public static Object[][] getCampaignList() {
        List<Campaign> campaignList = new ArrayList<>();
        for (int i = 0; i < GENERATED_TEST_ENTITIES_COUNT; i++) {
            Campaign campaignForSave = generateCampaign();
            campaignList.add(campaignForSave);
        }
        return new Object[][]{{campaignList}, {Arrays.asList(generateCampaign())}};
    }

    @Test(dataProvider = "getCampaignList")
    public void testGetAll(List<Campaign> expectedCampaigns) throws Exception {
        for (Campaign expectedCampaign : expectedCampaigns) {
            campaignDAO.save(expectedCampaign);
        }

        final List<String> expectedCampaignNames = expectedCampaigns.stream().map(Campaign::getName).collect(Collectors.toList());

        final List<Campaign> actualCampaigns = campaignDAO.getAll();
        final List<String> actualCampaignNames = actualCampaigns.stream().map(Campaign::getName).collect(Collectors.toList());

        assertEquals(actualCampaigns.size(), expectedCampaigns.size());
        assertTrue(expectedCampaignNames.containsAll(actualCampaignNames));
    }

    private static Campaign generateCampaign() {
        return new Campaign.Builder()
                .name("test campaign name" + RandomUtils.nextInt())
                .fileName("test campaign file name" + RandomUtils.nextInt())
                .createdBy("test campaign author" + RandomUtils.nextInt())
                .isActive(true)
                .build();
    }

    private void clearCampaignTablesDB() throws Exception {
        try (Connection connection = dataSource.getConnection()) {
            Statement statement = connection.createStatement();
            statement.execute("delete from campaign");
            statement.execute("delete from assigned_campaign");
        }
    }
}