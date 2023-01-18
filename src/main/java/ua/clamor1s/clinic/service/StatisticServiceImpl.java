package ua.clamor1s.clinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.clamor1s.clinic.dao.StatisticDao;
import ua.clamor1s.clinic.model.Statistic;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class StatisticServiceImpl implements StatisticService {

    @Autowired
    private StatisticDao dao;


    @Override
    public List<Statistic> getRequestBody(String statement, Integer clientId) {
        statement = changeStatement(statement, clientId);

        return dao.index(statement);
    }



    @Override
    public Statistic getRequestHead(String statement, Integer clientId) {
        statement = changeStatement(statement, clientId);

        return dao.top(statement);
    }

    private String changeStatement(String statement, Integer clientId) {
        switch (statement) {
            case "favoursByPrice":
                return "select distinct favour.favour_id, favour.name, favour.cost from appointment" +
                        " inner join favour on favour.favour_id = appointment.favour_id" +
                        " inner join client on client.client_id = appointment.client_id" +
                        " where client.client_id = %d".formatted(clientId) +
                        " order by favour.cost desc;";


            case "favoursByAllClients":
                return "select favour.favour_id, favour.name, favour.cost, count(appointment.client_id) as cnt from appointment" +
                        " inner join favour on favour.favour_id = appointment.favour_id" +
                        " inner join client on client.client_id = appointment.client_id" +
                        " group by favour.favour_id, favour.name, favour.cost" +
                        " order by count(appointment.client_id) desc;";
            case "doctorsByHours":
                return "select doctor.doctor_id, doctor.name, count(appointment.doctor_id) as cnt from appointment" +
                        " inner join doctor on doctor.doctor_id = appointment.doctor_id" +
                        " group by doctor.doctor_id, doctor.name" +
                        " order by count(appointment.doctor_id) desc;";
            case "doctorsByMoney":
                return "select doctor.doctor_id, doctor.name, sum(favour.cost) as summa from appointment" +
                        " inner join doctor on doctor.doctor_id = appointment.doctor_id" +
                        " inner join favour on favour.favour_id = appointment.favour_id" +
                        " group by doctor.doctor_id, doctor.name" +
                        " order by sum(favour.cost) desc;";
            default:
                break;
        }
        return statement;
    }

}
