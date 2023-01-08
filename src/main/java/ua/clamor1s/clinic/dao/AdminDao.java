package ua.clamor1s.clinic.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.clamor1s.clinic.model.Admin;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AdminDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Admin> getAllAdmins() {
        return jdbcTemplate.query("select * from admin;", (rs, rowNum) -> mapAdmin(rs));
    }

    public Admin getAdminById(int id) {
        return jdbcTemplate.queryForObject("select * from admin where admin_id=?;",
                (rs, rowNum) -> mapAdmin(rs),
                new Object[] {id}
        );
    }

    public void deleteAdminById(int id) {
        jdbcTemplate.update("delete from admin where admin_id=?;", id);
    }

    public void createAdmin(Admin admin) {
        jdbcTemplate.update("insert into admin (series_number, email, password, name, tel_num, ITN)" +
                " values (?, ?, ?, ?, ?, ?);",
                admin.getSeriesNumber(),
                admin.getEmail(),
                admin.getPassword(),
                admin.getName(),
                admin.getTelNum(),
                admin.getITN()
        );
    }

    public void updateAdminById(int id, Admin admin) {
        jdbcTemplate.update("update admin set series_number=?, email=?, password=?, name=?, tel_num=?, ITN=?" +
                " where admin_id=?;",
                admin.getSeriesNumber(),
                admin.getEmail(),
                admin.getPassword(),
                admin.getName(),
                admin.getTelNum(),
                admin.getITN(),
                id
        );
    }

    private Admin mapAdmin(ResultSet rs) throws SQLException {
        return Admin.builder()
                .adminId(rs.getInt("admin_id"))
                .seriesNumber(rs.getString("series_number"))
                .email(rs.getString("email"))
                .password(rs.getString("password"))
                .name(rs.getString("name"))
                .telNum(rs.getString("tel_num"))
                .ITN(rs.getString("ITN"))
                .build();

    }

    public List<String> getAllowedSeriesNumbers(int adminId) {
        return jdbcTemplate.query("select series_number from passport" +
                " where series_number not in (select series_number from admin where admin_id <> ?)" +
                " and series_number not in (select series_number from doctor);",
                (rs, rowNum) -> rs.getString("series_number"),
                new Object[] {adminId}
        );
    }

}
