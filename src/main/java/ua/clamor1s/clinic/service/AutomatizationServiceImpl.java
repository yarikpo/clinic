package ua.clamor1s.clinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.clamor1s.clinic.dao.AutomatizationDao;
import ua.clamor1s.clinic.dao.DoctorDao;
import ua.clamor1s.clinic.model.Appointment;
import ua.clamor1s.clinic.model.Client;
import ua.clamor1s.clinic.model.Doctor;

import java.util.List;

@Service
@EnableAsync
public class AutomatizationServiceImpl implements AutomatizationService {

    @Autowired
    private AutomatizationDao dao;
    @Autowired
    private DoctorDao doctorDao;

    @Override
    @Transactional(readOnly = true)
    public List<Appointment> getTodayAppointmentsByDoctorId(int doctorId) {
        return dao.getTodayAppointmentsByDoctorId(doctorId);
    }

    @Override
    public Doctor getDoctorByEmail(String email) {
        return dao.getDoctorByEmail(email);
    }

    @Transactional(readOnly = true)
    private List<Doctor> getAllDoctors() {
        return doctorDao.getAllDoctors();
    }

    @Async
    @Scheduled(fixedDelay = 100000)
    public void scheduleFixedRateTaskAsync() throws InterruptedException {
        System.out.println(
                "Fixed rate task async - " + System.currentTimeMillis() / 1000);
    }



}
