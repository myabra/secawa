package ru.kraftlab.integration.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;
import ru.kraftlab.integration.dao.CampaignDAO;
import ru.kraftlab.integration.model.Campaign;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

@Component
public class CampaignDAOImpl extends JdbcDaoSupport implements CampaignDAO {
    private static final String CAMPAIGN_TABLE_NAME = "Campaign";
    private static final String Q_SAVE = String.format("insert into %s (name, file_name, active, created_by) values (?, ?, ?, ?)", CAMPAIGN_TABLE_NAME);
    private static final String Q_UPDATE = String.format("update %s set name = ?, file_name = ?, active = ? where id=?", CAMPAIGN_TABLE_NAME);
    private static final String Q_GET = String.format("select * from %s where id=?", CAMPAIGN_TABLE_NAME);
    private static final String Q_GET_ALL = String.format("select * from %s order by created_date", CAMPAIGN_TABLE_NAME);

    private static final String ASSIGNED_CAMPAIGN_TABLE_NAME = "assigned_campaign";
    private static final String Q_ASSIGN_TO_EMP = String.format("insert into %s (campaign_id, employee_id) values (?, ?)", ASSIGNED_CAMPAIGN_TABLE_NAME);

    @Autowired
    public CampaignDAOImpl(DataSource dataSource) {
        setDataSource(dataSource);
    }

    @Override
    public void save(Campaign campaign) {
        checkCampaignNotEmpty(campaign);
        getJdbcTemplate().update(Q_SAVE, campaign.getName(), campaign.getFileName(), campaign.getIsActive(), campaign.getCreatedBy());
    }

    @Override
    public void update(Campaign campaign) {
        checkCampaignNotEmpty(campaign);
        getJdbcTemplate().update(Q_UPDATE, campaign.getName(), campaign.getFileName(), campaign.getIsActive(), campaign.getId());
    }

    @Override
    public Campaign get(int id) {
        return getJdbcTemplate().queryForObject(Q_GET, new Object[]{id}, campaignRowMapper);
    }

    @Override
    public List<Campaign> getAll() {
        return getJdbcTemplate().query(Q_GET_ALL, campaignRowMapper);
    }

    @Override
    public void assignToPersons(int campaignId, List<String> personSIDs) {
        if (personSIDs == null || personSIDs.isEmpty()) {
            throw new IllegalArgumentException("Empty person list");
        }

        getJdbcTemplate().batchUpdate(Q_ASSIGN_TO_EMP, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                String personSID = personSIDs.get(i);
                ps.setInt(1, campaignId);
                ps.setString(2, personSID);
            }

            @Override
            public int getBatchSize() {
                return personSIDs.size();
            }
        });
    }

    private static final RowMapper<Campaign> campaignRowMapper = (ResultSet rs, int rowNum) -> new Campaign.Builder()
            .createdBy(rs.getString("created_by"))
            .creationDate(rs.getDate("created_date"))
            .fileName(rs.getString("file_name"))
            .id(rs.getInt("id"))
            .isActive(rs.getBoolean("active"))
            .name(rs.getString("name"))
            .build();

    private static void checkCampaignNotEmpty(Campaign campaign) {
        Objects.requireNonNull(campaign, "Empty campaign object");
    }
}
