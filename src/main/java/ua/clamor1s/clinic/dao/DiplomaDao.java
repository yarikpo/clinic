package ua.clamor1s.clinic.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.clamor1s.clinic.model.Diploma;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Repository
public class DiplomaDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Diploma> getAllDiplomas() {
        return jdbcTemplate.query("select * from diploma;", (rs, nowNum) -> mapDiploma(rs));
    }

    public Diploma getDiplomaByCode(String code) {
        return jdbcTemplate.queryForObject("select * from diploma where code=?;",
                (rs, rowNum) -> mapDiploma(rs),
                new Object[] {code}
        );
    }

    public void deleteDiplomaByCode(String code) {
        jdbcTemplate.update("delete from diploma where code=?;", code);
    }

    public void createDiploma(Diploma diploma) throws ParseException {
        jdbcTemplate.update("insert into diploma (code, doctor_id, name, given_date)" +
                " values (?, ?, ?, ?);",
                diploma.getCode(),
                diploma.getDoctorId(),
                diploma.getName(),
                new SimpleDateFormat("yyyy-MM-dd").parse(diploma.getGivenDate())
        );
    }

    public void updateDiplomaByCode(String code, Diploma diploma) throws ParseException {
        jdbcTemplate.update("update diploma set code=?, doctor_id=?, name=?, given_date=? where code=?;",
                diploma.getCode(),
                diploma.getDoctorId(),
                diploma.getName(),
                new SimpleDateFormat("yyyy-MM-dd").parse(diploma.getGivenDate()),
                code
        );
    }

    private Diploma mapDiploma(ResultSet rs) throws SQLException {
        return Diploma.builder()
                .code(rs.getString("code"))
                .doctorId(rs.getInt("doctor_id"))
                .name(rs.getString("name"))
                .givenDate(rs.getDate("given_date").toString())
                .build();
    }

    public List<Integer> getAllowedDoctorIds() {
        return jdbcTemplate.query("select doctor_id from doctor;",
                (rs, rowNum) -> rs.getInt("doctor_id")
        );
    }

}
