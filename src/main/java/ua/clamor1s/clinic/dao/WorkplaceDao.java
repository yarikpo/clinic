package ua.clamor1s.clinic.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.clamor1s.clinic.model.Workplace;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class WorkplaceDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Workplace> getAllWorkplaces() {
        return jdbcTemplate.query("select * from workplace;", (rs, rowNum) -> mapWorkplace(rs));
    }

    public Workplace getWorkplaceById(int id) {
        return jdbcTemplate.queryForObject("select * from workplace where workplace_id=?;",
                (rs, rowNum) -> mapWorkplace(rs),
                new Object[] {id}
        );
    }

    public void deleteWorkplaceById(int id) {
        jdbcTemplate.update("delete from workplace where workplace_id=?;", id);
    }

    public void createWorkplace(Workplace workplace) {
        jdbcTemplate.update("insert into workplace (room_number, place_number) values (?, ?);",
                workplace.getRoomNumber(),
                workplace.getPlaceNumber()
        );
    }

    public void updateWorkplaceById(int id, Workplace workplace) {
        jdbcTemplate.update("update workplace set room_number=?, place_number=? where workplace_id=?;",
                workplace.getRoomNumber(),
                workplace.getPlaceNumber(),
                id
        );
    }

    private Workplace mapWorkplace(ResultSet rs) throws SQLException {
        return Workplace.builder()
                .workplaceId(rs.getInt("workplace_id"))
                .roomNumber(rs.getInt("room_number"))
                .placeNumber(rs.getInt("place_number"))
                .build();
    }

}
