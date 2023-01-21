package ua.clamor1s.clinic.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.clamor1s.clinic.model.Appointment;
import ua.clamor1s.clinic.model.Client;
import ua.clamor1s.clinic.model.Doctor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AutomatizationDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Appointment> getTodayAppointmentsByDoctorId(int id) {
        return jdbcTemplate.query("select *" +
                " from appointment" +
                " where doctor_id = ? and DATE(date) = CURDATE() order by date;",
                (rs, rowNum) -> mapAppointment(rs),
                new Object[] {id}
        );
    }

    public Doctor getDoctorByEmail(String email) {
        return jdbcTemplate.query("select * from doctor where email=?;",
                (rs, rowNum) -> mapDoctor(rs),
                new Object[] {email}
        ).stream().findAny().orElse(null);
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

    private Appointment mapAppointment(ResultSet rs) throws SQLException {
        return Appointment.builder()
                .appointmentNumber(rs.getInt("appointment_number"))
                .doctorId(rs.getInt("doctor_id"))
                .clientId(rs.getInt("client_id"))
                .favourId(rs.getInt("favour_id"))
                .workplaceId(rs.getInt("workplace_id"))
                .date(rs.getString("date"))
                .build();
    }

}
