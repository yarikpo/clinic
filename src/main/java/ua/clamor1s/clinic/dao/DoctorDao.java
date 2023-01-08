package ua.clamor1s.clinic.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.clamor1s.clinic.model.Doctor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class DoctorDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Doctor> getAllDoctors() {
        return jdbcTemplate.query("select * from doctor;", (rs, rowNum) -> mapDoctor(rs));
    }

    public Doctor getDoctorById(int id) {
        return jdbcTemplate.queryForObject("select * from doctor where doctor_id=?;",
                (rs, rowNum) -> mapDoctor(rs),
                new Object[] {id}
        );
    }

    public void deleteDoctorById(int id) {
        jdbcTemplate.update("delete from doctor where doctor_id=?;", id);
    }

    public void createDoctor(Doctor doctor) {
        jdbcTemplate.update("insert into doctor (series_number, email, password, name, specialization, ITN, tel_num)" +
                " values (?, ?, ?, ?, ?, ?, ?);",
                doctor.getSeriesNumber(),
                doctor.getEmail(),
                doctor.getPassword(),
                doctor.getName(),
                doctor.getSpecialization(),
                doctor.getITN(),
                doctor.getTelNum()
        );
    }

    public void updateDoctorById(int id, Doctor doctor) {
        jdbcTemplate.update("update doctor set series_number=?, email=?, password=?, name=?, specialization=?, ITN=?, tel_num=?" +
                "where doctor_id=?;",
                doctor.getSeriesNumber(),
                doctor.getEmail(),
                doctor.getPassword(),
                doctor.getName(),
                doctor.getSpecialization(),
                doctor.getITN(),
                doctor.getTelNum(),
                id
        );
    }

    private Doctor mapDoctor(ResultSet rs) throws SQLException {
        return Doctor.builder()
                .doctorId(rs.getInt("doctor_id"))
                .seriesNumber(rs.getString("series_number"))
                .email(rs.getString("email"))
                .password(rs.getString("password"))
                .name(rs.getString("name"))
                .specialization(rs.getString("specialization"))
                .ITN(rs.getString("ITN"))
                .telNum(rs.getString("tel_num"))
                .build();
    }

    public List<String> getAllowedSeriesNumbers(int id) {
        return jdbcTemplate.query("select series_number from passport" +
                " where series_number not in (select series_number from admin)" +
                " and series_number not in (select series_number from doctor where doctor_id <> ?);",
                (rs, rowNum) -> rs.getString("series_number"),
                new Object[] {id}
        );
    }


}
