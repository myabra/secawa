package ru.kraftlab.integration.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;
import ru.kraftlab.integration.dao.CampaignDAO;
import ru.kraftlab.integration.model.Campaign;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.List;

/**
 * Created by Мария on 27.06.2017.
 */
@Component
public class CampaignDAOImpl extends JdbcDaoSupport implements CampaignDAO {
    private static final String TABLE_NAME = "Campaign";
    private static final String Q_SAVE = String.format("insert into %s (name, file_name, active, created_by) values (?, ?, ?, ?)", TABLE_NAME);
    private static final String Q_UPDATE = String.format("update %s set name = ?, file_name = ?, active = ? where id=?", TABLE_NAME);
    private static final String Q_GET = String.format("select * from %s where id=?", TABLE_NAME);
    private static final String Q_GET_ALL = String.format("select * from %s order by created_date", TABLE_NAME);

    @Autowired
    public CampaignDAOImpl(DataSource dataSource) {
        setDataSource(dataSource);
    }

    @Override
    public void save(Campaign campaign) {
        getJdbcTemplate().update(Q_SAVE, campaign.getName(), campaign.getFileName(), campaign.getIsActive(), campaign.getCreatedBy());
    }

    @Override
    public void update(Campaign campaign) {
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

    private static RowMapper<Campaign> campaignRowMapper = (ResultSet rs, int rowNum) -> new Campaign.Builder()
            .createdBy(rs.getString("created_by"))
            .creationDate(rs.getDate("created_date"))
            .fileName(rs.getString("file_name"))
            .id(rs.getInt("id"))
            .isActive(rs.getBoolean("active"))
            .name(rs.getString("name"))
            .build();
}
