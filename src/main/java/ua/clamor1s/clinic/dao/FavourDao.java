package ua.clamor1s.clinic.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.clamor1s.clinic.model.Favour;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class FavourDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Favour> getAllFavours() {
        return jdbcTemplate.query("select * from favour;", (rs, rowNum) -> mapFavour(rs));
    }

    public Favour getFavourById(int id) {
        return jdbcTemplate.queryForObject("select * from favour where favour_id=?;",
                (rs, rowNum) -> mapFavour(rs),
                new Object[] {id}
        );
    }

    public void deleteFavourById(int id) {
        jdbcTemplate.update("delete from favour where favour_id=?;", id);
    }

    public void createFavour(Favour favour) {
        jdbcTemplate.update("insert into favour (name, cost) values (?, ?);",
                favour.getName(),
                favour.getCost()
        );
    }

    public void updateFavourById(int id, Favour favour) {
        jdbcTemplate.update("update favour set name=?, cost=? where favour_id=?;",
                favour.getName(),
                favour.getCost(),
                id
        );
    }

    private Favour mapFavour(ResultSet rs) throws SQLException {
        return Favour.builder()
                .favourId(rs.getInt("favour_id"))
                .name(rs.getString("name"))
                .cost(rs.getInt("cost"))
                .build();
    }

}
