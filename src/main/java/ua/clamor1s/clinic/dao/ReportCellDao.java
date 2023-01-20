package ua.clamor1s.clinic.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.clamor1s.clinic.model.ReportCell;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ReportCellDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public List<ReportCell> getFullReport() {
        return jdbcTemplate.query("select appointment.appointment_number as appointment_number, doctor.doctor_id as doctor_id," +
                " favour.favour_id as favour_id, favour.cost as favour_cost, appointment.date as date from appointment" +
                "  inner join doctor on doctor.doctor_id = appointment.doctor_id" +
                "  inner join favour on favour.favour_id = appointment.favour_id" +
                " where YEAR(CURDATE()) = YEAR(appointment.date);",
                (rs, rowNum) -> mapReportCell(rs)
        );
    }

    public Integer getFullCost() {
        return jdbcTemplate.queryForObject("select sum(favour.cost) as summa from appointment" +
                " inner join favour on favour.favour_id = appointment.favour_id" +
                " where YEAR(CURDATE()) = YEAR(appointment.date);",
                (rs, rowNum) -> rs.getInt("summa")
        );
    }

    private ReportCell mapReportCell(ResultSet rs) throws SQLException {
        return ReportCell.builder()
                .appointmentNumber(rs.getInt("appointment_number"))
                .doctorId(rs.getInt("doctor_id"))
                .favourId(rs.getInt("favour_id"))
                .favourCost(rs.getInt("favour_cost"))
                .date(rs.getDate("date").toString())
                .build();
    }


}
