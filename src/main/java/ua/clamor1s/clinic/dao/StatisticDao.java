package ua.clamor1s.clinic.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.clamor1s.clinic.model.Statistic;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StatisticDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Statistic> index(String statement) {
        return jdbcTemplate.query(statement, (rs, rowNum) -> mapIndex(rs));
    }

    public Statistic top(String statement) {
        return jdbcTemplate.query(statement, (rs, rowNum) -> mapTop(rs))
                .stream()
                .findAny()
                .orElse(null);
    }

    private Statistic mapTop(ResultSet rs) throws SQLException {
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();
        Statistic stat = new Statistic();

        for (int i = 1; i <= columnCount; ++i) {
            stat.getAttributes().add(rsmd.getColumnName(i));
        }
        return stat;
    }

    private Statistic mapIndex(ResultSet rs) throws SQLException {
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();

        Statistic stat = new Statistic();
        for (int i = 1; i <= columnCount; ++i) {
            stat.getAttributes().add(rs.getString(i));
        }

        return stat;
    }

}
