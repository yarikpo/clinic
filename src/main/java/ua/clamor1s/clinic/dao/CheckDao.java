package ua.clamor1s.clinic.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.clamor1s.clinic.model.Check;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class CheckDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Check getCheckById(int id) {
        return jdbcTemplate.queryForObject("select appointment.appointment_number as appointment_number, doctor.doctor_id as doctor_id," +
                " doctor.name as doctor_name, client.client_id as client_id, client.name as client_name, favour.favour_id as favour_id," +
                " favour.name as favour_name, favour.cost as favour_cost," +
                " appointment.workplace_id as workplace_id, appointment.date as date from appointment" +
                " inner join doctor on doctor.doctor_id = appointment.doctor_id" +
                " inner join client on client.client_id = appointment.client_id" +
                " inner join favour on favour.favour_id = appointment.favour_id" +
                " where appointment.appointment_number = ?;",
                (rs, rowNum) -> mapCheck(rs),
                new Object[] {id}
        );
    }

    private Check mapCheck(ResultSet rs) throws SQLException {
        return Check.builder()
                .appointmentNumber(rs.getInt("appointment_number"))
                .doctorId(rs.getInt("doctor_id"))
                .doctorName(rs.getString("doctor_name"))
                .clientId(rs.getInt("client_id"))
                .clientName(rs.getString("client_name"))
                .favourId(rs.getInt("favour_id"))
                .favourName(rs.getString("favour_name"))
                .favourCost(rs.getInt("favour_cost"))
                .workplaceId(rs.getInt("workplace_id"))
                .date(rs.getDate("date").toString())
                .build();
    }

}
