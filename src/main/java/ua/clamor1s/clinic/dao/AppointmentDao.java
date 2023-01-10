package ua.clamor1s.clinic.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.clamor1s.clinic.model.Appointment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Repository
public class AppointmentDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Appointment> getAllAppointments() {
        return jdbcTemplate.query("select appointment_number, doctor_id, client_id, favour_id, workplace_id, DATE_FORMAT(date, '%Y-%m-%d %T') as date from appointment;", (rs, rowNum) -> mapAppointment(rs));
    }

    public Appointment getAppointmentById(int id) {
        return jdbcTemplate.queryForObject("select appointment_number, doctor_id, client_id, favour_id, workplace_id, DATE_FORMAT(date, '%Y-%m-%d %T') as date from appointment where appointment_number=?;",
                (rs, rowNum) -> mapAppointment(rs),
                new Object[] {id}
        );
    }

    public void deleteAppointmentById(int id) {
        jdbcTemplate.update("delete from appointment where appointment_number=?;", id);
    }

    public void createAppointment(Appointment appointment) throws ParseException {
        jdbcTemplate.update("insert into appointment (doctor_id, client_id, favour_id, workplace_id, date)" +
                " values (?, ?, ?, ?, ?);",
                appointment.getDoctorId(),
                appointment.getClientId(),
                appointment.getFavourId(),
                appointment.getWorkplaceId(),
//                new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(appointment.getDate())
                LocalDateTime.parse(appointment.getDate())
        );
    }

    public void updateAppointmentById(int id, Appointment appointment) throws ParseException {
        jdbcTemplate.update("update appointment set doctor_id=?, client_id=?, favour_id=?, workplace_id=?, date=?" +
                " where appointment_number=?;",
                appointment.getDoctorId(),
                appointment.getClientId(),
                appointment.getFavourId(),
                appointment.getWorkplaceId(),
//                new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(appointment.getDate()),
                LocalDateTime.parse(appointment.getDate()),
                id
        );
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

    public List<Integer> getAllowedDoctorIds() {
        return jdbcTemplate.query("select doctor_id from doctor;",
                (rs, rowNum) -> rs.getInt("doctor_id"));
    }

    public List<Integer> getAllowedClientIds() {
        return jdbcTemplate.query("select client_id from client;",
                (rs, rowNum) -> rs.getInt("client_id"));
    }

    public List<Integer> getAllowedFavourIds() {
        return jdbcTemplate.query("select favour_id from favour;",
                (rs, rowNum) -> rs.getInt("favour_id"));
    }

    public List<Integer> getAllowedWorkplaceIds() {
        return jdbcTemplate.query("select workplace_id from workplace;",
                (rs, rowNum) -> rs.getInt("workplace_id"));
    }

}
