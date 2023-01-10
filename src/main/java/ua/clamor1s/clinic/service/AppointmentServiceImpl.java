package ua.clamor1s.clinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.clamor1s.clinic.dao.AppointmentDao;
import ua.clamor1s.clinic.model.Appointment;

import java.text.ParseException;
import java.util.List;

@Service
@Transactional
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentDao dao;

    @Override
    @Transactional(readOnly = true)
    public List<Appointment> getAllAppointments() {
        return dao.getAllAppointments();
    }

    @Override
    @Transactional(readOnly = true)
    public Appointment getAppointmentById(int id) {
        return dao.getAppointmentById(id);
    }

    @Override
    public void deleteAppointmentById(int id) {
        dao.deleteAppointmentById(id);
    }

    @Override
    public void createAppointment(Appointment appointment) throws ParseException {
        dao.createAppointment(appointment);
    }

    @Override
    public void updateAppointmentById(int id, Appointment appointment) throws ParseException {
        dao.updateAppointmentById(id, appointment);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Integer> getAllowedDoctorIds() {
        return dao.getAllowedDoctorIds();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Integer> getAllowedClientIds() {
        return dao.getAllowedClientIds();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Integer> getAllowedFavourIds() {
        return dao.getAllowedFavourIds();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Integer> getAllowedWorkplaceIds() {
        return dao.getAllowedWorkplaceIds();
    }
}
