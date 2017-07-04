package ru.kraftlab.integration.dao.impl;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;
import ru.kraftlab.integration.dao.ADPersonDao;
import ru.kraftlab.integration.model.ADDepartment;
import ru.kraftlab.integration.model.ADPerson;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * Created by Maria on 26.01.2017.
 */
@Component
public class ADPersonDaoImpl extends JdbcDaoSupport implements ADPersonDao {
    private static final String TABLE_NAME = "w_employee_d";
    private static final String Q_CLEAR_ALL = String.format("delete from %s", TABLE_NAME);
    private static final String Q_GET_ALL = String.format("select * from %s", TABLE_NAME);
    private static final String Q_INSERT_PERSON = String.format("insert into %s (SID, DISPLAY_NAME, DEPARTMENT, POSITION, EMAIL, MANAGER) values (?, ?, ?, ?, ?, ?)", TABLE_NAME);
    //todo remove 'uppper' everywhere
    private static final String Q_GET_DEPARTMENTS = String.format("select upper(department) as department, count(*) as employee_count from %s group by upper(department) order by employee_count desc", TABLE_NAME);
    private static final String Q_GET_POSITIONS = String.format("select distinct position from %s where coalesce(position, '') != '' order by position", TABLE_NAME);
    private static final int BATCH_SIZE = 50; //todo properties

    @Autowired
    public ADPersonDaoImpl(DataSource dataSource) {
        setDataSource(dataSource);
    }

    @Override
    public List<ADPerson> getAll() {
        //todo cache?
        //todo init list capacity with persons count
        return getJdbcTemplate().query(Q_GET_ALL, personRowMapper);
    }

    @Override
    public void clearAll() {
        getJdbcTemplate().update(Q_CLEAR_ALL);
    }

    @Override
    public void saveAll(List<ADPerson> personList) {
        List<List<ADPerson>> batchLists = Lists.partition(personList, BATCH_SIZE);

        for (List<ADPerson> batchPersonList : batchLists) {
            getJdbcTemplate().batchUpdate(Q_INSERT_PERSON, new BatchPreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    ADPerson adPerson = batchPersonList.get(i);
                    ps.setString(1, adPerson.getSid());
                    ps.setString(2, adPerson.getDisplayName());
                    ps.setString(3, adPerson.getDepartment());
                    ps.setString(4, adPerson.getPosition());
                    ps.setString(5, adPerson.getMail());
                    ps.setString(6, adPerson.getManager());
                }

                @Override
                public int getBatchSize() {
                    return batchPersonList.size();
                }
            });
        }
    }

    @Override
    public Set<ADDepartment> getDepartments() {
        return new HashSet<>(getJdbcTemplate().query(Q_GET_DEPARTMENTS, (rs, rowNum) -> new ADDepartment(
                rs.getString("department"),
                rs.getInt("employee_count")
        )));
    }

    @Override
    public Map<String, List<ADPerson>> getDepartmentsWithEmployees() {
        List<ADPerson> persons = getAll();
        Map<String, List<ADPerson>> departmentPersonMap = new HashMap<>();

        for (ADPerson person : persons) {
            String department = person.getDepartment();
            List<ADPerson> deptPersons = departmentPersonMap.get(department);
            if (deptPersons == null) {
                departmentPersonMap.put(department, new ArrayList<>(Arrays.asList(person)));
            } else {
                deptPersons.add(person);
                //todo check
            }
        }
        return departmentPersonMap;
    }

    @Override
    public List<String> getPositions() {
        return getJdbcTemplate().query(Q_GET_POSITIONS, (rs, rowNum) -> rs.getString("position"));
    }

    private static RowMapper<ADPerson> personRowMapper = (ResultSet rs, int rowNum) ->
            new ADPerson.Builder()
                    .sid(rs.getString("SID"))
                    .displayName(rs.getString("DISPLAY_NAME"))
                    .department(rs.getString("DEPARTMENT"))
                    .position(rs.getString("POSITION"))
                    .mail(rs.getString("EMAIL"))
                    .manager(rs.getString("MANAGER"))
                    .build();
}
